package cz.edhouse.workshop.java9;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

import static java.lang.String.format;

/**
 * Java 9 contains implementation of SHA3 algorithms according FIPS.
 *
 * @author Frantisek Spacek
 */
public class SHA3Support {

    public static void main(String... args) throws NoSuchAlgorithmException {
        final Set<String> newAlgorithms = Set.of("SHA3-224", "SHA3-256","SHA3-384","SHA3-512");
        newAlgorithms.forEach(SHA3Support::printHelloWorldMessageDigest);
    }

    private static void printHelloWorldMessageDigest(String algorithm) {
        final MessageDigest instance;
        try {
            instance = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(format("Requested algorithm %s not found", algorithm));
            return;
        }
        final byte[] digest = instance.digest("helloworld".getBytes());
        System.out.printf("%s: %s%n", algorithm, DatatypeConverter.printHexBinary(digest));
    }
}
