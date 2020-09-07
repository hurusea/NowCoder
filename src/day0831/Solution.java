package day0831;

import day0418.ListNode;
import day0418.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * @hurusea
 * @create2020-08-31 11:04
 */
public class Solution {
    /**
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String s1, String s2) {
        // write code here
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < char1.length; i++) {
            for (int j = 0; j < char2.length; i++) {
                if (char1[i] == char2[j]) {
                    sb.append(char2[j]);
                }
            }
        }
        return sb.length() > 0 ? sb.toString() : "-1";
    }

    public void reorderList(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        if (len > 2) {
            cur = head;
            while (len > 1) {
                pre = pre.next;
                cur = cur.next;
                len--;
            }
            pre.next = null;
            cur.next = head.next;
            head.next = cur;
        }
    }

    @Test
    public void testReorderList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        reorderList(head);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null)
            return true;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        TreeNode pTemp = root.left;
        root.left = root.right;
        root.right = pTemp;
        if(root.left != null)
            Mirror(root.left);
        if(root.right != null)
            Mirror(root.right);
    }

}
