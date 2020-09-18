package month08.day0725;


import org.junit.Test;

import java.util.HashMap;


/**
 * @hurusea
 * @create2020-07-25 10:56
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 取出来的最开始都是个位，如果值存在，相加，进位flag记为1，否则flag为0
         * 如果值不存在，记为零和另一个相加
         * 如果两个值都不存在，结束
         */
        ListNode p = l1;
        ListNode q = l2;
        int flag = 0;
        ListNode res = new ListNode(0);
        ListNode tempNode = res;
        while ((p != null) || (q != null)) {
            int a = (p != null) ? p.val : 0;
            int b = (q != null) ? q.val : 0;
            int temp = a + b + flag;
            if (temp >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            tempNode.next = new ListNode(temp % 10);
            tempNode = tempNode.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            if (flag == 1) {
                tempNode.next = new ListNode(flag);
            }
        }
        return res.next;
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode l1 = new ListNode(5);
        ListNode temp1 = new ListNode(4);
        l1.next = temp1;
        ListNode temp2 = new ListNode(3);
        temp1.next = temp2;
        ListNode l2 = new ListNode(5);
        ListNode temp3 = new ListNode(6);
        l2.next = temp3;
        ListNode temp5 = new ListNode(4);
        temp3.next = temp5;

        ListNode res = addTwoNumbers(l1, l2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    @Test
    public void testLengthOfLongestSubstring() {
        String s = "abcabcbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
