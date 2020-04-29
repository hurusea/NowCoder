package tencent;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-26 20:14
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int Q = scanner.nextInt();
            if (Q < 0) {
                System.out.println("No solution");
            } else if (Q == 0) {
                System.out.println(1);
            } else {
                long n = Q*5;
                System.out.println(n);
            }
        }
    }
}
