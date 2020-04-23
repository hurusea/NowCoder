package day0423;


import org.junit.Test;

/**
 * @hurusea
 * @create2020-04-23 10:42
 */
public class Solution {

    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n);
        int[] res = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }

    public int[] exchange(int[] nums) {
        if (nums.length == 0) return new int[0];
        int start = 0;
        int end = nums.length - 1;
        int temp;
        while (start < end) {
            while (start < end && nums[start] % 2 == 1) {
                start++;
            }
            while (start < end && nums[end] % 2 == 0) {
                end--;
            }
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        return nums;
    }

    @Test
    public void testexchange() {
        int[] nums = {1, 2, 3, 4};
        int[] res = exchange(nums);
        System.out.println(res);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        for (int i = 0; i < count - k; i++) {
            head = head.next;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur!=null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
