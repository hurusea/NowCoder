package day0823;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-23 20:46
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int a = in.nextInt();
        for (int i = 0; i < a; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            String t = s.substring(l - 1, r);
            int res = minCut(t);
            System.out.println(res + 1);
        }
    }

    private static int minCut(String s) {
        int n = s.length();
        int[] mins = new int[s.length()];
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < n; i++) {
            mins[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && i - j < 2 || dp[j + 1][i - 1]) {
                    dp[j][i] = true;
                    mins[i] = j == 0 ? 0 : Math.min(mins[i], mins[j - 1] + 1);
                }
            }
        }
        return mins[n - 1];
    }
}
