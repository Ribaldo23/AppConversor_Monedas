public class Moneda {
    private String nombre;
    private double tasaCambio;

    public Moneda(String nombre, double tasaCambio) {
        this.nombre = nombre;
        this.tasaCambio = tasaCambio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTasaCambio() {
        return tasaCambio;
    }

    @Override
    public String toString() {
        return "Moneda: " + nombre + " | Tasa de Cambio: " + tasaCambio;
    }
}
