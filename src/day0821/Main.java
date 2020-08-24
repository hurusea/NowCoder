package day0821;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-21 21:34
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.close();
        int[] res = floorNumber(nums);
        System.out.println(Arrays.toString(res));

    }

    private static int[] floorNumber(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int ans = 3;
        boolean flag = true;
        for (int i = 0; i < length; i++) {
            int temp = i;
            int j = i;
            while (temp >= 2) {
                if (nums[temp - 2] > nums[temp - 1] || nums[i] > nums[temp - 2]) {
                    if (flag) {
                        ans++;
                    }
                } else {
                    flag = false;
                    break;
                }
                temp--;
            }
            temp = j;
            flag = true;
            while (temp < length - 2) {
                if (nums[temp + 2] > nums[temp + 1] || nums[j] > nums[temp + 2]) {
                    if (flag) {
                        ans++;
                    }
                } else {
                    flag = false;
                    break;
                }
                temp++;
            }
            result[i] = ans;
            ans = 3;
            flag = true;
        }
        result[0] = result[0] - 1;
        result[length - 1] = result[length - 1] - 1;
        return result;
    }
}
