package month08.day0826;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-26 21:42
 */
public class Case2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            double n = in.nextInt();
            int m = in.nextInt();
            double res = n;
            for (int i = 0; i < m - 1; i++) {
                n = Math.sqrt(n);
                res += n;
            }
            String s = String.format("%.2f", res).toString();
            System.out.println(s);
        }
    }
}