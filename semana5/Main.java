package semana5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numeros = {5, 2, 8, 1, 3};

        System.out.println("Array original: " + Arrays.toString(numeros)); // Imprime [5, 2, 8, 1, 3]

        Arrays.sort(numeros); // Ordena el array

        System.out.println("Array ordenado: " + Arrays.toString(numeros)); // Imprime [1, 2, 3, 5, 8]

        int indice = Arrays.binarySearch(numeros, 3); // Busca el valor 3
        System.out.println("Índice del valor 3: " + indice); // Imprime 2 (la posición del valor 3)

        Arrays.fill(numeros, 0); // Rellena el array con ceros

        System.out.println("Array con ceros: " + Arrays.toString(numeros)); // Imprime [0, 0, 0, 0, 0]
    }
}