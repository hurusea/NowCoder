package day0829;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-29 17:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int res = solution(nums, m);
        System.out.println(res);
    }

    private static int solution(int[] nums, int m) {
        int ans = 0;
        for (int i = 1; i < m + 1; i++) {
            int l = i;
            for (int j = l; j < m + 1; j++) {
                int r = j;
                int temp = Integer.MIN_VALUE;
                boolean flag = true;
                for (int k = 0; k < nums.length; k++) {
                    int x = nums[k];
                    if ((0 < x && x < l) || (r < x && x < m + 1)) {
                        if (x >= temp) {
                            temp = x;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) ans++;
            }
        }
        return ans;
    }
}
