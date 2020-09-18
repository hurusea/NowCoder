package month09.day0906;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-06 12:38
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long res = climb(n);
        System.out.println(res);
    }

    private static long climb(int n) {
        if (n <= 4) {
            return n;
        }
        long pre3 = 1, pre2 = 2, pre1 = 3;
        for (int i = 3; i < n; i++) {
            long cur = pre1 + pre3;
            pre3 = pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
