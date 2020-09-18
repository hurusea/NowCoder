package month04.day0418;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @hurusea
 * @create2020-04-18 10:20
 */
public class Solution {
    /**
     * 找出数组中重复的数字。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     * 判断数组中是否含有该整数。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length - 1;
        if (m < 0) {
            return false;
        }
        int n = matrix[0].length - 1;
        if (n < 0) {
            return false;
        }
        for (int i = 0; i <= m; i++) {
            for (int j = n; j >= 0; j--) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return false;
    }


    public String replaceSpace(String s) {
//        return s.replace(" ", "%20");
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append(new char[]{'%', '2', '0'});
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, preorder.length - 1);
    }

    public TreeNode recur(int pre_root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(po[pre_root]);
        int i = map.get(po[pre_root]);
        root.left = recur(pre_root + 1, left, i - 1);
        root.right = recur(pre_root + 1 + i - left, i + 1, right);
        return root;
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];
    }

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];
    }

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else right--;
        }
        return numbers[left];
    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1)
                || dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1);
        board[i][j] = temp;
        return res;
    }

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n-1;
        }
        int b = n % 3,p=1000000007;
        int sum =1,x=3;
        for (int i = n/3-1; i >0 ; i=i/2) {
            if (i % 2 == 1) sum = sum * x % p;
            x=x*x%p;
        }
        if(b == 0) return (int)(sum * 3 % p);
        if(b == 1) return (int)(sum * 4 % p);
        return (int)(sum * 6 % p);
    }
}