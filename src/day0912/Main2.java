package day0912;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-12 12:39
 */
public class Main2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(findLength(s));

    }

    private static int findLength(String s) {
        int[] ints = new int[128];
        int n1 = ints[97];
        int n2 = ints[98];
        int n3 = ints[99];
        int n4 = ints[120];
        int n5 = ints[121];
        int n6 = ints[122];
        int maxlen = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                ints[s.substring(0, i).charAt(j)]++;
            }
            if (n1 % 2 == 0 && n2 % 2 == 0 && n3 % 2 == 0 && n4 % 2 == 0 && n5 % 2 == 0 && n6 % 2 == 0) {
                maxlen = Math.max(temp, i - 1);
            }
        }
        return maxlen;
    }
}
