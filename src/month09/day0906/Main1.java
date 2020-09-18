package month09.day0906;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-05 14:54
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long res = climb(n);
        System.out.println(res);
    }

    private static long climb(int n) {
        if (n == 0) {
            return 0;
        }
        long res = 0;
        long[] dp = new long[n + 1];
        long[] two = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        two[0] = 0;
        two[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            long not_two = dp[i - 2] - two[i - 2];
            dp[i] = dp[i - 1] + not_two;
            two[i] = not_two;
        }
        res =dp[n];
        return res;
    }
}
