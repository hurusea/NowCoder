package day0808;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-26 19:19
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
        }
        int ans = 0;
        int temp = 0;
        int flag = -1;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                for (int k = j; k < j+i; k++) {
                    flag *= -1;
                    sum += flag * nums[k];
                }
                if (temp < sum) {
                    temp = sum;
                }
                sum = 0;
                flag = -1;
            }
            if (ans < temp) {
                ans = temp;
            }
        }
        System.out.println(ans);
    }
}
