package cz.edhouse.workshop.java9;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.Arrays.asList;

/**
 * Created by expi on 14.03.2017.
 */
public class NewProcessBuilderApi {

    public static void main(String... args) throws IOException {
        final ProcessBuilder ls = new ProcessBuilder()
                .command("ls")
                .directory(Paths.get("/Users/expi/Downloads").toFile());

        final ProcessBuilder grepPdf = new ProcessBuilder()
                .command("grep", "epub")
                .redirectOutput(ProcessBuilder.Redirect.INHERIT);
        final List<Process> lsThenGrep = ProcessBuilder
                .startPipeline(asList(ls, grepPdf));

        final CompletableFuture[] lsThenGrepFutures = lsThenGrep.stream()
                // onExit returns a CompletableFuture<Process>
                .map(Process::onExit)
                .map(processFuture -> processFuture.thenAccept(
                        process -> System.out.println("PID: " + process.pid())))
                .toArray(CompletableFuture[]::new);
// wait until all processes are finished
        CompletableFuture
                .allOf(lsThenGrepFutures)
                .join();
    }
}
