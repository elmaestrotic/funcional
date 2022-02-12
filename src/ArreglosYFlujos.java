import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArreglosYFlujos {
    public static void main(String[] args) {
        Integer[] valores = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        // muestra los valores originales del array
        System.out.printf("Valores originales: %s%n", Arrays.asList(valores));
        // ordena los valores en forma ascendente con flujos
        System.out.printf("Valores ordenados: %s%n",
                Arrays.stream(valores)
                        .sorted()
                        .collect(Collectors.toList()));

        // valores mayores que 4
        List<Integer> mayorQue4 =
                Arrays.stream(valores)
                        .filter(value -> value > 4)
                        .collect(Collectors.toList());
        System.out.printf("Valores mayores que 4: %s%n", mayorQue4);

        // filtra los valores mayores que 4 y luego ordena los resultados
        System.out.printf("Valores ordenados mayores que 4: %s%n",
                Arrays.stream(valores)
                        .filter(value -> value > 4)
                        .sorted()
                        .collect(Collectors.toList()));

        // objeto List mayorQue4 ordenado con flujos
        System.out.printf(
                "Valores mayores que 4 (ascendente con flujos): %s%n",
                mayorQue4.stream()
                        .sorted()
                        .collect(Collectors.toList()));
    }
} // fin de la clase ArreglosYFlujos

