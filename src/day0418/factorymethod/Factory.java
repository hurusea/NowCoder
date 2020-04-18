package day0418.factorymethod;

import day0418.simplefactory.Product;

/**
 * @hurusea
 * @create2020-04-18 19:44
 */
public abstract class Factory {
    abstract public Product factoryMethod();

    public void dosomething() {
        Product product = factoryMethod();
    }
}
