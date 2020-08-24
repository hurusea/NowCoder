package day0823;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-23 8:11
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        long n = in.nextLong();
        for (int i = 0; i < T; i++) {
            Long maxValue = findMaxValue(n);
            System.out.println(maxValue);
        }
    }

    private static Long findMaxValue(long n) {
        long a = n / 2;
        long b = n - a;
        Long aLong = getVal(a);
        Long bLong = getVal(b);
        return aLong + bLong;
    }

    private static Long getVal(long a) {
        Long res = 0L;
        while (a > 0) {
            res += a % 10;
            a = a / 10;
        }
        return res;
    }
}
