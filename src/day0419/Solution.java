package day0419;

import org.junit.Test;

/**
 * @hurusea
 * @create2020-04-19 11:27
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3, p = 1000000007;
        long x = 3, mul = 1;
        for (int i = a - 1; i > 0; i /= 2) {
            if (i % 2 == 1) mul = (mul * x) % p;
            x = x * x % p;
        }
        if (b == 0) return (int) (mul * 3 % p);
        if (b == 1) return (int) (mul * 4 % p);
        return (int) (mul * 6 % p);
    }

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

}
