package day0811;

import org.junit.Test;

import java.util.Arrays;

/**
 * @hurusea
 * @create2020-08-10 10:44
 */
public class SortDemo {
    @Test
    public void testSort() {
        int[] nums = new int[15];
        for (int i = 0; i < 15; i++) {
            nums[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(nums));
//        quickSort(nums, 0, nums.length - 1);
        int[] res = mergeSort(nums);
        System.out.println(Arrays.toString(res));
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int based = nums[start];
        while (i < j) {
            while (i < j && nums[j] > based) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < based) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = based;
        quickSort(nums, start, i - 1);
        quickSort(nums, i+1, end);
    }

    public int[] mergeSort(int[] nums) {
        if (nums.length < 2) return nums;
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < left.length + right.length; index++) {
            if (i >= left.length) {
                res[index] = right[j++];
            } else if (j >= right.length) {
                res[index] = left[i++];
            } else if (left[i] > right[j]) {
                res[index] = right[j++];
            } else {
                res[index] = left[i++];
            }
        }
        return res;
    }


}
