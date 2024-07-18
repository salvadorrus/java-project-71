package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) {
        String file1 = readFile(filePath1);
        String file2 = readFile(filePath2);

        String fileFormat1 = getFileType(filePath1);
        String fileFormat2 = getFileType(filePath2);

        Map<String, Object> files1 = Parser.parse(file1, fileFormat1);
        Map<String, Object> files2 = Parser.parse(file2, fileFormat2);

        List<Map<String, Object>> result = Comparator.compare(files1, files2);

        return Formater.format(result);
    }

    public static String readFile(String filePath){
        // Читаем содержимое файла
        return "";
    }

    private static String getFileType(String filePath) {
        // возвращает расширение файла (json, yml, yaml)
        // сплитим по точке
        return "";
    }

    private static String format(List<Map<String, Object>> result, String format) {
         return switch (format) {
            case "stylish" -> Formater.format(result);
             default -> throw new RuntimeException("format not supported");
        };
    }
}
