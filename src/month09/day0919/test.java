package month09.day0919;

/**
 * @hurusea
 * @create2020-09-20 12:51
 */
public class test {
    public static void main(String[] args) {
        showOne(13);
    }

    private static void showOne(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        System.out.println(count);
    }
}