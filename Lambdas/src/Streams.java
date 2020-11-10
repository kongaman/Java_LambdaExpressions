import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");
        // Without using streams
        List<String> gNumbers = new ArrayList<>();
        someBingoNumbers.forEach(number -> {
            if(number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });
        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2)); // "String" is optional
        gNumbers.forEach(s -> System.out.println(s));
        //using stream
        System.out.println("\nUsing Streams");
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);
        System.out.println("====================");
        // Creating a Stream from scratch
        // Items in the stream have to be of the same type
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        // System.out.println(concatStream.count()); //count all items
        System.out.println(concatStream.distinct().peek(System.out::println).count()); // count all unique items

    }
}
