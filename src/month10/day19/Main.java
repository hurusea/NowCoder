package month10.day19;

import org.junit.Test;

import java.util.*;

/**
 * @hurusea
 * @create2020-10-19 20:17
 */
public class Main {
    public String character_auto_complete(String str) {
        if (str=="") {
            return "No match";
        }
        TreeSet<String> treeSet = new TreeSet<>();
        HashSet<String> set = new HashSet<>();
        treeSet.add("Monday");
        treeSet.add("Tuesday");
        treeSet.add("Wednesday");
        treeSet.add("Thursday");
        treeSet.add("Friday");
        treeSet.add("Saturday");
        treeSet.add("Sunday");
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (String s : treeSet) {
            if (s.contains(str)) {
                flag = true;
                sb.append(s);
                sb.append(" ");
            }
        }
        if (flag) {
            return sb.toString().trim();
        } else {
            return "No match";
        }
    }

    @Test
    public void testMatch() {
        String str = "S";
        String res = character_auto_complete(str);
        System.out.println(res);
    }

    public int sub(String input) {
        String[] split = input.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (String s : split) {
            int temp = Integer.parseInt(s);
            if (temp != 0) {
                count++;
                list.add(temp);
            }
        }
        Collections.sort(list);
        if (count >= 3) {
            int max = list.get(count - 1) * 100 + list.get(count - 2) * 10 + list.get(count - 3);
            int min;
            if (count>=6) {
                min = list.get(0) * 100 + list.get(1) * 10 + list.get(2);
            } else if (count == 5) {
                min = list.get(0) * 100 + list.get(1);
            } else {
                min = list.get(0) * 100;
            }
            if (max == min) {
                return -1;
            } else {
                return max - min;
            }
        } else {
            return -1;
        }
    }

    @Test
    public void test() {
        int res = sub("0 9 9 9 9 9");
        System.out.println(res);
    }
}
