package com.siniatech.siniautils.fn;

public class ConditionalHelper {

    @SuppressWarnings("rawtypes")
    static private IConditional alwaysTrue = new IConditional() {
        @Override
        public Boolean apply( Object t ) {
            return true;
        }
    };

    static public <T> IConditional<T> alwaysTrue() {
        return alwaysTrue;
    }

    @SuppressWarnings("rawtypes")
    static private IConditional alwaysFalse = new IConditional() {
        @Override
        public Boolean apply( Object t ) {
            return false;
        }
    };

    static public <T> IConditional<T> alwaysFalse() {
        return alwaysFalse;
    }

    static public <T> IConditional<T> equalsValue( final T u ) {
        return new IConditional<T>() {
            @Override
            public Boolean apply( T t ) {
                if ( t == null ) {
                    return u == null;
                } else {
                    return t.equals( u );
                }
            }
        };
    }

    static public <T> IConditional<T> equalsIdentity( final T u ) {
        return new IConditional<T>() {
            @Override
            public Boolean apply( T t ) {
                return t == u;
            }
        };
    }
}