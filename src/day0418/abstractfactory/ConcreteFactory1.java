package day0418.abstractfactory;

/**
 * @hurusea
 * @create2020-04-18 19:55
 */
public class ConcreteFactory1 extends AbstractFactory {

    @Override
    AbstractProductA creatrProductA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB creatrProductB() {
        return new ProductB1();
    }

}
