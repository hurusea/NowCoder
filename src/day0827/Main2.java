package day0827;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-27 20:31
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] map = new int[n][2 * n - 1];
        for (int i = 0; i < n; i++) {
            int l = n - i - 1;
            int h = l + i * 1;
            List<Integer> inputsInts = solve2(in.nextLine());
            for (int j = l; j <= h; j++) {
                map[i][j] = inputsInts.get(j - l);
            }
        }
        int ans = solve1(map, 0, n - 1, n);
        System.out.println(ans);
    }

    private static int solve1(int[][] map, int x, int y, int n) {
        int res = 0;
        if (y < 0 || y >= 2 * n - 1) return -1;
        if (x == n - 1) return map[x][y];
        res = Math.max(Math.max(solve1(map, x + 1, y - 1, n), solve1(map, x + 1, y, n)), solve1(map, x + 1, y + 1, n));
        res += map[x][y];
        return res;
    }

    private static List<Integer> solve2(String s) {
        ArrayList<Integer> res = new ArrayList<>();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            l = i;
            if (s.charAt(i) != ' ') break;
        }
        String str1 = s.substring(l);
        String[] str = str1.split(" ");
        for (int i = 0; i < str.length; i++) {
            res.add(Integer.parseInt(str[i]));
        }
        return res;
    }
}
