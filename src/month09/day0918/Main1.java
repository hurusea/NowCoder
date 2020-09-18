package month09.day0918;


import month04.day0418.ListNode;
import org.junit.Test;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-18 17:02
 */
public class Main1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

    }

    public static ListNode removeMidListNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        if (head.next.next == null) {
            return head.next;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    @Test
    public void testfindCharMost() {
        String s = "aabbba";
        Character c = findCharMost2(s);
    }

    public static Character findCharMost(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        char MaxChar = 0;
        int bigger = 0;
        char BiggerChar = 0;
        for (char c : chars) {
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                if (c == chars[i])
                    index++;
            }
            if (index >= max) {
                max = index;
                MaxChar = c;
            } else if (index >= bigger) {
                bigger = index;
                BiggerChar = c;
            }
        }
        if (BiggerChar == MaxChar) {
            return null;
        }
        return BiggerChar;
    }
    public static Character findCharMost2(String string) {
        int max_length=0;
        String max_str="";
        while (string.length()>0) {
            String first=string.substring(0, 1);
            int length=string.length();
            string=string.replaceAll(first, "");
            if (max_length<length-string.length()) {
                max_length=length-string.length();
                max_str=first;
            }
        }
        System.out.println(max_str.toCharArray()[0]);
        return null;
    }

}
