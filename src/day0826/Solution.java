package day0826;

import day0418.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @hurusea
 * @create2020-08-27 14:48
 */
public class Solution {

    public static void main(String[] args) {
        // 构建二叉树
        /**
         *              1
         *           2     3
         *        4      5     6
         *            7    8
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        Solution test = new Solution();
        System.out.println(test.leftSideView(root));
        System.out.println(test.rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideView(root, list, 0);
        return list;
    }

    public void rightSideView(TreeNode root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.val);
        }
        rightSideView(root.right, list, level + 1);
        rightSideView(root.left, list, level + 1);

    }

    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        leftSideView(root, list, 0);
        return list;
    }

    public void leftSideView(TreeNode root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size()) {
            list.add(root.val);
        }
        leftSideView(root.left, list, level + 1);
        leftSideView(root.right, list, level + 1);

    }
}
