package cz.edhouse.workshop.java9;

import java.time.Duration;
import java.time.Instant;

/**
 * Java 9 brings ProcessHandle which provides useful information about processes.
 *
 * @author Frantisek Spacek
 */
public class NewProcessHandleApi {

    public static void main(String... arg) {
        final ProcessHandle currentProcess = ProcessHandle.current();
        printProcessDetails(currentProcess);

        ProcessHandle.allProcesses().forEach(NewProcessHandleApi::printProcessDetails);

    }

    private static void printProcessDetails(ProcessHandle process) {
        //Get the instance of process info
        final ProcessHandle.Info currentProcessInfo = process.info();
        if (currentProcessInfo.command().orElse("").equals("")) {
            return;
        }
        System.out.printf("Details for process with PID%d%n", process.getPid());
        //Get the command pathname of the process
        System.out.printf("Command: %s%n", currentProcessInfo.command().orElse(""));
        //Get the arguments of the process
        final String[] arguments = currentProcessInfo.arguments().orElse(new String[]{});
        if (arguments.length > 0) {
            System.out.print("Arguments: ");
            for (String arg : arguments) {
                System.out.print(arg + " ");
            }
            System.out.println();
        }
        //Get the start time of the process
        System.out.printf("Started at: %s%n", currentProcessInfo.startInstant().orElse(Instant.now()).toString());
        //Get the time the process ran for
        System.out.printf("Ran for: %dms%n", currentProcessInfo.totalCpuDuration().orElse(Duration.ofMillis(0)).toMillis());
        //Get the owner of the process
        System.out.printf("Owner: %s%n", currentProcessInfo.user().orElse(""));
    }
}
