package day0814;

import day0418.ListNode;
import day0418.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @hurusea
 * @create2020-08-14 13:50
 */
public class Solution {

    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return  isPalindrome(s,i,j-1) || isPalindrome(s,i+1,j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testValidPalindrome() {
        boolean res = validPalindrome("apple");
        System.out.println(res);
    }

    public int binarySearch(int[] nums, int key) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }
    @Test
    public void testBinarySearch() {
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int i = binarySearch(nums, nums[2]);
        System.out.println(i);

    }

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }
    @Test
    public void testMySqrt() {

        System.out.println(mySqrt(8));

    }

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l > n ? letters[l] : letters[0];
    }

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }

    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, h = n - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] > nums[h]) {
                l = m+1;
            } else {
                h = m;
            }
        }
        return nums[l];
    }

    @Test
    public void TestFindMin() {
        int[] nums = new int[]{3, 4, 5, 1, 2};

        System.out.println(findMin(nums));
    }

    /**
     * 每个孩子都有一个满足度，每个饼干都有一个大小，只有饼干的大小大于等于一个孩子的满足度，该孩子
     * 才会获得满足。求解最多可以获得满足的孩子数量。
     * @param g 孩子满意度数组
     * @param s 饼干数组
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }


    @Test
    public void TestFindContentChildren() {
        int[] g = new int[9];
        int[] s = new int[9];
        for (int i = 0; i < 9; i++) {
            g[i] = (int) (Math.random() * 10);
            s[i] = (int) (Math.random() * 10);
        }
        int res = findContentChildren(g, s);
        Arrays.sort(g);
        Arrays.sort(s);
        System.out.println(Arrays.toString(g));
        System.out.println(Arrays.toString(s));
        System.out.println(res);
    }

    /**
     * 计算让一组区间不重叠所需要移除的区间个数
     * @param intervals 二维数组
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
        }
        return intervals.length - count;
    }

    /**
     * 气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都被刺破。求解最小的
     * 投飞镖次数使所有气球都被刺破
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1, end = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            count++;
            end = points[i][1];
        }
        return count;
    }

    /**
     * 一个学生用两个分量 (h, k) 描述，h 表示身高，
     * k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

    /**
     * flowerbed 数组中 1 表示已经种下了花朵。花朵之间至少需要一个单位的间隔，求解是否能种下n朵花
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }

    /**
     * 判断是否为子序列 Is Subsequence
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0;
        for (int j = 0; i < m && j < n; j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == m;
    }

    @Test
    public void TestIsSubsequence() {
        String s = "abc";
        String t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);

    }

    /**
     * 判断一个数组是否能只修改一个数就成为非递减数组
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return cnt <= 1;
    }

    /**
     * 给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素）返回其最大和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }


    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next != null) {
            ListNode current = pre.next;
            ListNode next = pre.next.next;
            current.next = next.next;
            pre.next = next;
            next.next = current;
            pre = pre.next.next;
        }
        return node.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
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

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode cur = root;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int m = len % k;
        int p = len / k;
        cur = root;
        ListNode[] res = new ListNode[k];
        for (int i = 0; cur != null && i < k; i++) {
            res[i] = cur;
            int curSize;
            if (m > 0) {
                curSize = p + 1;
                m--;
            } else {
                curSize = p;
            }
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        int i = maxDepth(root.left);
        int j = maxDepth(root.right);
        if (Math.abs(i - j) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    int maxd=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }
    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        maxd=Math.max(Left+Right,maxd);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left,Right)+1;//返回节点深度
    }

}
