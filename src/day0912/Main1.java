package day0912;

import java.util.*;

/**
 * @hurusea
 * @create2020-09-12 12:39
 */
public class Main1 {
    public static void main(String args[]) {
        //10 9
        //1 left 2
        //1 right 3
        //2 left 4
        //2 right 5
        //3 right 6
        //6 left 7
        //6 right 8
        //7 left 9
        //7 right 10
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.nextLine();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> listTemp = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] split = s.split(" ");
            Integer l = Integer.valueOf(split[0]);
            Integer r = Integer.valueOf(split[2]);

            if (!set.contains(l)) {
                set.add(l);
            }
            if (!set.contains(l)) {
                list.add(l);
            }

        }


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}