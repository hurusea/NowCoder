package month09.day0913;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-13 10:02
 */
public class Main1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] inputs = new String[n];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            inputs[i] = in.nextLine();
        }
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(inputs[i]);
            }
        } else {
            int l = 0;
            int h = n - 1;
            int mid = h;
            while (l < mid) {
                mid = l + (h - l) / 2;
                if (inputs[h].equals(inputs[l])) {
                    h = mid;
                } else {
                    break;
                }
            }
            for (int i = 0; i <= h; i++) {
                System.out.println(inputs[i]);
            }
        }
    }
}
