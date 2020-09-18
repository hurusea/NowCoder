package month08.day0829;

import java.util.*;

/**
 * @hurusea
 * @create2020-08-29 15:51
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        Node[] series = new Node[n + 1];
        for (int i = 0; i < n + 1; i++) {
            series[i] = new Node(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int low = in.nextInt();
            int high = in.nextInt();
            series[low].next.add(series[high]);
            series[high].next.add(series[low]);
        }
        int[] passBy = new int[n + 1];
        Queue<Node> list = new LinkedList<>();
        list.add(series[a]);
        passBy[a] = 1;
        while (!list.isEmpty()) {
            Node t = list.poll();
            for (int i = 0; i < t.next.size(); i++) {
                Node cur = t.next.get(i);
                if (passBy[cur.id] == 0) {
                    cur.v = t.v + 1;
                    passBy[cur.id] = 1;
                    list.add(cur);
                }
            }
        }
        int[] from = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            from[i] = series[i].v;
        }
        for (int i = 0; i < n + 1; i++) {
            series[i].v = 0;
            passBy[i] = 0;
        }
        list.clear();
        list.add(series[b]);
        passBy[b] = 1;
        while (!list.isEmpty()) {
            Node t = list.poll();
            for (int i = 0; i < t.next.size(); i++) {
                Node cur = t.next.get(i);
                if (passBy[cur.id] == 0) {
                    cur.v = t.v + 1;
                    passBy[cur.id] = 1;
                    list.add(cur);
                }
            }
        }
        int[] to = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            to[i] = series[i].v;
        }
        int out = 0;
        for (int i = 0; i < n + 1; i++) {
            if (from[i] > to[i] && out < from[i]) {
                out = from[i];
            }
        }
        System.out.println(out);
    }
}
class Node{
    int id;
    int v;
    List<Node> next;

    public Node(int id, List<Node> next) {
        this.id = id;
        this.next = next;
    }
}