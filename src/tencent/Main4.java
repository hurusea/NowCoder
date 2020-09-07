package tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-26 20:14
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        int midLeft = nums[n / 2 - 1];
        int midRight = nums[n / 2];
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            if (temp <= midLeft) {
                System.out.println(midRight);
            } else {
                System.out.println(midLeft);
            }
        }
    }
}
