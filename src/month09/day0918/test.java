package month09.day0918;

/**
 * @hurusea
 * @create2020-09-18 10:34
 */
public class test {
    father father = new father();
    father son = new son();
//    father.say();
//    son.say();
}

class father {
    private static void say() {
        System.out.println("hello");
    }
}

class son extends father {
    private static void say() {
        System.out.println("hello i am son");
    }
}
