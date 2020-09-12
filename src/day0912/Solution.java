package day0912;

import org.junit.Test;

import java.util.Arrays;

/**
 * @hurusea
 * @create2020-09-12 12:39
 */
public class Solution {

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] res = new int[colLen + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[1] = 0;
        for (int i = 1; i <= rowLen; i++) {
            for (int j = 1; j <= colLen; j++) {
                //当前点的最小路径和为 : 从左边和上边选择最小的路径和再加上当前点的值
                //res[j]没更新之前就表示i-1行到第j个元素的最小路径和
                //因为是从左往右更新,res[j-1]表示i行第j-1个元素的最小路径和
                res[j] = Math.min(res[j], res[j - 1]) + grid[i - 1][j - 1];
            }
        }
        return res[colLen];
    }

    @Test
    public void testMinPathSum() {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int res = minPathSum(grid);
        System.out.println(res);
    }

    public boolean isContains (TreeNode root1, TreeNode root2) {
        //if(root1==null&&root2==null) return true;
        if (root1==null || root2==null)
            return false;
        // write code here
        return recur(root1,root2) || isContains(root1.left,root2) || isContains(root1.right,root2);
    }
    public boolean recur(TreeNode root1 ,TreeNode root2){
        if (root2 == null)
            return true;
        if (root1 == null || root1.val != root2.val)
            return false;
        return recur(root1.left,root2.left) && recur(root1.right,root2.right);
    }

    public int solve (char[][] matrix) {
        // write code here
        if (matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0] - 48;
        }
        if (matrix.length == 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                if (matrix[i][j] == '1') {
                    int temp = Math.min(matrix[i][j - 1] - 48, matrix[i - 1][j] - 48);
                    temp = Math.min(temp, matrix[i - 1][j - 1] - 48) + 1;
                    matrix[i][j] =  (char)(48 + temp);
                    if (ans < temp) {
                        ans = temp;
                    }

                }
            }
        }
        return ans * ans;
    }

}
