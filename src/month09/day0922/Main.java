package month09.day0922;

import java.util.*;

/**
 * @hurusea
 * @create2020-09-22 19:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] split = s.split(" ");
            int nowTime = Integer.valueOf(split[0]);
            int order = Integer.valueOf(split[1]);
            int flag = Integer.valueOf(split[2]);
            Node node = new Node(nowTime, order, flag);
            nodes.add(node);
        }
        solution(nodes, n);
    }

    private static void solution(ArrayList<Node> nodes, int n) {
        Stack<Node> stack = new Stack<>();
        int len = nodes.size();
        int maxTime = 0;
        int childTime = 0;
        int res = 1;
        for (int i = 0; i < len; i++) {
            Node temp = nodes.get(i);
            if (temp.flag == 0) {
                stack.push(temp);
            } else {
                if (stack.isEmpty())
                    System.out.println("error");
                if (temp.flag == 1 && temp.order != stack.peek().order) {
                    System.out.println("error");
                } else {
                    Node pop = stack.pop();
                    int timeCost = temp.nowTime - pop.nowTime - childTime;
                    if (maxTime < timeCost) {
                        maxTime = timeCost;
                        res = pop.order;
                    }
                    childTime += timeCost;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println(res);
        } else {
            System.out.println("error");
        }
    }
}
class Node{
    int nowTime;
    int order;
    int flag;

    public Node(int nowTime, int order, int flag) {
        this.nowTime = nowTime;
        this.order = order;
        this.flag = flag;
    }
}
