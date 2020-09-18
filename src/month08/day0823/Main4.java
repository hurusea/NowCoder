package month08.day0823;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-23 21:28
 */
public class Main4 {
    static int[] a = new int[5010];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int res = solve(1, n, 0);
        System.out.println(res);
    }

    private static int solve(int l, int r, int h) {
        if (l > h) return 0;
        int loc = -1, mini = 1 << 30;
        int sum = 0;
        for (int i = l; i <= r; i++) {
            if (mini > a[i]) {
                mini = a[i];
                loc = i;
            }
            if (a[i] > h) sum++;
        }
        int temp = a[loc] - h;
        if (temp < 0) temp = 0;
        return Math.min(sum, solve(l, loc - 1, Math.max(a[loc], h))
                + solve(loc + 1, r, Math.max(a[loc], h)) + temp);
    }
}
