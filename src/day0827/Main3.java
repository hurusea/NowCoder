package day0827;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-27 20:47
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int count = get(a);
        String s = "";
        String temp = "2";
        if (a == 1) {
            System.out.println(2);
            return;
        }
        for (int i = 1; i < a; i++) {
            int flag = 0;
            s = temp;
            for (int j = 0; j < s.length(); j++) {
                if (temp.charAt(j) == '2') {
                    temp = temp.substring(0, j) + "3" + temp.substring(j + 1, temp.length());
                    flag = 0;
                    break;
                } else if (temp.charAt(j) == '3') {
                    temp = temp.substring(0, j) + "5" + temp.substring(j + 1, temp.length());
                    flag = 0;
                    break;
                } else {
                    temp = temp.substring(0, j) + "2" + temp.substring(j + 1, temp.length());
                    flag = 1;
                }
            }
            if (flag == 1) {
                temp = temp + "2";
            }
        }
        for (int i = temp.length() - 1; i >= 0; i--) {
            System.out.print(temp.charAt(i));
        }
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
