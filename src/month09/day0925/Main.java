package month09.day0925;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-25 15:44
 */
public class Main {
    public static void main(String[] args) {
        Main tt = new Main();
        Class<? extends Main> aClass = tt.getClass();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 2 * climbStairs(n - 1);
        }
    }

    public int leastWorkTime (int[] tasks, int n) {
        int[] count = new int[10];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i]]++;
        }
        //最多的零件的数量
        int num = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > num) num = count[i];
        }
        int repet = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == num) repet++;
        }
        return num + (num - 1) * n + repet - 1;
    }

    @Test
    public void testLeastWorkTime() {
        int[] tasks = new int[]{1, 1, 1, 2, 3, 3, 3};
        int n = 2;
        int res = leastWorkTime(tasks, n);
        System.out.println(res);
    }

    @Test
    public void test() {
        for (int i = 0, m = 1; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                m += 1;
            }
            System.out.println(m);
        }
    }
}
