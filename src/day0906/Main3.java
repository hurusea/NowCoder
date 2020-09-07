package day0906;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-05 14:54
 */
public class Main3 {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        int a = 20;
        try {
            return a + 25;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            System.out.println(a + " ");
            a = a + 10;
        }
        return a;
    }
}
//5 3
//1 2 3 4 5
//5
//left take 1
//right take 2
//left return 3
//right keep
//right take 4
//6
//left take 5
//right take 1
//left return 2
//right return 3
//left take 5
//left return 4
//10
//left take 1
//left keep
//left take 2
//left keep
//left take 3
//left keep
//left take 4
//left keep
//left take 5
//left keep