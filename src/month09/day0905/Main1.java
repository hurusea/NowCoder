package month09.day0905;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @hurusea
 * @create2020-09-05 14:54
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nextLine = in.nextLine();
        String[] s1 = nextLine.split(" ");
        //货物数量
        int n = Integer.parseInt(s1[0]);
        Object[] stacks = new Object[n];
        //人数
        int m = Integer.parseInt(s1[1]);
        int[] prices = new int[n];
        String s = in.nextLine();
        String[] split = s.split(" ");
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.valueOf(split[i]);
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < 1000; j++) {
                stack.push(prices[i]);
            }
            stacks[i] = stack;
        }
        //m个人的操作记录
        ArrayList<String> steps = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            //每个人的操作次数
            int ki = Integer.parseInt(in.nextLine());
            for (int j = 0; j < ki; j++) {
                steps.add(in.nextLine());
            }
            int res = solution(n, m, prices, stacks, steps, ki);
            System.out.println(res);
            steps.clear();
        }
    }

    private static int solution(int n, int m, int[] prices, Object[] stacks, ArrayList<String> steps, int ki) {
        int res = 0;
        int left = 0;
        int right = 0;
        int bag = 0;
        for (int i = 0; i < steps.size(); i++) {
            String[] split = steps.get(i).split(" ");
            if (split[0].equals("left")) {
                if (split[1].equals("take")) {
                    int index = Integer.parseInt(split[2]) - 1;
                    Stack<Integer> temp = (Stack<Integer>) stacks[index];
                    left = temp.pop();
                } else if (split[1].equals("return")) {
                    int index = Integer.parseInt(split[2]) - 1;
                    Stack<Integer> temp = (Stack<Integer>) stacks[index];
                    temp.push(left);
                    left = 0;
                } else {
                    //keep
                    bag += left;
                    left = 0;
                }
            } else {
                if (split[1].equals("take")) {
                    int index = Integer.parseInt(split[2]) - 1;
                    Stack<Integer> temp = (Stack<Integer>) stacks[index];
                    temp.pop();
                    right = temp.pop();
                } else if (split[1].equals("return")) {
                    int index = Integer.parseInt(split[2]) - 1;
                    Stack<Integer> temp = (Stack<Integer>) stacks[index];
                    temp.push(right);
                    right = 0;
                } else {
                    //keep
                    bag += right;
                    right = 0;
                }
            }
        }
        res = bag + left + right;
        return res;
    }
}
