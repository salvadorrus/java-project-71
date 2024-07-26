package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Map<String, Object>> compareResult, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.format(compareResult);
            case "json" -> Json.format(compareResult);
            case "plain" -> Plain.format(compareResult);
            default -> throw new RuntimeException("format not supported");
        };
    }
}
