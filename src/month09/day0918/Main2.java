package month09.day0918;

import java.util.*;
public class Main2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] items = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            items[i] = Integer.parseInt(split[i]);
        }
        int res = buy(money, items);
        System.out.println(res);
    }
    public static int buy(int money,int[] items) {
        int res = 0;
        //快速排序，打印排序结果
        Arrays.sort(items);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            int num = money / items[i];
            for (int j = 0; j < num; j++) {
                list.add(items[i]);
            }
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        int length = 0;
        for (; length < array.length && array[length] <= money; length++) ;
        int[] values = new int[length];
        for (int i = 0; i < length; i++) values[i] = array[i];
        Stack<Integer> stack = new Stack<Integer>();
        int tempmoney = 0;
        int m = 0;
        while (m < length) {
            if (tempmoney + values[m] < money) {
                stack.push(m);
                tempmoney = tempmoney + values[m];
                m++;
            } else {
                if (tempmoney + values[m] == money)res++;
                if (stack.size() > 0) {
                    int n = stack.pop();
                    tempmoney = tempmoney - values[n];
                    m = n + 1;
                    for (; values[m] == values[n]; m++) ;
                } else  break;
            }
        }
        return res;
    }
}
