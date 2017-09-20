package cz.edhouse.workshop.java9;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;

/**
 * Example of usage for the new HttpClient, which is part of incubator module.
 * @author Frantisek Spacek
 */
public class EmbeddedHttpClient {

    private static final String EDHOUSE_CZ = "http://edhouse.cz/";

    public static void main(String... args) throws Exception {
        final HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        final HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(new URI(EDHOUSE_CZ)).build();
        final HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandler.asString());
        System.out.println(response.body());
    }
}
