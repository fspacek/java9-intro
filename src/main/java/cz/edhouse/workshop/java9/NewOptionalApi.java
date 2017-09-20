package cz.edhouse.workshop.java9;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * New Api for optional JDK 9 is {@link Optional#stream()}, {@link Optional#or(Supplier)}
 * and {@link Optional#ifPresentOrElse(Consumer, Runnable)}.
 *
 * @author Frantisek Spacek
 */
public class NewOptionalApi {

    public static void main(String... args) {

        //new ifPresentOrElse method
        final List<String> strings = List.of("A", "B", "C", "D");
        strings.stream()
                .filter("A"::equals)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("A not found"));

        //or suppliers on optional
        strings.stream()
                .filter("F"::equals)
                .findFirst()
                .or(() -> strings.stream().filter("A"::equals).findFirst())
                .ifPresent(System.out::println);


        //stream api on optional allows to lazy loading
        strings.stream()
                .filter("G"::equals)
                .findFirst().stream()
                .map(NewOptionalApi::someExpensiveMethod)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static int someExpensiveMethod(String a) {
        System.out.println("doing something hard for " + a);
        return a.length();
    }
}
