package tencent;

import java.util.Collections;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-26 19:18
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();
        StringBuilder s = new StringBuilder(str);
        char c;

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ']') {
                int left = i, mid;
                while (s.charAt(--left) != '|') ;
                mid = left;
                while (s.charAt(--left) != '[') ;
                int times = Integer.parseInt(s.substring(left + 1, mid));
                String newStr = s.substring(mid + 1, i);
                newStr = String.join("", Collections.nCopies(times, newStr));

                s.replace(left, i + 1, newStr);
                i = left;
            }
        }
        System.out.println(s);
    }

}
