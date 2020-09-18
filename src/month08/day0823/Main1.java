package month08.day0823;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            ListNode node = new ListNode(val);
            if (i != k - 1) {
                temp.next = node;
                temp = temp.next;
            }
        }
        if (n == 1) {
            System.out.print(" ");
        } else {
            removeNode(head, k, n);
            while (head.next != null) {
                System.out.print(head.next.val+" ");
                head = head.next;
            }
        }
    }
    private static void removeNode(ListNode head, int k, int n) {
        ListNode temp = head;
        while (k > 1) {
            temp = temp.next;
            k--;
        }
        if (k == n) {
            temp.next = null;
        } else {
            temp.next = temp.next.next;
        }
    }
    private static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int x) {
            super();
            this.val = x;
        }
    }
}
