package month09.day0922;

/**
 * @hurusea
 * @create2020-09-22 14:44
 */
public class AddMax {
    public static void main(String[] args) {
        String s = "fhzgtzezf";
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (c < s.charAt(i)) {
                c = s.charAt(i);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            if (c == s.charAt(i)) {
                System.out.print("(max)");
            }
        }
    }
}
