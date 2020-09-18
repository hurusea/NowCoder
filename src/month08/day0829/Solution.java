package month08.day0829;

import org.junit.Test;

/**
 * @hurusea
 * @create2020-08-29 18:50
 */
public class Solution {

    public int findNum(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void testFindNum() {
        int[] arr = new int[]{2, 3, 4, 5, 7, 8, 10, 100, 250, 291};
        int res = findNum(arr, 7);
        System.out.println(res);
    }
}
