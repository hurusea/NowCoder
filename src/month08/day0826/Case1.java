package month08.day0826;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-26 16:37
 */
public class Case1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            System.out.println(n/2);
        }
    }
    private static void getNum(int n) {
        int res = 0, mod = 0;
        while (n > 1) {
            mod += n % 3;
            res += n / 3;
            n /= 3;
            if (mod == 2) {
                res++;
                n++;
                mod = 0;
            }
        }
        System.out.println(res);
    }
}
