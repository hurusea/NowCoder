package month08.day0824;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-24 18:54
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        float a = in.nextFloat();
        float b = in.nextFloat();
        float maxValue = 0;
        float x = 0;
        float y = 0;
        for (float i = 0; i <= A; i++) {
            for (float j = 1; j <= B; j++) {
                if (i / j == a / b && i * j > maxValue) {
                    maxValue = i * j;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println((int) x + " " + (int) y);
    }
}
