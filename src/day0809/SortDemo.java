package day0809;

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
        MergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param array
     */
    public void selectSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                temp = array[i];
                if (array[i] > array[j]) {
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public void insertSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    /**
     * 希尔排序
     *
     * @param array
     */
    public void sheelSort(int[] array) {
        int l = array.length / 2;
        int temp;
        while (l != 0) {
            for (int i = l; i < array.length; i += l) {
                temp = array[i];
                int j = i - l;
                while (j >= 0 && array[j] > temp) {
                    array[j + l] = array[j];
                    j = j - l;
                }
                array[j + l] = temp;
            }
            l /= 2;
        }
    }

    /**
     * 快速排序
     *
     * @param array
     * @param start
     * @param end
     */
    public void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int base = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && array[j] > base) j--;
            if (i < j) array[i++] = array[j];
            while (i < j && array[i] < base) i++;
            if (i < j) array[j--] = array[i];
        }
        array[i] = base;
        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);
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
        int[] res = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < left.length + right.length; index++) {
            if (i >= left.length) {
                res[index] = right[j++];
            } else if (j > right.length) {
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
