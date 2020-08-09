package netease;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Long[] nums = new Long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            long res = nums[i] / 2;
            answer += res;
        }
        System.out.println(answer);
    }
}
