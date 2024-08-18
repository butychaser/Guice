package com.completablefuture;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureApp {
    static ExecutorService ex = Executors.newFixedThreadPool(1);

    public static class Message implements Serializable {
        Message(String m) {
            _m = m;
        }

        public String toString() {
            return _m;
        }

        private String _m;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            outputWithFuture(new Message(Integer.toString(i)));
        }
        outputWithFuture();
        ex.shutdown();

    }

    public static void outputWithFuture() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(
                () -> "Hello World!",
                ex);
        future.thenAccept(System.out::println);
    }

    public static void outputWithFuture(Message m) {
        System.out.println(m);
        ex.submit(() -> System.out.println("Internal " + m));
    }

}
