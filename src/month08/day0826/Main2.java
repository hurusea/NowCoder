package month08.day0826;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-26 18:20
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String[] t = s.split(",");
        int num = t.length;
        t[0] = t[0].substring(1, t[0].length());
        t[num / 2 - 1] = t[num / 2 - 1].substring(0, t[num / 2 - 1].length() - 1);
        t[num / 2] = t[num / 2].substring(1, t[num / 2].length());
        t[num - 1] = t[num - 1].substring(0, t[num - 1].length() - 1);
        int[] w = new int[num / 2];
        int[] h = new int[num / 2];
        for (int i = 0; i < num / 2; i++) {
            w[i] = Integer.valueOf(t[i]);
        }
        for (int i = num / 2; i < num; i++) {
            h[i - num / 2] = Integer.valueOf(t[i]);
        }
        int out = 0;
        for (int i = 0; i < w.length; i++) {
            for (int j = i + 1; j < w.length; j++) {
                int min = 1000;
                int len = 0;
                for (int k = i; k < j; k++) {
                    if (min > h[k]) {
                        min = h[k];
                    }
                    len = len + w[k];
                }
                if (out < len * min) {
                    out = len * min;
                }
            }
        }
        System.out.println(out);
    }
}
