package month09.day0920;

import java.util.*;

/**
 * @hurusea
 * @create2020-09-20 16:41
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder(s);
        String substring = sb.substring(1, sb.length() - 1);
        String[] split = substring.split(",");
        int len = split.length;
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Integer temp = Integer.valueOf(split[i].trim());
            if (!set.contains(temp)) {
                set.add(temp);
            } else {
                res.add(temp);
            }
        }
        HashSet<Integer> setTemp = new HashSet<>();
        for (int i = 0; i < res.size(); i++) {
            setTemp.add(res.get(i));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer integer : setTemp) {
            ans.add(integer);
        }
        Collections.sort(ans);
        System.out.println(ans.toString());
    }
}
