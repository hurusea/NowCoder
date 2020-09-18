package month08.day0831;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-06 20:58
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n - 1];
            int count = i;
            for (int j = 0; j < n - 1; j++) {
                if (j < count) {
                    temp[j] = nums[j];
                } else {
                    temp[j] = nums[j + 1];
                }
            }
            Arrays.sort(temp);
            if ((n - 1) % 2 == 0) {
                System.out.println(temp[n / 2]);
            } else {
                System.out.println(temp[n / 2 - 1]);
            }
        }

    }
}
