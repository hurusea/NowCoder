package month09.day0920;

import java.io.*;
import java.util.*;

/**
 * @hurusea
 * @create2020-09-20 16:41
 */
public class Main2 {
    static int[] c;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String[] a = b.readLine().trim().split(" ");
        int n = Integer.parseInt(a[0]);
        long w = Integer.parseInt(a[1]);
        int k = Integer.parseInt(a[2]);

        c = new int[n];
        p = new int[n];
        String[] aa = b.readLine().trim().split(" ");
        String[] aaa = b.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(aa[i]);
            p[i] = Integer.parseInt(aaa[i]);
        }
        b.close();

        PriorityQueue<Integer> maxH = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return p[o2] - p[o1];
            }
        });
        PriorityQueue<Integer> minH = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return c[o1] - c[o2];
            }
        });
        for (int i = 0; i < n; i++) {
            if (c[i] > w) {
                minH.add(i);
            } else {
                maxH.add(i);
            }
        }
        while (k != 0 && !maxH.isEmpty()) {
            while (!minH.isEmpty() && c[minH.peek()] <= w) {
                maxH.offer(minH.poll());
            }
            w += p[maxH.poll()];
            k--;
        }
        System.out.println(w);
    }
}
