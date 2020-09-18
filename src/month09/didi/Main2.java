package month09.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-13 18:58
 */
public class Main2 {
    public static int check = 0;
    public static void search(int[] vis, node root, List<node> list) {
        for (int i = 0; i < root.next.size(); i++) {
            int id = root.next.get(i).a;
            if (vis[id - 1] != 1) {
                vis[id - 1] = 1;
                check++;
                search(vis, list.get(id - 1), list);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t > 0) {
            t--;
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            ArrayList<node> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new node(i + 1, new ArrayList<>()));
            }
            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                if (c < k) {
                    list.get(a - 1).next.add(list.get(b - 1));
                    list.get(b - 1).next.add(list.get(a - 1));
                }
            }
            int[] vis = new int[n];
            check = 0;
            vis[0] = 1;
            check++;
            search(vis, list.get(0), list);
            if (check == n) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

}
class node{
    int a;
    List<node> next;

    public node(int a, List<node> next) {
        this.a = a;
        this.next = next;
    }
}
