package month08.day0808;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-26 19:18
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 1024 - scanner.nextInt();
        int div = 64;
        int yushu = -1;
        int count = 0;
        int ans = 0;
        while (yushu != 0) {
            count = num / div;
            num -= count * div;
            ans += count;
            yushu = num % div;
            div /= 4;
        }
        System.out.println(ans);
    }

}
