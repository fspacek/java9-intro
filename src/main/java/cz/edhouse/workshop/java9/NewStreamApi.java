package cz.edhouse.workshop.java9;

import java.util.stream.Stream;

/**
 * @author Frantisek Spacek
 */
public class NewStreamApi {


    public static void main(String... args) {
        System.out.println("Take While operation output: ");
        Stream.of(1, 2, 3, 4, 6, 7, 8, 9).takeWhile(n -> n < 6).forEach(System.out::println);

        System.out.println("Drop While operation output: ");
        Stream.of(1, 2, 3, 4, 6, 7, 8, 9).dropWhile(n -> n < 6).forEach(System.out::println);

        System.out.println("Stream from null");
        final Stream<Object> stream = Stream.ofNullable(null);
        System.out.println(stream.count());
    }
}
