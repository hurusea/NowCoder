package day0824;

/**
 * @hurusea
 * @create2020-08-24 20:10
 */

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            long A = input.nextLong();
            long B = input.nextLong();
            long a = input.nextLong();
            long b = input.nextLong();

            long start = Math.min(A, (B * a) / b);
            for (long i = start; i >= 1; i--) {
                if ((b * i) % a == 0 && (b * i) / a <= B) {
                    long y = (b * i) / a;
                    System.out.println(i + " " + y);
                    break;
                }
            }
        }
    }
}
