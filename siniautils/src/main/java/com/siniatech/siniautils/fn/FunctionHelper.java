package com.siniatech.siniautils.fn;

public class FunctionHelper {

    static public <T> IConditional<T> and( final IConditional<T> c1, final IConditional<T> c2 ) {
        return new IConditional<T>() {
            @Override
            public Boolean apply( T t ) {
                return c1.apply( t ) && c2.apply( t );
            }
        };
    }

    static public <T> IConditional<T> or( final IConditional<T> c1, final IConditional<T> c2 ) {
        return new IConditional<T>() {
            @Override
            public Boolean apply( T t ) {
                return c1.apply( t ) || c2.apply( t );
            }
        };
    }

}
