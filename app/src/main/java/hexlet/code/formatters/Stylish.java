package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> differ) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> diff : differ) {
            switch (diff.get("status").toString()) {
                case "deleted" -> result.append("  - ").append(diff.get("key")).append(": ")
                        .append(diff.get("newValue")).append("\n");
                case "added" -> result.append("  + ").append(diff.get("key")).append(": ")
                        .append(diff.get("oldValue")).append("\n");
                case "unchanged" -> result.append("    ").append(diff.get("key")).append(": ")
                        .append(diff.get("newValue")).append("\n");
                default -> {
                    result.append("  - ").append(diff.get("key")).append(": ")
                            .append(diff.get("newValue")).append("\n");
                    result.append("  + ").append(diff.get("key")).append(": ")
                            .append(diff.get("oldValue")).append("\n");
                }
            }

        }
        result.append("}");
        return result.toString();
    }
}