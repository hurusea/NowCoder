package month08.day0726;

import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * @hurusea
 * @create2020-07-26 11:20
 */
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int end = numbers.length - 1;
        int start = 0;
        int[] result = new int[2];
        while (start < end) {
            int temp = numbers[start] + numbers[end];
            if (temp < target) {
                start++;
            } else if (temp > target) {
                end--;
            } else {
                result[0] = numbers[start];
                result[1] = numbers[end];
                return result;
            }
        }
        return null;
    }

    @Test
    public void testTwoSum() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(numbers, target);
        System.out.println(res[0] + " " + res[1]);

    }

    /**
     * 判断一个数是否为两个数的平方和。
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {

        for (int i = 1; i * i <= c; i++) {
            int j = c - i * i;
            int sqrt = (int) Math.sqrt(j);
            if (sqrt * sqrt == j) {
                System.out.println(i + " " + sqrt);
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

    @Test
    public void testJudgeSquareSum() {
        int c = 5;
        judgeSquareSum(c);
    }

    private final static HashSet<Character> set = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    );


    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!set.contains(ci)) {
                result[i++] = ci;
            } else if (!set.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    /**
     * 可以删除一个字符，判断是否能构成回文字符串。
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = start, j = end - 1; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = start + 1, j = end; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

    @Test
    public void testValidPalindrome() {
        String s = "ebcbbececabbacecbbcbe";//bbe后的e
        System.out.println(validPalindrome(s));
    }

    /**
     * 归并两个有序数组 把归并结果存到第一个数组上
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode current = head;
        ListNode temp = current.next;
        while (temp != current) {
            if (temp == null || temp.next == null) {
                return false;
            }
            current = current.next;
            temp = temp.next.next;
        }
        return true;
    }

    /**
     * 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，
     * 找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串
     *
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    /**
     * 返回最大的K个元素
     * @param nums 传入数组
     * @param k 个数
     */
    public void topK(int[] nums, int k) {
//        Comparator<Integer> cmp = new Comparator<>() {
//            @Override
//            public int compare(Integer e1, Integer e2) {
//                return e1 - e2;
//                return e2 - e1;
//            }
//        };

        //利用优先队列维护大顶堆
        //优先队列默认升序排序，最开始pop的是小元素
        //重写比较器，使得优先队列降序排列，最开始pop的是大元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(pq.poll()+" ");
        }

    }

    @Test
    public void testTopK() {
        int[] numbers = {2, 7, 11, 15, 6, 1, 5, 3};
        topK(numbers, 3);

    }

    /**
     * 出现频率最多的 k 个元素
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Integer key : map.keySet()) {
            Integer frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }

    @Test
    public void test1() throws IOException {
        // 直接打开应用程序
        Runtime.getRuntime().exec("C:/Users/liqiang/Desktop/开机后点它.bat"); // 打开一个批处理文件
        Runtime.getRuntime().exec("E:/酷狗/KGMusic/KuGou.exe"); // 打开酷狗

        /******** 可以通过cmd命令打开软件或者是做其他 *****/
        Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /k start E:/酷狗/KGMusic/KuGou.exe"); // 通过cmd窗口执行命令
        Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /k start E:/php/Test/第一个html/界面.html"); // 通过cmd命令打开一个网页
        Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /k mkdir C:\\Users\\liqiang\\Desktop\\java键的1"); // 通过cmd创建目录用两个反斜杠
        Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /k mkdir C:\\Users\\liqiang\\Desktop\\java键的2"); // 通过cmd创建目录用两个反斜杠
        Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /c calc ");// 通过cmd打开计算器
    }

    @Test
    public void test2() throws IOException {
        /******** 可以通过cmd命令打开软件或者是做其他 *****/
        Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /c osk");// 通过屏幕软键盘
    }

    @Test
    public void test3() throws IOException {
        /******** 可以通过cmd命令打开软件或者是做其他 *****/
        Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /c SnippingTool ");
    }
}
