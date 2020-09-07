package day0906;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-06 17:51
 */
public class Case4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        String s = null;
        while (!((s = scanner.nextLine()).equals(""))) {
            arrayList.add(s);
        }
        String[] array = arrayList.toArray(new String[0]);
        int l = array.length;
        int A = Integer.parseInt(array[l - 2]);
        String target = getT(array[l - 1], A);
        int n = target.length();
        for (int i = 0; i < l - 2; i++) {
            String temp = getT(array[i], A);
            if (temp.length() < n) {
                continue;
            } else {
                int k = 0;
                while (k + n <= temp.length()) {
                    if (target.equals(temp.substring(k, k + n))) {
                        System.out.println(array[i]);
                        break;
                    }
                    k++;
                }
            }
        }
    }

    public static String getT(String num, int A) {
        int i = 0;
        int l = num.length();
        String res = "";
        while (i < l) {
            if (num.charAt(i) - '0' < A) {
                res += num.charAt(i);
            }
            i++;
        }
        return res;
    }
}
