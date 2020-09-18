package month09.didi;

import java.time.temporal.Temporal;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-13 18:58
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        int len = s.length();
        int count = len / n;
        String[] temp;
        if (len % n == 0) {
            temp = new String[count];
        } else {
            temp = new String[count + 1];
        }
        for (int i = 0; i < s.length(); i = i + n) {
            int end;
            if (i + n > s.length()) {
                end = s.length();
            } else {
                end = i + n;
            }
            temp[i / n] = s.substring(i, end);
            StringBuffer ss = new StringBuffer(temp[i / n]);
            ss.reverse();
            temp[i / n] = ss.toString();
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            res.append(temp[i]);
        }
        System.out.println(res);
    }
}
