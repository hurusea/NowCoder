package month09.day0913;

import java.util.*;

/**
 * @hurusea
 * @create2020-09-13 15:20
 */
public class Solution {

    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     *
     * @param head 头结点
     * @return 头结点
     */
    public static ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归方法
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = ReverseList2(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 链表中的节点每k个一组翻转
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, temp;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        for (int i = 0; i < len / k; i++) {
            for (int j = 1; j < k; j++) {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 判断给定的链表中是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next != null && head.next.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 找出两个链表的第一个公共结点
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

    /**
     * 归并两个有序的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 合并k个已排序的链表
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.size() - 1);
    }

    private ListNode mergeList(ArrayList<ListNode> lists, int low, int height) {
        if (height <= low) return lists.get(low);
        int mid = low + ((height - low) >> 1);
        ListNode left = mergeList(lists, low, mid);
        ListNode right = mergeList(lists, mid + 1, height);
        return mergeList(left, right);
    }

    /**
     * 归并两个有序的链表
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }
    }

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        Stack<Integer> l1Stack = buildStack(head1);
        Stack<Integer> l2Stack = buildStack(head2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }

    /**
     * 给定一个链表，请判断该链表是否为回文结构。
     *
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    /**
     * 链表中环的入口节点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                meet = fast;
                break;
            }
        }
        if (meet == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 链表内指定区间反转
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; ++i) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next = cur.next;
        for (int i = 0; i < n - m; i++) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }
        return dummy.next;
    }

    /**
     * 链表中倒数第k个结点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode p, q;
        for (p = q = head; p != null; p = p.next, k--)
            if (k <= 0)
                q = q.next;
        return k <= 0 ? q : null;
    }

    /**
     * 删除链表的倒数第n个节点
     *
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++)
            first = first.next;
        //如果n的值等于链表的长度,直接返回去掉头结点的链表
        if (first == null)
            return head.next;
        while (first.next != null) {  //同时移动两个指针
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

    /**
     * 删除有序链表中重复的元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates1(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    /**
     * 删除有序链表中重复出现的元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(head.val - 1);
        newHead.next = head;
        ListNode cur = head;
        ListNode last = newHead;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                last = cur;
            } else {
                while (cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                last.next = cur.next;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}