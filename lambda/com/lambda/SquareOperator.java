package com.lambda;

import java.util.function.Function;

public class SquareOperator implements Function<Integer, Integer>
{

    @Override
    public Integer apply (Integer t)
    {
        // TODO Auto-generated method stub
        return t * t;
    }

}
