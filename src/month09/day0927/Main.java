package month09.day0927;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        System.out.println(a == b);

    }

    public static boolean isPrime(int n) {
        int i = 2;
        for (; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public Integer[] findPrime(Integer[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                res.add(nums[i]);
            }
        }
        Integer[] ans = new Integer[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
