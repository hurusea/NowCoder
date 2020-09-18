package month04.day0418.simplefactory;

/**
 * @hurusea
 * @create2020-04-18 19:40
 */
public class SimpleFactory {
    public Product createProduct(int type) {
        if (type == 1) {
            return new ConcreteProduct();
        } else if (type == 2) {
            return new ConcreteProduct2();
        } else {
            return new ConcreteProduct3();
        }
    }
}
