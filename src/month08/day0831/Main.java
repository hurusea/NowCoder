package month08.day0831;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-06 20:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++) {
            nums1[i] = in.nextInt();
        }
        int n = in.nextInt();
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = in.nextInt();
        }
        findCom(nums1, nums2);
    }

    private static void findCom(int[] nums1, int[] nums2) {
        int l = 0;
        int r = 0;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] > nums2[r]) {
                l++;
            } else if (nums1[l] < nums2[r]) {
                r++;
            } else {
                System.out.print(nums1[l] + " ");
                l++;
                r++;
            }
        }
    }
}
