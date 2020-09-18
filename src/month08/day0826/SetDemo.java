package month08.day0826;

import java.util.*;

/**
 * @hurusea
 * @create2020-08-26 16:11
 */
public class SetDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            HashSet<Integer> set = new HashSet<>();
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            for (int j = 0; j < num1 + num2; j++) {
                set.add(in.nextInt());
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (Integer integer : set) {
                list.add(integer);
            }
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return integer - t1;
                }
            });

            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
