package com.siniatech.siniautils.fn;

public class Tuple2<T, U> implements ITuple2<T, U> {

    private final T first;
    private final U second;

    public Tuple2( T first, U second ) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T _1() {
        return first;
    }

    @Override
    public U _2() {
        return second;
    }

}
