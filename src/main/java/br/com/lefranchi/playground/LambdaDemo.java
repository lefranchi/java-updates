package br.com.lefranchi.playground;

import java.util.function.BiConsumer;

public class LambdaDemo {

    public static void main(String[] args) {

        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println(a + b);
        biConsumer.accept(10, 5);

    }



}
