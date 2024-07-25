package hexlet.code;


import java.util.*;

public class Comparator {
    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {

        List<Map<String, Object>> resultList = new ArrayList<>();

        Set<String> keys = new TreeSet<>();
        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        for (var key : keys) {
            Map<String, Object> result = new LinkedHashMap<>();
            result.put("key", key);
            if (!file1.containsKey(key)) {
                result.put("oldValue", file1.get(key));
                result.put("status", "added");
            } else if (!file2.containsKey(key)) {
                result.put("newValue", file2.get(key));
                result.put("status", "deleted");
            } else if (!Objects.equals(file1.get(key), file2.get(key))) {
                result.put("newValue", file1.get(key));
                result.put("oldValue", file1.get(key));
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
