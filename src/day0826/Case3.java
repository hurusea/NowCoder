package day0826;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-26 21:54
 */
public class Case3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        boolean flag = false;
        for (int i = a; i <= b; i++) {
            int temp = i;
            int x = temp % 10;
            temp /= 10;
            int y = temp % 10;
            temp /= 10;
            int z = temp;
            int res = (int) (Math.pow(x, 3) + Math.pow(y, 3) + Math.pow(z, 3));
            if (res == i) {
                flag = true;
                System.out.print(i + " ");
            }
        }
        if (flag == false) {
            System.out.println("no");
        }
    }
}
