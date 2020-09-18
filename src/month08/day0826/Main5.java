package month08.day0826;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-26 21:01
 */
public class Main5 {
    public static void main(String args[]) {
        //4294967296    1000 000 000 000 000 000 000 000 000 000 00 33
        //               100 000 000 000 000 000 000 000 000 000 00
        //              1000 000 000 000 000 000 000 000 000 00
        //1073741824    1000 000 000 000 000 000 000 000 000 000  31
        //
        //2147483648    1000 000 000 000 000 000 000 000 000 000 0 32
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] t = s.split(" ");
        List<Long> list = new ArrayList<>();
        String[] n = new String[t.length];
        for (int i = 0; i < t.length; i++) {
            list.add(Long.valueOf(t[i]));

        }
        for (int i = 0; i < t.length; i++) {
            n[i] = "";
            long tmp = list.get(i);
            while (tmp != 0) {
                n[i] = String.valueOf(tmp % 2) + n[i];
                tmp = tmp / 2;
            }
            int len = n[i].length();
            for (int j = len; j < 32; j++) {
                n[i] = "0" + n[i];
            }
            int a = 0;
            String rev = "";
            for (int j = 0; j < n[i].length(); j = j + 2) {
                rev = rev + n[i].charAt(j + 1);
                rev = rev + n[i].charAt(j);
            }
            n[i] = rev;

        }
        String rest = "";
        for (int i = 0; i < t.length; i++) {
            if (t.length == 1) {
                n[i] = rest + n[i];
                rest = n[i].substring(n[i].length() - 2, n[i].length());
                n[i] = n[i].substring(0, n[i].length() - 2);
                n[0] = rest + n[0];
                break;
            }
            if (i == 0) {
                rest = n[i].substring(30, 32);
                n[i] = n[i].substring(0, 30);
            } else if (i < t.length - 1) {
                n[i] = rest + n[i];
                rest = n[i].substring(n[i].length() - 2, n[i].length());
                n[i] = n[i].substring(0, n[i].length() - 2);
            } else {
                n[i] = rest + n[i];
                rest = n[i].substring(n[i].length() - 2, n[i].length());
                n[i] = n[i].substring(0, n[i].length() - 2);
                n[0] = rest + n[0];
            }

        }

        for (int i = 0; i < t.length; i++) {
            long out = 0;
            for (int j = 0; j < n[i].length(); j++)
                out = out * 2 + (n[i].charAt(j) - '0');
            System.out.print(out);
            if (i < t.length - 1)
                System.out.print(" ");
        }


    }
}
