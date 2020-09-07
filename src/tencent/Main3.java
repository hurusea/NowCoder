package tencent;

import java.util.*;

/**
 * @hurusea
 * @create2020-04-26 19:19
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            if (map.containsKey(s)) {
                int v = map.get(s);
                map.put(s, v + 1);
            } else {
                map.put(s, 1);
            }
        }
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        for (String s : map.keySet()) {
            list1.add(new Node(map.get(s), s));
            list2.add(new Node(map.get(s), s));
        }
        list1.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.num != o2.num) {
                    return o2.num - o1.num;
                } else {
                    if (o1.s.compareTo(o2.s) > 0) {
                        return 1;
                    } else return -1;
                }
            }
        });
        list2.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.num != o2.num) {
                    return o2.num - o1.num;
                } else {
                    if (o1.s.compareTo(o2.s) < 0) {
                        return 1;
                    } else return -1;
                }
            }
        });
        for (int i = 0; i < k; i++) {
            System.out.println(list1.get(i).s + " " + String.valueOf(list1.get(i).num));
        }
        for (int i = list2.size() - 1; i >= list2.size() - k; i--) {
            System.out.println(list2.get(i).s + " " + String.valueOf(list2.get(i).num));
        }
    }
}

class Node {
    int num;
    String s;

    Node(int num, String s) {
        this.num = num;
        this.s = s;
    }
}
