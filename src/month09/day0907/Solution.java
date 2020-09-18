package month09.day0907;

import month04.day0418.ListNode;
import month04.day0418.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @hurusea
 * @create2020-09-07 15:27
 */
public class Solution {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // 快满指针找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 拆分链表，并反转中间节点之后的链表
        ListNode after = slow.next;
        slow.next = null;
        ListNode pre = null;
        while (after != null) {
            ListNode temp = after.next;
            after.next = pre;
            pre = after;
            after = temp;
        }
        // 合并两个链表
        ListNode first = head;
        after = pre;
        while (first != null && after != null) {
            ListNode ftemp = first.next;
            ListNode aftemp = after.next;
            first.next = after;
            first = ftemp;
            after.next = first;
            after = aftemp;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public double maxProduct(double[] arr) {
        double min = arr[0];
        double max = min;
        double res = min; //注意：max记录的不是最终的最大值，而是途中每一个选择的最大值，于是需要重新用一个值保存全局最大值。
        for (int i = 1; i < arr.length; i++) {
            double t_max = max;
            //最大值可以从哪些地方产生：
            // 1. arr[i]  2. min*arr[i] 3.max*arr[i]
            max = Math.max(Math.max(arr[i], arr[i] * max), min * arr[i]);
            //最小值可以从哪些地方产生：
            // 1. arr[i]  2.max*arr[i] 3.min*arr[i]
            min = Math.min(Math.min(arr[i], arr[i] * min), t_max * arr[i]);
            res = Math.max(res, max); //更新全局最大值
        }
        return res;
    }

    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = mat[i][j];
            }
        }
        return res;
    }

    // 搜索二叉树  左<根<右
    // 完全二叉树
    public boolean[] judgeIt(TreeNode root) {
        // 两个情况分别判断：
        // 二叉搜索树：每个节点左边节点小于右边节点，左子树的最大值一定小于根节点，小于右子树的最大值；通过中序遍历，严格递增
        // 完全二叉树：层序遍历，除了最后的一层，每层都是满的
        if (null == root) return new boolean[]{false, false};
        List<Integer> list = new ArrayList<>();
        midSearch(root, list);
        boolean b1 = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                b1 = false;
                break;
            }
        }
        boolean b2 = isCompleteTree(root);
        return new boolean[]{b1, b2};
    }

    void midSearch(TreeNode root, List<Integer> list) {
        // 中序遍历
        if (null == root) return;
        midSearch(root.left, list);
        list.add(root.val);
        midSearch(root.right, list);
    }

    boolean isCompleteTree(TreeNode root) {
        // 判断一棵树是否为完全二叉树，层序遍历，一旦出现null，则队列中剩余的节点必须为叶子节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (null == cur.left) {
                // 遍历每个节点
                if (null != cur.right) return false;
                while (!queue.isEmpty()) {
                    TreeNode p = queue.poll();
                    if (null != p.left || null != p.right) return false;
                }
                return true;
            } else queue.add(cur.left);
            if (null == cur.right) {
                while (!queue.isEmpty()) {
                    TreeNode p = queue.poll();
                    if (null != p.left || null != p.right) return false;
                }
                return true;
            } else queue.add(cur.right);
        }
        return true;
    }

    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head;
        ListNode pre = new ListNode(-1);
        pre.next = cur;
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                set.add(cur.val);
                pre = pre.next;
                cur = cur.next;
            }
        }
        return head;
    }

    @Test
    public void testDeleteDuplicates() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        ListNode res = deleteDuplicates(head);
    }

}
