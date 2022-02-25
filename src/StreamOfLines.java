// Exercise 17.10: StreamOfLines.java
// Counting word occurrences in a text file.
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamOfLines {
   public static void main(String[] args) throws IOException {
      // count occurrences of each letter in a Stream<String> sorted by letter
      Map<String, Long> characterCounts = 
         Files.lines(Paths.get("Chapter2Paragraph.txt"))
              .map(line -> line.replaceAll("\\W", ""))
              .map(String::toUpperCase)
              .flatMapToInt(String::chars)
              .mapToObj(c -> (char) c)
              .collect(Collectors.groupingBy(String::valueOf,
                 TreeMap::new, Collectors.counting()));
 
      // display the letters grouped by starting letter
      characterCounts.entrySet()
         .stream()
         .filter(entry -> !entry.getKey().isEmpty())
         .forEach(entry -> { 
               System.out.printf("%s: %d%n", 
                  entry.getKey(), entry.getValue());
            }); 
   }
}

