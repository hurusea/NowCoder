package month09.day0919;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @hurusea
 */
public class Main1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] map = new int[a][b];
        int[][] vis = new int[a][b];
        int id = 0;
        int x = 0;
        int y = 0;
        int n = 0;
        map[0][0] = 0;
        vis[0][0] = 1;
        int flag = 0;
        while (n < a * b) {
            if (flag == 0) {
                if (y + 1 < b && vis[x][y + 1] == 0) {
                    map[x][y + 1] = (id + 1) % 26;
                    y++;
                    id = (id + 1) % 26;
                    vis[x][y] = 1;
                    n++;
                    continue;
                } else {
                    flag = 1;
                    continue;
                }
            } else if (flag == 1) {
                if (x + 1 < a && vis[x + 1][y] == 0) {
                    map[x + 1][y] = (id + 1) % 26;
                    x++;
                    id = (id + 1) % 26;
                    vis[x][y] = 1;
                    n++;
                    continue;
                } else {
                    flag = 2;
                    n++;
                    continue;
                }
            } else if (flag == 2) {
                if (y- 1 >= 0 && vis[x][y-1] == 0) {
                    map[x][y-1] = (id + 1) % 26;
                    y--;
                    id = (id + 1) % 26;
                    vis[x][y] = 1;
                    n++;
                    continue;
                } else {
                    flag = 3;
                    continue;
                }
            } else if (flag == 3) {
                if (x- 1 >= 0 && vis[x-1][y] == 0) {
                    map[x-1][y] = (id + 1) % 26;
                    x--;
                    id = (id + 1) % 26;
                    vis[x][y] = 1;
                    n++;
                    continue;
                } else {
                    flag = 0;
                    continue;
                }
            }
            if (n >= a * b) {
                break;
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (j != b - 1) {
                    System.out.print((char) (map[i][j] + 'A') + " ");
                } else {
                    System.out.println((char) (map[i][j] + 'A'));
                }
            }
        }
    }

//    private static char[][] printAZ(char[][] arr) {
//        if (arr.length == 0) {
//            return new char[][]{};
//        }
//        int top = 0;
//        int bottom = arr.length-1;
//        int left = 0;
//        int right = arr[0].length - 1;
//        int[] move = new int[]{0, 1};
//        int index = 0;
//        int count = arr.length * arr[0].length;
//        char[] result = new char[arr.length*arr[0].length];
//
//        char[] chars = new char[26];
//        int nums = 0;
//        for (char i = 'A'; i <= 'Z'; i++) {
//            chars[nums] = i;
//            nums++;
//        }
//
//
//        return new char[0][];
//    }
}
