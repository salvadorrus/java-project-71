package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> result) throws Exception {
        StringBuilder resultBuilder = new StringBuilder();
        for (Map<String, Object> diff : result) {
            switch (diff.get("status").toString()) {
                case "deleted" -> resultBuilder.append("Property ")
                        .append("'")
                        .append(diff.get("key"))
                        .append("'").append(" was removed")
                        .append("\n");
                case "added" -> resultBuilder.append("Property ")
                        .append(value(diff.get("key")))
                        .append(" was added with value: ")
                        .append(value(diff.get("oldValue")))
                        .append("\n");
                case "changed" -> resultBuilder.append("Property ")
                        .append(value(diff.get("key")))
                        .append(" was updated. From ")
                        .append(value(diff.get("newValue")))
                        .append(" to ")
                        .append(value(diff.get("oldValue")))
                        .append("\n");
                case "unchanged" -> {
                }
                default -> throw new Exception("format not supported");
            }
        }
        return resultBuilder.toString().trim();
    }

    public static String value(Object value) {
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value == null) {
            return null;
        }
        return value.toString().trim();
    }
}
