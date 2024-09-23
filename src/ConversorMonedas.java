import java.util.*;

public class ConversorMonedas {
    private APIClient apiClient;
    private Map<String, Double> tasas;
    private List<Moneda> conversiones;

    public ConversorMonedas() {
        apiClient = new APIClient();
        conversiones = new ArrayList<>();
        try {
            tasas = apiClient.obtenerTasasDeCambio();
        } catch (Exception e) {
            System.out.println("Error obteniendo las tasas de cambio: " + e.getMessage());
        }
    }

    public void convertir(String monedaObjetivo, double cantidad) {
        if (tasas != null && tasas.containsKey(monedaObjetivo)) {
            double tasaCambio = tasas.get(monedaObjetivo);
            double resultado = cantidad * tasaCambio;
            Moneda moneda = new Moneda(monedaObjetivo, tasaCambio);
            conversiones.add(moneda);
            System.out.printf("%.2f [ EUR ] son %.2f [%s]\n", cantidad, resultado, monedaObjetivo);
        } else {
            System.out.println("Moneda no disponible o error en las tasas de cambio.");
        }
    }

    public List<Moneda> getConversiones() {
        return conversiones;
    }
}
