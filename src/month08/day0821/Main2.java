package month08.day0821;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-23 9:00
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String res = deleteChar(s);
            System.out.println(res);
        }
    }

    private static String deleteChar(String s) {
        return s;
    }
}
