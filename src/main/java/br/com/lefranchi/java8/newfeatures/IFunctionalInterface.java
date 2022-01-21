package br.com.lefranchi.java8.newfeatures;

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
