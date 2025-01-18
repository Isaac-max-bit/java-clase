package semana10;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menú del restaurante (usando listas)
        List<String[]> menu = new ArrayList<>();
        menu.add(new String[] {"Pizza Margherita", "10.0"});
        menu.add(new String[] {"Pasta Carbonara", "8.5"});
        menu.add(new String[] {"Ensalada César", "7.0"});
        menu.add(new String[] {"Hamburguesa", "9.5"});

        // Orden del cliente (usando listas)
        List<String[]> orden = new ArrayList<>();
        double total = 0;

        // Mostrar el menú y pedir al usuario que agregue platos
        mostrarMenu(menu);
        while (true) {
            System.out.println("Ingrese el nombre del plato a agregar (o 'fin' para terminar):");
            String nombrePlato = scanner.nextLine();
            if (nombrePlato.equalsIgnoreCase("fin")) {
                break;
            }
            String[] plato = encontrarPlato(menu, nombrePlato);
            if (plato != null) {
                orden.add(plato);
                total += Double.parseDouble(plato[1]);
            } else {
                System.out.println("Plato no encontrado en el menú.");
            }
        }

        // Mostrar la orden completa
        mostrarOrden(orden, total);

        // Calcular el total con descuento
        double descuento = aplicarDescuento(total, 10);
        System.out.println("Total con descuento del 10%: $" + descuento);

        scanner.close();
    }

    // Método para mostrar el menú
    static void mostrarMenu(List<String[]> menu) {
        System.out.println("Menú:");
        for (String[] plato : menu) {
            System.out.println("- " + plato[0] + " - $" + plato[1]);
        }
    }

    // Método para encontrar un plato en el menú
    static String[] encontrarPlato(List<String[]> menu, String nombre) {
        // Normalizar la entrada del usuario
        nombre = normalizeString(nombre);
        
        for (String[] plato : menu) {
            // Normalizar el nombre del plato en el menú
            if (normalizeString(plato[0]).equalsIgnoreCase(nombre)) {
                return plato;
            }
        }
        return null;
    }

    // Método para normalizar una cadena (eliminar acentos)
    static String normalizeString(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    // Método para mostrar la orden completa
    static void mostrarOrden(List<String[]> orden, double total) {
        System.out.println("Orden:");
        for (String[] plato : orden) {
            System.out.println("- " + plato[0] + " - $" + plato[1]);
        }
        System.out.println("Total: $" + total);
    }

    // Método para aplicar un descuento
    static double aplicarDescuento(double total, double porcentaje) {
        return total - (total * (porcentaje / 100));
    }
}
