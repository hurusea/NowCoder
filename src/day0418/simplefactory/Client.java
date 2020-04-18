package day0418.simplefactory;

/**
 * @hurusea
 * @create2020-04-18 19:42
 */
public class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(2);
    }
}
