import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Challenge {

    public static void main(String[] args) {

        //Challenge #1
        Runnable runnable = () -> {
            String s = "Lets split this up into array";
            String[] parts = s.split(" ");
            for (String part : parts){
                System.out.println(part);
            }
        };

        //Challenge #2
        Function<String, String> lambdaFu = (s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        //Challenge #3
        System.out.println("Challenge #3");
        System.out.println(lambdaFu.apply("1234567890"));

        //Challenge #5
        System.out.println("Challenge #5");
        System.out.println(everySecondCharacter(lambdaFu, "1234567890"));

        //Challenge #6
        Supplier<String> iLoveJava = () -> "I love Java!";

        //Challenge #7
        String supplierResult = iLoveJava.get();
        System.out.println("Challenge #7");
        System.out.println(supplierResult);

        //Challenge #9
        List<String> topNames2015 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack",
                "Charie", "harry", "Jacob");
        System.out.println("Challenge #9");
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name -> firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
        firstUpperCaseList.sort((s1,s2) -> s1.compareTo(s2));
        firstUpperCaseList.forEach(s -> System.out.println(s));

        //Challenge #10
        List<String> topNames2015_2 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack",
                "Charie", "harry", "Jacob");
        System.out.println("Challenge #10");
        List<String> firstUpperCaseList_2 = new ArrayList<>();
        topNames2015.forEach(name -> firstUpperCaseList_2.add(name.substring(0,1).toUpperCase() + name.substring(1)));
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        //Challenge #11
        List<String> topNames2015_3 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack",
                "Charie", "harry", "Jacob");
        System.out.println("Challenge #11");
        topNames2015_3.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        //Challenge #12
        List<String> topNames2015_4 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack",
                "Charie", "harry", "Jacob");
        System.out.println("Challenge #12");
        long countNamesWithA = topNames2015_4.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(s -> s.startsWith("A"))
                .count();
        System.out.println("Numer of names beginning with A: " + countNamesWithA);

        //Challenge #13
        List<String> topNames2015_5 = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack",
                "Charie", "harry", "Jacob");
        System.out.println("Challenge #13");
        topNames2015_3.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

    }

    //Challenge #4
    public static String everySecondCharacter(Function<String, String> func, String s) {
        return func.apply(s).toString();
    }
}
