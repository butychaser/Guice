package com.lambda;

import java.util.function.Function;

public class LambdaApp {

    public static void main(String[] args) {
        System.out.println(doIt((t) -> t * t, 9));
        System.out.println(doIt(new SquareOperator(), 9));

    }

    public static Integer doIt(Function<Integer, Integer> ops, Integer i) {
        return ops.apply(i);
    }

}
