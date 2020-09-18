package month09.day0911;

import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void testSum() {
        int[] nums = new int[]{1, 2, 4};
        int res = minMoves(nums);
        System.out.println(res);
    }

    public int minMoves (int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int res = 0;
        Arrays.sort(nums);
        while (l < h) {
            res += nums[h--] - nums[l++];
        }
        return res;
    }

    public int maxCandies(int[] candies, int[] coin, int n) {
        int res = 0;

        for (int i = 0; i < candies.length; i++) {
            if (coin[i] == 0) {
                res += candies[i];
            }
        }
        return res;

    }

    public int getMaxAreas(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        return 0;

    }
}
