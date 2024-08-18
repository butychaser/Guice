package com.kenexa;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args){
        Consumer<String> consumerInAnonymousClass = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println("Welcome with consumerInLambda " + o);
            }
        };
        consumerInAnonymousClass.accept("alpha");
        consumerInAnonymousClass.accept("beta");
        consumerInAnonymousClass.accept("delta");

        Consumer<String> consumerInLambda = (String t) -> {System.out.println("Welcome with consumerInLambda " + t);};
        consumerInLambda.accept("alpha");
        consumerInLambda.accept("beta");
        consumerInLambda.accept("delta");

        Consumer<String> consumer = ConsumerDemo::showConsumer;
        consumer.accept("alpha");
        consumer.accept("beta");
        consumer.accept("delta");
        BiConsumer<ArrayList, ArrayList> b = (ArrayList result, ArrayList input) -> result.addAll(input);
        BiConsumer<ArrayList, ArrayList> c = ArrayList::addAll;


    }
    public static void showConsumer(String input){
        System.out.println("Welcome with consumer "+ input);
    }
}
