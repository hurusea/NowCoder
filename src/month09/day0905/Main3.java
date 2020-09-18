package month09.day0905;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-05 14:54
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
    }
}
//5 3
//1 2 3 4 5
//5
//left take 1
//right take 2
//left return 3
//right keep
//right take 4
//6
//left take 5
//right take 1
//left return 2
//right return 3
//left take 5
//left return 4
//10
//left take 1
//left keep
//left take 2
//left keep
//left take 3
//left keep
//left take 4
//left keep
//left take 5
//left keep