package day0827;

import java.time.temporal.Temporal;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-27 19:41
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result;
        int flag = 1;
        int count = get(n);

        if (n % 3 == 0) {
            result = 5;
        } else if (n % 3 == 1) {
            result = 2;
        } else {
            result = 3;
        }
        while (n > 0) {
            n -= (int) Math.pow(3, flag);
            int mod = (int) (n % Math.pow(3, flag-1));
            if (mod == 1) {
                result += 2 *  Math.pow(10, flag-1);
            } else if (mod == 2) {
                result += 3 * Math.pow(10, flag-1);
            } else {
                result += 5 * Math.pow(10, flag-1);
            }
            flag++;
        }
        System.out.println(result);
    }

    private static int get(int n) {
        int res = 0;
        while (n > 0) {
            n = (int) (n - Math.pow(3, res + 1));
            res++;
        }
        return res;
    }
}
