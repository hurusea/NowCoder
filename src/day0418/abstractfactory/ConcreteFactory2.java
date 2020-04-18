package day0418.abstractfactory;

/**
 * @hurusea
 * @create2020-04-18 19:56
 */
public class ConcreteFactory2 extends AbstractFactory{
    @Override
    AbstractProductA creatrProductA() {
        return new ProductA2();
    }

    @Override
    AbstractProductB creatrProductB() {
        return new ProductB2();
    }
}
