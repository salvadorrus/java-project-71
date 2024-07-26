package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Comparator {
    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {

        List<Map<String, Object>> resultList = new ArrayList<>();

        Set<String> keys = new TreeSet<>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        for (var key : keys) {
            Map<String, Object> result = new LinkedHashMap<>();
            result.put("key", key);
            if (!file2.containsKey(key)) {
                result.put("newValue", file1.get(key));
                result.put("status", "deleted");
            } else if (!file1.containsKey(key)) {
                result.put("oldValue", file2.get(key));
                result.put("status", "added");
            } else if (!Objects.equals(file1.get(key), file2.get(key))) {
                result.put("newValue", file1.get(key));
                result.put("oldValue", file2.get(key));
                result.put("status", "changed");
            } else {
                result.put("newValue", file1.get(key));
                result.put("status", "unchanged");
            }
            resultList.add(result);
        }
        return resultList;
    }
}
