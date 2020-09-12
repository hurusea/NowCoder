package day0911;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-09-11 14:48
 */
public class Main2 {
    public static void main(String[] args) {
        B b = new B();
    }
}

class A {
    static int anInt = 0;

    static void function() {
        System.out.println(anInt);
    }
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        System.out.println("B");
    }
}