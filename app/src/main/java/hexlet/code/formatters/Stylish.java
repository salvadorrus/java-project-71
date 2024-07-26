package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> result) {
        StringBuilder resultBuilder = new StringBuilder("{\n");
        for (Map<String, Object> diff : result) {
            switch (diff.get("status").toString()) {
                case "deleted" -> resultBuilder.append("  - ").append(diff.get("key")).append(": ")
                        .append(diff.get("newValue")).append("\n");
                case "added" -> resultBuilder.append("  + ").append(diff.get("key")).append(": ")
                        .append(diff.get("oldValue")).append("\n");
                case "unchanged" -> resultBuilder.append("    ").append(diff.get("key")).append(": ")
                        .append(diff.get("newValue")).append("\n");
                default -> {
                    resultBuilder.append("  - ").append(diff.get("key")).append(": ")
                            .append(diff.get("newValue")).append("\n");
                    resultBuilder.append("  + ").append(diff.get("key")).append(": ")
                            .append(diff.get("oldValue")).append("\n");
                }
            }

        }
        return resultBuilder.append("}").toString();
    }
}
