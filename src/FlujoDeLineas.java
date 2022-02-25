import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FlujoDeLineas {
    public static void main(String[] args) throws IOException {
        // Expresión regular que coincide con uno o más caracteres consecutivos de
        //espacio en blanco
        Pattern patron = Pattern.compile("\\s +");

        // cuenta las ocurrencias de cada palabra en un Stream<String> ordenado
        //por palabra
        Map<String, Long> cuentasPalabras =
                Files.lines(Paths.get("Texto.txt"))
                        .map(line -> line.replaceAll("( ? !')\\p{P}",""))
                        .flatMap(line -> patron.splitAsStream(line))
                        .collect(Collectors.groupingBy(String::toLowerCase,
                        TreeMap::new, Collectors.counting()));

        // muestra las palabras agrupadas por letra inicial
        cuentasPalabras.entrySet()
                .stream()
                .collect(
                        Collectors.groupingBy(entry -> entry.getKey().charAt(0),
                                TreeMap::new, Collectors.toList()))
                .forEach((letra, wordList) ->
                {
                    System.out.printf("%n%C%n", letra);
                    wordList.stream().forEach(word -> System.out.printf(
                            "%13s: %d%n", word.getKey(), word.getValue()));
                });
    }
} // fin de la clase FlujoDeLineas


