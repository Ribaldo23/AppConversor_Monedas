import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GestorArchivos {
    private String rutaArchivo;

    public GestorArchivos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void escribirConversiones(List<Moneda> conversiones) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            for (Moneda moneda : conversiones) {
                writer.write(moneda.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo en el archivo: " + e.getMessage());
        }
    }
}
