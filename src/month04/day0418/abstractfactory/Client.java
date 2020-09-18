package month04.day0418.abstractfactory;

/**
 * @hurusea
 * @create2020-04-18 19:57
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.creatrProductA();
        AbstractProductB productB = abstractFactory.creatrProductB();
    }
}
