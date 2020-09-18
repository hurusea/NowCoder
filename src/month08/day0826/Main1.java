package month08.day0826;


import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-26 18:20
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        String[] res = solve(arr);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            ans.append(res[i] + " ");
        }
        System.out.println(ans);
    }

    private static String[] solve(int[] arr) {
        String[] out = new String[arr.length];
        String[] out2 = new String[arr.length];
        String[] tempS = new String[arr.length];
        String[] ans = new String[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = m(temp);
            String s = Integer.toString(arr[i],2);
            out[i] = s;
        }

        for (int i = 0; i < out.length; i++) {
            String temp = out[i].substring(out[i].length() - 2, out[i].length());
            tempS[i] = temp;
            arr[i] = arr[i] >> 2;
            out2[i] = Integer.toString(arr[i], 2);
        }
        String s = tempS[tempS.length - 1];
        for (int i = 0; i < tempS.length-2; i++) {
            tempS[i + 1] = tempS[i];
        }
        tempS[0] = s;

        for (int i = 0; i < out2.length; i++) {
            StringBuilder builder = new StringBuilder(tempS[i]);
            StringBuilder append = builder.append(out2[i]);
            ans[i] = append.toString();

        }

        for (int i = 0; i < out.length; i++) {
            ans[i] = String.valueOf((int) Math.pow(2, Double.parseDouble(String.valueOf(ans[i]))));
        }
        return ans;
    }

    private static int m(int temp) {
        int ji = temp & 0x55555555;
        int ou = temp & 0xaaaaaaaa;
        return (ou >> 1) ^ (ji << 1);
    }
}
