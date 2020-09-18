package month08.day0824;

/**
 * @hurusea
 * @create2020-08-24 15:06
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre2 + pre1;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

}
