package month10.day10;

import month04.day0418.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @hurusea
 * @create2020-10-09 19:20
 */
public class Main {

    public String findMaxSubstr(String str) {
        // write code here
        ArrayList<Integer> list = findLen(str);
        Integer len = list.get(0);
        Integer begin = list.get(1);
        StringBuffer sb = new StringBuffer();
        for (int m = begin; m < begin + len; m++) {
            sb.append(str.charAt(m));
        }
        return sb.toString();
    }

    public ArrayList<Integer> findLen(String str) {
        ArrayList<Integer> list = new ArrayList<>();
        char s[] = str.toCharArray();
        int i = 0, j = i + 1, max = 0;
        int begin = 0;
        boolean t = true;
        while (i < str.length() - 1) {
            int length = 1;
            if (j == str.length()) break;
            for (int k = i; k < j; k++) {
                if (s[j] != s[k]) {
                    length++;
                } else {
                    t = false;
                    break;
                }
            }
            if (length > max) {
                begin = i;
                max = length;
            }
            if (t) j++;
            else {
                t = true;
                i++;
                j = i + 1;
                length = 1;
            }
        }
        list.add(max);
        list.add(begin);
        return list;
    }

    @Test
    public void test() {
        String s = "abcdbcdcbabcdefggcwa";
        String res = findMaxSubstr(s);
        System.out.println(res);
    }


    public int[] leftView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> qu1 = new LinkedList<>();
        Queue<TreeNode> qu2 = new LinkedList<>();
        qu1.add(root);
        while (!qu1.isEmpty() || !qu2.isEmpty()) {
            Queue<TreeNode> qu;
            Queue<TreeNode> quTemp;
            if (qu1.isEmpty()) {
                qu = qu2;
                quTemp = qu1;
            } else {
                qu = qu1;
                quTemp = qu2;
            }
            list.add(qu.peek().val);
            while (!qu.isEmpty()) {
                TreeNode temp = qu.poll();
                if (temp.left != null) quTemp.add(temp.left);
                if (temp.right != null) quTemp.add(temp.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] merge(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        boolean flag = false;
        if (m >= 2) {
            if (A[0] < A[1]) {
                flag = false;
            } else flag = true;
        }
        if (flag) {
            Arrays.sort(A);
            Arrays.sort(B);
        }
        int[] res = new int[m + n];
        for (int i = 0; i < m; i++) res[i] = A[i];
        merge(res, m, B, n);
        if (flag) {
            return res;
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for (int ele : res) list.add(ele);
            Collections.reverse(list);
            for (int i = 0; i < m+n; i++) res[i] = list.get(i);
            return res;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }


    @Test
    public void testMerge() {
        int[] A = new int[]{1, 3, 4, 5, 8};
        int[] B = new int[]{2, 6, 7, 9};
        int[] merge = merge(A, B);
        System.out.println(Arrays.toString(merge));
    }

    @Test
    public void testTrees() {
        TreeNode root = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        root.left = r2;
        root.right = r3;
        r2.right = r5;
        r3.right = r4;
        int[] res = leftView(root);
        System.out.println(Arrays.toString(res));
    }
}
