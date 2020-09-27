package month09.day0922;

/**
 * @hurusea
 * @create2020-09-25 14:13
 */
public class Test {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 777; i++) {
            if (i % 8 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
