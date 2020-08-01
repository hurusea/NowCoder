package day0726;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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
}
