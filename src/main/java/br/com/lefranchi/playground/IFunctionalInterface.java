package br.com.lefranchi.playground;

@FunctionalInterface
public interface IFunctionalInterface {

    void firstAbstractMethod();

    default void printSomethinng1() {
        System.out.println("Something 1!");
    }

    default void printSomethinngAgain() {
        System.out.println("Something Again!");
    }

}
