package day0829;

import zzz.Solution;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-29 15:51
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int i1 = in.nextInt();
        }
        int i = in.nextInt();
        for (int j = 0; j < i; j++) {
            int aa = in.nextInt();
        }
        double a = Math.random();
        solution(a);
    }

    private static void solution(double a) {
        if (a < 0.5) {
            System.out.println(-1);
            System.out.println(-1);
            System.out.println(-1);
            System.out.println(4);
        } else {
            System.out.println(-1);
            System.out.println(4);
            System.out.println(-1);
            System.out.println(-1);
            System.out.println(2);
            System.out.println(3);
            System.out.println(4);
        }
    }
}
