package semana13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
         // 1. Ejemplo de gestión de un sistema de estudiantes
         ejemploSistemaEstudiantes();
        
         // 2. Ejemplo de un carrito de compras
         ejemploCarritoCompras();
         
         // 3. Ejemplo de contador de frecuencias
         ejemploContadorFrecuencias();        
         
    }

    // Ejemplo 1: Sistema de gestión de estudiantes
    public static void ejemploSistemaEstudiantes() {
        System.out.println("\n=== Sistema de Estudiantes ===");

        // Crear HashMap para almacenar estudiantes (ID -> Calificaciones)
        HashMap<Integer, ArrayList<Double>> calificacionesEstudiantes = new HashMap<>();

        // Agregar calificaciones para algunos estudiantes
        ArrayList<Double> calificacionesAlumno1 = new ArrayList<>();
        calificacionesAlumno1.addAll(Arrays.asList(8.5, 9.0, 7.8));
        calificacionesEstudiantes.put(101, calificacionesAlumno1);

        ArrayList<Double> calificacionesAlumno2 = new ArrayList<>();
        calificacionesAlumno2.addAll(Arrays.asList(6.5, 8.2, 9.3));
        calificacionesEstudiantes.put(102, calificacionesAlumno2);

        // Calcular promedio para cada estudiante
        calificacionesEstudiantes.forEach((id, calificaciones) -> {
            double promedio = calificaciones.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
            System.out.printf("Estudiante ID %d - Promedio: %.2f%n", id, promedio);
        });

        // Agregar nueva calificación a un estudiante existente
        calificacionesEstudiantes.computeIfPresent(101, (id, calificaciones) -> {
            calificaciones.add(8.7);
            return calificaciones;
        });

        // Verificar si un estudiante existe
        int idBuscar = 103;
        System.out.println("¿Existe estudiante " + idBuscar + "? " +
                calificacionesEstudiantes.containsKey(idBuscar));
    }

    // Ejemplo 2: Carrito de compras
    public static void ejemploCarritoCompras() {
        System.out.println("\n=== Carrito de Compras ===");

        // HashMap para almacenar productos y cantidades
        HashMap<String, Integer> carrito = new HashMap<>();

        // Agregar productos
        carrito.put("Manzanas", 3);
        carrito.put("Leche", 2);
        carrito.put("Pan", 1);

        // Incrementar cantidad de un producto
        carrito.merge("Manzanas", 2, Integer::sum);

        // Mostrar carrito
        System.out.println("Contenido del carrito:");
        carrito.forEach((producto, cantidad) -> System.out.println(producto + ": " + cantidad + " unidades"));

        // Remover un producto si la cantidad es 0
        carrito.merge("Pan", -1, (actual, incremento) -> {
            int resultado = actual + incremento;
            return resultado <= 0 ? null : resultado;
        });

        // Mostrar total de productos
        int totalProductos = carrito.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total de productos: " + totalProductos);
    }

    // Ejemplo 3: Contador de frecuencias de palabras
    public static void ejemploContadorFrecuencias() {
        System.out.println("\n=== Contador de Frecuencias ===");

        String texto = "java es un lenguaje java es orientado a objetos java";
        HashMap<String, Integer> frecuencias = new HashMap<>();

        // Contar frecuencias
        Arrays.stream(texto.toLowerCase().split(" "))
                .forEach(palabra -> frecuencias.merge(palabra, 1, Integer::sum));

        // Mostrar resultados ordenados por frecuencia
        frecuencias.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entrada -> System.out.println(entrada.getKey() +
                        ": " + entrada.getValue() + " veces"));
    }

   
}