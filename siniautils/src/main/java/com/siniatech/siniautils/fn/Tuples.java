package com.siniatech.siniautils.fn;

public class Tuples {
    public static <T, U> ITuple2<T, U> tuple2( T first, U second ) {
        return new Tuple2<T, U>( first, second );
    }
}
