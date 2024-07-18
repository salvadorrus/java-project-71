package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name = "Demo", mixinStandardHelpOptions = true)
public class App implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path of first file")
    private String filepath1;

    @CommandLine.Parameters(index = "0", paramLabel = "filepath2", description = "path of second file")
    private String filepath2;

    @CommandLine.Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            defaultValue = "stylish",
            description = "output format [default: stylish]"
    )
    private String format;

    @Override
    public Integer call() throws Exception {
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
