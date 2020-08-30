package day0825;

import java.util.*;

/**
 * @hurusea
 * @create2020-08-25 19:39
 */
public class Solution {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        HashSet<Object> hashSet = new HashSet<>();

        hashMap.put("name", "sea");
        hashMap.put(null, "sea");
        hashMap.put(null, null);
        hashMap.put("age", null);
        hashtable.put("name", "sea");
        hashtable.put("age", 20);
        hashtable.put("notNull", "testNull");
        hashSet.add("sea");
        hashSet.add("sea");
        hashSet.add(null);

        Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + "=====hashMap======" + entry.getValue());
        }
        Set<Map.Entry<Object, Object>> entrySet = hashtable.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            System.out.println(entry.getKey() + "=====hashTable======" + entry.getValue());
        }
        for (Object entry : hashSet) {
            System.out.println(entry+ "=====hashSet======");
        }
    }
}
