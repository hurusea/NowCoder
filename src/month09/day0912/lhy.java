package month09.day0912;

/**
 * @hurusea
 * @create2020-09-13 11:17
 */
import java.util.*;

class Composition extends ArrayList<Integer> {
    @Override
    public boolean equals(Object other) {
        Composition comp = (Composition) other;
        Collections.sort(this);
        Collections.sort(comp);
        if (this.isEmpty() || comp.isEmpty() || this.size() != comp.size())
            return false;
        for (int i = 0; i < this.size(); i++)
            if (this.get(i) != comp.get(i))
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

/**
 * 用递归法,比如2=1+1,3=1+(2的所有组成法),5需要分解1+4,2+3,因为3+2和2+3是一样的,for循环只要到i<=n/2就够了.
 然后就是剔除1+1+2和1+2+1的情况,继承set的特性重写了Composition(每个拆分的方式)的equals.
 懒得读取n值了,直接在main里面赋值给n
 * @author yxx
 *
 */
public class lhy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int d = in.nextInt();
        int temp = 5;
        System.out.println(toStr(calc(temp)));
    }

    public static Set<Composition> calc(int n) {
        Set<Composition> possibility = new HashSet<Composition>();
        Composition composition = new Composition();
        switch (n) {
            case 1:
                composition.add(1);
                possibility.add(composition);
                return possibility;
            case 2:
                composition.add(1);
                composition.add(1);
                possibility.add(composition);
                return possibility;
            default:
                for (int i = 1; i <= n / 2; i++) {
                    composition = new Composition();
                    composition.add(i);
                    composition.add(n - i);
                    possibility.add(composition);
                    if (i <= n - i) {
                        Set<Composition> partial_pos = calc(n - i);
                        for (Composition pos : partial_pos) {
                            pos.add(i);
                            possibility.add(pos);
                        }
                    }
                }
                return possibility;
        }

    }

    public static String toStr(Set<Composition> possibility) {
        String str = "total : " + possibility.size() + "\n";
        for (Composition pos : possibility)
            str += toStr(pos);
        return str;
    }

    public static String toStr(Composition composition) {
        String str = composition.get(0) + "";
        for (int i = 1; i < composition.size(); i++)
            str += (" + " + composition.get(i));
        str += "\n";
        return str;
    }
}
