import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class APIClient {
    private static final String API_KEY = "912d525b88f740240e9ab44948f9ee34";
    private static final String BASE_URL = "http://data.fixer.io/api/latest?access_key=" + API_KEY;

    // Método para obtener las tasas de cambio desde la API
    public Map<String, Double> obtenerTasasDeCambio() throws Exception {
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == 200) {
                Gson gson = new Gson();
                InputStreamReader lector = new InputStreamReader(conexion.getInputStream());
                RespuestaAPI respuesta = gson.fromJson(lector, RespuestaAPI.class);
                return respuesta.rates;
            } else {
                throw new Exception("Error en la conexión a la API. Código de respuesta: " + codigoRespuesta);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener tasas de cambio desde la API: " + e.getMessage());
            return cargarTasasDesdeArchivo("tasas_cambio.txt");
        }
    }

    // Método para cargar tasas de un archivo
    private Map<String, Double> cargarTasasDesdeArchivo(String archivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            Gson gson = new Gson();
            RespuestaAPI respuesta = gson.fromJson(br, RespuestaAPI.class);
            return respuesta.rates;
        } catch (Exception e) {
            System.out.println("Error al cargar tasas desde el archivo: " + e.getMessage());
            return null;
        }
    }

    private class RespuestaAPI {
        public Map<String, Double> rates;
    }
}
