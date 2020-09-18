package month08.day0831;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-06 21:49
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] sort = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            sort[i] = nums[i];
        }
        Arrays.sort(sort);
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            int tmp = solution(sort, nums[i]);
            if (tmp < mid) {
                System.out.println(sort[mid]);
            } else {
                System.out.println(sort[mid - 1]);
            }
        }
    }

    private static int solution(int[] nums, int key) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > key) {
                j = mid - 1;
            } else if (nums[mid] < key) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
