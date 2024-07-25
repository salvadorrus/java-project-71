package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String format) throws Exception {
        if (format.equals("json")) {
            return new ObjectMapper().readValue(content, new TypeReference<>() { });
        } else if (format.equals("yml") || format.equals("yaml")) {
            return new YAMLMapper().readValue(content, new TypeReference<>() { });
        } else {
            throw new RuntimeException("format not supported");
        }
    }
}
