package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;


class DifferTest {
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    private static String getPath(String filePath) throws Exception {
        var readPath = Paths.get("src/test/resources", filePath).toAbsolutePath().normalize();
        return Files.readString(readPath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = getPath("resultJson.json");
        resultPlain = getPath("resultPlain.txt");
        resultStylish = getPath("resultStylish.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void diffTest(String format) throws Exception {
        var resultPath1 = getPath("filepath1." + format);
        var resultPath2 = getPath("filepath2." + format);

        assertEquals(Differ.generate(resultPath1, resultPath2), resultStylish);
        assertEquals(Differ.generate(resultPath1, resultPath2, "json"), resultJson);
        assertEquals(Differ.generate(resultPath1, resultPath2, "plain"), resultPlain);
        assertEquals(Differ.generate(resultPath1, resultPath2, "stylish"), resultStylish);


    }
}
