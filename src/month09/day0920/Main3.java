package month09.day0920;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-20 16:41
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] res = change(arr, n);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i] + " ");
        }
    }

    private static int[] change(int[] arr, int n) {
        Arrays.sort(arr);
        if (n % 2 == 0) {
            int temp = 0;
            for (int i = 1; i <= n - 3; i = i + 2) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        } else {
            int temp = 0;
            for (int i = 1; i <= n - 2; i = i + 2) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        return arr;
    }
}
