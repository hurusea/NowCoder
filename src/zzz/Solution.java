package zzz;

import day0418.ListNode;
import day0418.TreeNode;
import org.junit.Test;

import java.util.*;

public class Solution {

    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        return new int[1];
    }

    public ListNode ReverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        ListNode temp = head;
        while (temp != null) {
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    public ListNode ReverseList2(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    @Test
    public void testReverseList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = ReverseList(head);
        System.out.println(node.val);
    }

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        int l = 0;
        int h = n - 1;
        int mid = 0;
        while (l <= h) {
            mid = l + (h - l) / 2;
            if (a[mid] > v) {
                if (mid == 0 || a[mid - 1] < v) {
                    return mid + 1;
                }
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return n + 1;
    }

    @Test
    public void testupper_bound_() {
        int[] a = new int[]{1, 2, 4, 4, 5};
        int res = upper_bound_(5, 2, a);
    }

    public boolean hasCycle(ListNode head) {
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
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        if (cur1 == null) {
            return l2;
        }
        if (cur2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                temp.next = cur2;
                break;
            }
            if (cur2 == null) {
                temp.next = cur1;
                break;
            }
            if (cur1.val < cur2.val) {
                temp.next = cur1;
                cur1 = cur1.next;
            } else {
                temp.next = cur2;
                cur2 = cur2.next;
            }
            temp = temp.next;
        }
        return head.next;
    }

    public int findKth(int[] a, int n, int K) {
        quickSort(a, 0, n - 1);
        return a[n - K];
    }

    private void findKth(int[] array, int low, int high, int k) {
        if (low >= high) return;
        int record = array[low];
        int l = low, r = high;
        // partition
        while (l < r) {
            while (l < r && array[r] < record) r--;
            if (l < r) array[l] = array[r];
            while (l < r && array[l] >= record) l++;
            if (l < r) array[r] = array[l];
        }
        array[l] = record;
        if (l == k) return;
        else if (l > k) findKth(array, low, l - 1, k);
        else findKth(array, l + 1, high, k);  // l<k
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int based = nums[start];
        while (i < j) {
            while (i < j && nums[j] > based) {
                j--;
            }
            if (i < j) {
                nums[i++] = nums[j];
            }
            while (i < j && nums[i] < based) {
                i++;
            }
            if (i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = based;
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
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
        if (meet == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int m = len - n - 1;
        temp = head;
        while (m > 0) {
            temp = temp.next;
            m--;
        }
        if (len == n) {
            return head.next;
        }
        if (temp.next.next == null) {
            temp.next = null;
        } else {
            temp.next = temp.next.next;
        }
        return head;
    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        ListNode curA = head1;
        ListNode curB = head2;
        while (curA != null) {
            stackA.push(curA.val);
            curA = curA.next;
        }
        while (curB != null) {
            stackB.push(curB.val);
            curB = curB.next;
        }
        ListNode newHead = new ListNode(-1);
        Stack<Integer> stackC = new Stack<>();
        boolean flag = false;
        int a, b;
        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            if (!stackA.isEmpty()) {
                a = stackA.pop();
            } else {
                a = 0;
            }
            if (!stackB.isEmpty()) {
                b = stackB.pop();
            } else {
                b = 0;
            }
            int res = a + b;
            if (flag == true) {
                res++;
            }
            if (res > 9) {
                flag = true;
            } else {
                flag = false;
            }
            res %= 10;
            stackC.push(res);
        }
        if (flag) {
            stackC.push(1);
        }
        ListNode temp = newHead;
        while (!stackC.isEmpty()) {
            temp.next = new ListNode(stackC.pop());
            temp = temp.next;
        }
        return newHead.next;
    }

    @Test
    public void testAddInList() {
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(7);
        ListNode head2 = new ListNode(6);
        head2.next = new ListNode(3);
        ListNode head = addInList(head1, head2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode l1 = pHead1, l2 = pHead2;
        while (l1 != l2) {
            l1 = (l1 == null) ? pHead2 : l1.next;
            l2 = (l2 == null) ? pHead1 : l2.next;
        }
        return l1;
    }

    public int sqrt(int x) {
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

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int pop = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return pop;
    }

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

    private ListNode mergeList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        //使用foreach循环
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i == 0 || num[i] > num[i - 1]) {
                int j = i + 1;
                int k = num.length - 1;
                while (j < k) {
                    if (num[i] + num[j] + num[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        result.add(list);
                        j++;
                        k--;
                        //去除重复结果
                        while (j < k && num[j] == num[j - 1]) {
                            j++;
                        }
                        while (j < k && num[k] == num[k + 1]) {
                            k--;
                        }
                    } else if (num[i] + num[j] + num[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }

    public int[][] threeOrders(TreeNode root) {
        ArrayList<Integer> front = new ArrayList<>();
        ArrayList<Integer> mid = new ArrayList<>();
        ArrayList<Integer> back = new ArrayList<>();
        front(root, front);
        mid(root, mid);
        back(root, back);
        int length = back.size();
        int[][] result = new int[3][length];
        for (int i = 0; i < length; i++) {
            result[0][i] = front.get(i);
        }
        for (int i = 0; i < length; i++) {
            result[1][i] = mid.get(i);
        }
        for (int i = 0; i < length; i++) {
            result[2][i] = back.get(i);
        }
        return result;
    }

    private void back(TreeNode root, ArrayList<Integer> back) {
        if (root == null) return;
        back(root.left, back);
        back(root.right, back);
        back.add(root.val);
    }

    private void mid(TreeNode root, ArrayList<Integer> mid) {
        if (root == null) return;
        mid(root.left, mid);
        mid.add(root.val);
        mid(root.right, mid);
    }

    private void front(TreeNode root, ArrayList<Integer> front) {
        if (root == null) return;
        front.add(root.val);
        front(root.left, front);
        front(root.right, front);
    }

    @Test
    public void testThreeOrders() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int[][] res = threeOrders(root);
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode root) {
        // write code here
        if (root == null)
            return res;
        solve(root, 1);
        return res;
    }

    public void solve(TreeNode root, int depth) {
        if (root == null)
            return;
        if (res.size() < depth)
            res.add(new ArrayList<Integer>());
        if (depth % 2 != 0)
            res.get(depth - 1).add(root.val);
        else
            res.get(depth - 1).add(0, root.val);

        solve(root.left, depth + 1);
        solve(root.right, depth + 1);
    }

    public static void BroadFirstSearch(TreeNode nodeHead) {
        if (nodeHead == null) {
            return;
        }
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(nodeHead);
        while (!myQueue.isEmpty()) {
            TreeNode node = myQueue.poll();
            if (null != node.left) {
                //深度优先遍历，我们在这里采用每一行从左到右遍历
                myQueue.add(node.left);
            }
            if (null != node.right) {
                myQueue.add(node.right);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> levelList = new ArrayList();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (flag) {
                    levelList.add(node.val);
                } else {
                    //添加到头部
                    levelList.add(0, node.val);
                }
            }
            flag = !flag;
            res.add(levelList);
        }
        return res;
    }

    /**
     * 链表中的节点每k个一组翻转
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (head == null || k == 1 || len == 1) {
            return head;
        }
        //需要操作n组节点
        int n = len / k;
        cur = head;
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        while (n > 0) {
            Stack<Integer> stack = new Stack<>();
            int kk = k;
            while (kk > 0) {
                stack.push(cur.val);
                cur = cur.next;
                kk--;
            }
            while (!stack.isEmpty()) {
                temp.next = new ListNode(stack.pop());
                temp = temp.next;
            }
            n--;
        }
        temp.next = cur;
        return newHead.next;
    }

    /**
     * 想办法优化到o（1）
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || k == 1 || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead, cur = head, temp;
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
        return newHead.next;


    }

    @Test
    public void testReverseKGroup() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = reverseKGroup2(head, 2);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int pre = 1;
        int cur = 2;
        int res = 0;
        for (int i = 3; i < target + 1; i++) {
            res = pre + cur;
            pre = cur;
            cur = res;
        }
        return res;
    }

    public int maxLength(int[] arr) {
        int left = 0, right = 0;
        Set<Integer> set = new HashSet<>();
        int res = 1;
        while (right < arr.length) {
            if (!set.contains(arr[right])) {
                set.add(arr[right]);
                right++;
            } else {
                set.remove(arr[left]);
                left++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    @Test
    public void testMaxLength() {
        int[] arr = new int[]{2, 3, 4, 5};
        int res = maxLength(arr);
        System.out.println(res);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (head == null) {
            return null;
        }
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

    @Test
    public void testReverseBetween() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = reverseBetween(head, 2, 4);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.remove(array[i]);
            } else {
                map.put(array[i], true);
            }
        }
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            num1[0] = iterator.next();
            num2[0] = iterator.next();
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int start = 0, end = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            start++;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (start == end) {
                end = queue.size();
                start = 0;
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }

    public boolean isPail(ListNode head) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Object[] array = list.toArray();
        Collections.reverse(list);
        Object[] array2 = list.toArray();
        if (Arrays.equals(array, array2)) {
            return true;
        } else {
            return false;
        }
    }

    public int maxProfit(int[] prices) {
        // write code here
        int days = prices.length;
        if (days < 2) return 0;
        int res = 0;
        int profit;
        int price = prices[0];
        for (int i = 1; i < days; i++) {
            profit = prices[i] - price;
            if (prices[i] < price) {
                price = prices[i];
            }
            res = Math.max(profit, res);
        }
        return res;
    }

    public void merge(int A[], int m, int B[], int n) {
        for (int i = 0; i < n; i++) {
            A[i + m] = B[i];
        }
        Arrays.sort(A);
    }


    int index = 0;

    TreeNode KthNode(TreeNode root, int k) {
        if (root != null) { //中序遍历寻找第k个
            TreeNode node = KthNode(root.left, k);
            if (node != null)
                return node;
            index++;
            if (index == k)
                return root;
            node = KthNode(root.right, k);
            if (node != null)
                return node;
        }
        return null;
    }

    //判断回文的函数
    public boolean isPalindrome(String A, int n) {
        int k = n / 2;
        for (int i = 0; i < k; ++i) {
            if (A.charAt(i) != A.charAt(n - 1 - i))
                return false;
        }
        return true;
    }

    public int getLongestPalindrome(String A, int n) {
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                //两层循环遍历出所有的子串，并且逐一判断是否是回文
                if (isPalindrome(A.substring(i, j), j - i)) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    public int[] getMinStack(int[][] op) {
        // write code here
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < op.length; i++) {
            if (op[i][0] == 1) {
                if (op[i][1] <= min) {
                    stack.push(op[i][1]);
                    min = op[i][1];
                    help.push(min);
                } else {
                    stack.push(op[i][1]);
                }
            } else if (op[i][0] == 2) {
                if (stack.pop().equals(help.peek())) {
                    help.pop();
                    if (!help.isEmpty()) {
                        min = help.peek();
                    } else {
                        min = Integer.MAX_VALUE;
                    }
                }
            } else {
                Integer temp = help.peek();
                res.add(temp);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    @Test
    public void testGetMinStack() {
        //[[1, -185224],[1, -515268],[3],[1, -57301],[2],[2],[1, 539954],[1, 886856],[1, 333965],[3]]
        int[][] map = new int[][]{{1, -185224}, {1, -515268}, {3}, {1, -57301}, {2}, {2}, {1, 539954}, {1, 333965}, {3}};
        int[] res = getMinStack(map);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
