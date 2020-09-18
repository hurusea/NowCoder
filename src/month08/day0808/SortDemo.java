package month08.day0808;

import org.junit.Test;

import java.util.Arrays;

/**
 * @hurusea
 * @create2020-08-09 10:48
 */
public class SortDemo {
    @Test
    public void testSort() {
        int[] nums = new int[15];
        for (int i = 0; i < 15; i++) {
            nums[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(nums));
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public int[] bubbleSort(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 选择排序
     *
     * @param nums
     */
    public int[] selectionSort(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                temp = nums[i];
                if (nums[j] < temp) {
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }

    /**
     * 插入排序
     *
     * @param nums
     * @return
     */
    public int[] insertSort(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
        return nums;
    }

    /**
     * 希尔排序
     *
     * @param nums
     * @return
     */
    public static int[] ShellSort(int[] nums) {
        int temp, gap = nums.length / 2;
        while (gap > 0) {
            for (int i = gap; i < nums.length; i++) {
                temp = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = temp;
            }
            gap /= 2;
        }
        return nums;
    }

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    /**
     * 快速排序
     * @param nums
     * @param start
     * @param end
     */
    public void quickSort(int[] nums, int start, int end) {
        if (start > end)  return;
        int base = nums[start];
        int temp;
        int i = start, j = end;
        while (i < j) {
            while (i < end && nums[i] < base) i++;
            while (start < j && nums[j] > base) j--;
            if (i <= j) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (start < j) quickSort(nums, start, j);
        if (end > i) quickSort(nums, i, end);
    }

}
