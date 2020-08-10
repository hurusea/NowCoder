package day0725;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @hurusea
 * @create2020-07-25 21:17
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(1, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    public void topK(int[] array, int low, int high, int k) {
        if (low >= high) return;
        int record = array[low];
        int l = low, r = high;
        // partition
        while (l < r) {
            while (l < r && array[r] < record) r--;
            if (l < r) array[l] = array[r];
            while (l < r && array[l] >= record) l++;
            if (l < r) array[r] = array[l];
        }
        array[l] = record;
        if (l == k) return;
        else if (l > k) topK(array, low, l - 1, k);
        else topK(array, l + 1, high, k);  // l<k
    }

    @Test
    public void testTopK() {
        int[] nums = new int[15];
        for (int i = 0; i < 15; i++) {
            nums[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(nums));
        int low = 0;
        int high = nums.length - 1;
        int k = 3;
        topK(nums, low, high, k);
        System.out.println(Arrays.toString(nums));

    }
}
