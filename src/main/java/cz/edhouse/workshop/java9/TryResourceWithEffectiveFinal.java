package cz.edhouse.workshop.java9;

import java.io.StringReader;
import java.util.Scanner;

/**
 * @author Frantisek Spacek
 */
public class TryResourceWithEffectiveFinal {

    public static final String SIMPLE_STRING = "str";

    public static void main(String... args){
        StringReader reader = new StringReader(SIMPLE_STRING);
        Scanner scanner = new Scanner(reader);
        try(scanner; reader){
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        }
    }


}
