import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println("\n Using Streams");
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

    }
}
