package com.kenexa;


import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.List;
public class SupplierDemo {
    public static void main(String[] args) {
        List<String> aList = Arrays.asList("alpha", "beta", "delta");
        aList.remove(null);
        Consumer<Supplier<String>> consumerSupplier =  (t)->{System.out.println("Welcome in lambda "+t.get());};
        aList.stream().forEach(name -> consumerSupplier.accept(() -> name));

        aList.stream().forEach(name -> showSupplier(() -> name));

        aList.stream().forEach(name -> showConsumer( SupplierDemo::outputString , name));
        aList.stream().forEach(name -> showConsumer( (s)-> System.out.print(s) , name));

    }

        public static void showSupplier(Supplier<String> input){
        System.out.println("Welcome "+ input.get());
        }
        public static void showConsumer(Consumer<String> input,String inputString){
        input.accept(inputString);
        }
        public static void outputString(String s)
        {
            System.out.println(s);
        }
    }

