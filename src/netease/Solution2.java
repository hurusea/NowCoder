package netease;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-08 14:59
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
    }




    public int minQueueTime(int n, int[] a, int[] b){
        int[] dp = new int [n+1];
        dp[1] = a[0];
        dp[2] = Math .min(a[0] + a[1], b[0]);
        for (int i = 3;i<=n;i++)
            dp[i] = Math. min(dp[i-1]+a[i-1], dp[i-2]+b[i-2]);
        return dp[n];
    }

}
