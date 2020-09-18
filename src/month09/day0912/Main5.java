package month09.day0912;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-12 15:59
 */
public class Main5 {
    public static int out = 0;

    public static void search(node root) {
        if (root.left != null && root.right != null) {
            node left = root.left;
            node right = root.right;
            if (left.left == null && left.right == null && right.left == null && right.right == null) {
                out++;
            } else {
                search(left);
                search(right);
            }
        } else {
            if (root.left != null) {
                search(root.left);
            }
            if (root.right != null) {
                search(root.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        ArrayList<node> list = new ArrayList<>();
        in.nextLine();
        for (int i = 0; i < a; i++) {
            list.add(new node(i + 1, null, null));
        }
        for (int i = 0; i < b; i++) {
            String s = in.nextLine();
            String[] t = s.split(" ");
            int n = Integer.valueOf(t[0]);
            int m = Integer.valueOf(t[2]);
            node root = list.get(n - 1);
            node child = list.get(m - 1);
            if (t[1].equals("right")) {
                root.right = child;
            } else {
                root.left = child;
            }
        }
        search(list.get(0));
        System.out.println(out);
    }

}

class node {
    int v;
    node left;
    node right;

    public node(int v, node left, node right) {
        this.v = v;
        this.left = left;
        this.right = right;
    }
}
