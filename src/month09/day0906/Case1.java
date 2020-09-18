package month09.day0906;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-06 17:51
 */
public class Case1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> nums = new ArrayList<>();
//        int count = 0;
        for (int i = 0; i < 6; i++) {
            nums.add(in.next());
        }
        int len = nums.size();
        char[] chars = nums.get(len - 2).toCharArray();
        char limit = chars[0];
        String last = nums.get(len - 1);
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i == len - 2) {
                continue;
            }
            String temp = nums.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < temp.length(); j++) {
                if (temp.indexOf(j) < limit) {
                    sb.append(temp.indexOf(j));
                }
                res.add(sb.toString());
            }
        }
        String relate = res.get(res.size() - 1);
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i).contains(relate)) {
                ans.add(res.get(i));
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
