package sourceCode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @hurusea
 * @create2020-07-18 14:10
 */
public class HashMapLearn {

    @Test
    public void test10() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "hurusea");
        map.put("name", "hurusea");
        map.put(null, "test");
        map.put("test", null);
        map.put(null, null);
        System.out.println(map);
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
        Hashtable<String, String> hashtable = new Hashtable<>();
        HashSet<Object> objects = new HashSet<>();
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        map.entrySet().stream().forEach(item->{
            System.out.println(item.getKey());
            System.out.println(item.getValue());
        });


    }
}
