package month09.day0914;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-14 18:54
 */
public class Main3 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> people = new ArrayList<>();
            ArrayList<Integer> roles = new ArrayList<>();
            int[] result = new int[n];
            int count = 0;
            for (int i1 = 0; i1 < n; i1++) {
                people.add(in.nextInt());
            }
            for (int i1 = 0; i1 < m; i1++) {
                roles.add(in.nextInt());
            }
            Collections.sort(people);
            Collections.sort(roles);
//            int index = 0;
            while (people.size() > 0 && people.get(0) <= roles.get(roles.size() - 1)) {
//                if (people.get(0) > roles.get(index)) {
//                    index++;
//                } else {
//                    people.remove(0);
//                    result[count++] = roles.size() - index;
//                    roles.remove(index);
//                }
                int end = roles.size() - 1;
                int ans = 0;
                while (people.get(people.size() - 1) < roles.get(end)) {
                    ans++;
                    end--;
                }
                result[count++] = ans;
                people.remove(people.size() - 1);
                roles.remove(roles.size() - 1);
            }
            for (int i1 = 0; i1 < result.length - 1; i1++) {
                System.out.print(result[i1] + " ");
            }
            System.out.print(result[result.length - 1]);
        }
    }
}
