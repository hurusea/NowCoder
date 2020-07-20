package sourceCode;

import java.util.Scanner;
public class AliTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            findSolution(n, k);
        }
    }
    private static void findSolution(int n, int k) {
        boolean flag = false;
        int temp = n / k;
        for (int i = 1; i <= temp / 3; i++) {
            int temp2 = temp - i;
            for (int j = i + 1; j <= temp2 / 2; j++) {
                int res = temp - i - j;
                flag = isZhiShu(i) && isZhiShu(j) && isZhiShu(res);
                if (flag) {
                    System.out.println(i * k + " " + j * k + " " + res * k);
                    break;
                }
            }
            if (flag) { break; }
        }
        if (!flag) { System.out.println(-1); }
    }
    private static boolean isZhiShu(int n) {
        boolean falg = true;// 初始化falg为true

        if (n < 3) {
            falg = n >= 1;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                falg = false;
            }
        }
        return falg;
    }
}
