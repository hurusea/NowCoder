package day0829;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-29 15:50
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        int low = 0;
        int high = s.length() - 1;
        boolean flag1 = false;
        boolean flag2 = false;
        int begin = 0;
        int end = 0;
        while (low < high && (begin != low || end != high)) {
            if (s.charAt(low) == 'M') flag1 = true;
            if (s.charAt(high) == 'T') flag2 = true;
            if (flag1 && s.charAt(low) == 'T') {
                begin = low;
            } else {
                low++;
            }
            if (flag2 && s.charAt(high) == 'M') {
                end = high;
            } else {
                high--;
            }
        }
        String res = s.substring(begin + 1, end);
        System.out.println(res);
    }
}
