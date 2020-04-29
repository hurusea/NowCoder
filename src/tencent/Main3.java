package tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-04-26 19:19
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] res = new int[n][];
        int max=0;
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            res[i] = new int[num];
            if (num > max) {
                max=num;
            }
            for (int j = num-1; j >=0; j--) {
                res[i][j]=scanner.nextInt();
            }
        }
//        for (int i = 0; i < res.length; i++) {
//            for (int j = 0; j < res[i].length; j++) {
//                System.out.print(res[i][j]+" ");
//            }
//            System.out.println();
//        }
        if (n == 1 && k == 1) {
            System.out.println(res[0][0]);
        } else {
            findMax(res, k, n, max);
        }
    }

    private static void findMax(int[][] res,int k,int n,int max) {
//        int[] ans = new int[k];
//        int[][] copy = new int[max][n];
//        for (int i = 0; i < res.length; i++) {
//            for (int j = 0; j < res[i].length; j++) {
//                copy[j][i] = res[i][j];
//            }
//        }
//        for (int i = 0; i < max; i++) {
//            Arrays.sort(copy[i]);
//        }
//        int count=0;
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < copy.length; j++) {
//                for (int l = 0; l < copy[i].length; l++) {
//                    ans[count] = copy[i][j];
//                }
//            }
//        }
        int num = n*max;
        int[] ans2 = new int[num];
        int s = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                ans2[s] = res[i][j];
                s++;
            }
        }
        Arrays.sort(ans2);
        for (int i = ans2.length-1; i >ans2.length-6; i--) {
            System.out.print(ans2[i]+" ");
        }
    }
}
