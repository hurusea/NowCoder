package day0808;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-26 19:19
 */
public class Main2 {
    private static final int MAX = 1005;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double n = sc.nextDouble();
            int m = sc.nextInt();
            double ans = 0;
            for (int i = 0; i < m; i++) {
                ans += n;
                n = Math.sqrt(n);
            }
            System.out.printf("%.2f\n", ans);
        }
    }
}
