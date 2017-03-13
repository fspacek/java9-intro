package cz.edhouse.workshop.java9;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Simple examples for new Collections Factory Methods.
 *
 * @author Frantisek Spacek
 */
public class CollectionsFactoryMethods {

    public static void main(String... args) {
        final List<String> immutableListOfStrings = List.of("a", "b", "c");
        immutableListOfStrings.forEach(System.out::println);

        try {
            immutableListOfStrings.add("d");
        } catch (UnsupportedOperationException expected) {
            System.out.println("Immutable collection cannot be changed");
        }

        final Set<String> immutableSetOfStrings = Set.of("a", "b", "c");
        immutableSetOfStrings.forEach(System.out::println);

        final Map<String, String> immutableMapOfStrings = Map.of("k1", "a", "k2", "b");
        printMap(immutableMapOfStrings);

        final Map<String, String> immutableMapOfStrings2 = Map.ofEntries(Map.entry("k1", "a"));
        printMap(immutableMapOfStrings2);
    }

    private static void printMap(Map<String, String> map) {
        map.forEach((k, v) -> {
            System.out.print("Key " + k);
            System.out.println(" Value " + v);
        });
    }
}
