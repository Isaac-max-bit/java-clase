package semana7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listaCompras = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("Opciones:");
            System.out.println("1. Agregar artículo");
            System.out.println("2. Eliminar artículo");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Finalizar compra");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese el nombre del artículo: ");
                String articulo = scanner.next();
                listaCompras.add(articulo);
            } else if (opcion == 2) {
                System.out.print("Ingrese el nombre del artículo a eliminar: ");
                String articuloEliminar = scanner.next();
                for (int i = 0; i < listaCompras.size(); i++) {
                    if (listaCompras.get(i).equals(articuloEliminar)) {
                        listaCompras.remove(i);
                        System.out.println("Artículo eliminado.");
                        continue;
                    }
                }
                System.out.println("Artículo no encontrado.");
            } else if (opcion == 3) {
                System.out.println("Lista de compras:");
                for (int i = 0; i < listaCompras.size(); i++) {
                    System.out.println(listaCompras.get(i));
                }
            } else if (opcion == 4) {
                System.out.println("Gracias por su compra!");
                break;
            }
        }
    }
}
