package day0911;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-11 14:48
 */
public class Main1 {
    public long sum (int num, int itemNum) {
        // write code here
        long sum = 0;
        long temp = num;
        for (int i = 0; i < itemNum; i++) {
            sum += num;
            num *= 10;
            num += temp;
        }
        return sum;
    }

    public int minMoves (int[] nums) {
        // write code here
        int l = 0;
        int h = nums.length - 1;
        int res = 0;
        Arrays.sort(nums);
        while (l < h) {
            res += nums[h--] - nums[l++];
        }
        return res;
    }
}
