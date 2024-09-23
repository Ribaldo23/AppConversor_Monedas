import java.util.Scanner;

public class AppConversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorMonedas conversor = new ConversorMonedas();
        GestorArchivos gestorArchivos = new GestorArchivos("conversiones.txt");

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();

            if (opcion == 8) {
                continuar = false;
                System.out.println("Saliendo...");
                gestorArchivos.escribirConversiones(conversor.getConversiones());
            } else {
                System.out.print("Ingresa la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();

                String monedaObjetivo = obtenerMonedaObjetivo(opcion);
                if (monedaObjetivo != null) {
                    conversor.convertir(monedaObjetivo, cantidad);
                    System.out.print("¿Quieres guardar esta conversión en el archivo? (s/n): ");
                    char guardar = scanner.next().charAt(0);
                    if (guardar == 's' || guardar == 'S') {
                        gestorArchivos.escribirConversiones(conversor.getConversiones());
                        System.out.println("Conversión guardada.");
                    }
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nConversor de Monedas:");
        System.out.println("1. EUR a USD");
        System.out.println("2. EUR a GBP");
        System.out.println("3. EUR a JPY");
        System.out.println("4. EUR a AUD");
        System.out.println("5. EUR a CAD");
        System.out.println("6. EUR a CHF");
        System.out.println("7. EUR a CNY");
        System.out.println("8. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static String obtenerMonedaObjetivo(int opcion) {
        switch (opcion) {
            case 1: return "USD";
            case 2: return "GBP";
            case 3: return "JPY";
            case 4: return "AUD";
            case 5: return "CAD";
            case 6: return "CHF";
            case 7: return "CNY";
            default: return null;
        }
    }
}
