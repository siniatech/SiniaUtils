package com.siniatech.siniautils.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.siniatech.siniautils.fn.IConditional;

public class CollectionHelper {

    static public <T> T getArbitraryMember( Collection<T> s ) {
        return s.isEmpty() ? null : s.iterator().next();
    }

    static public <T> boolean exists( Collection<T> collection, IConditional<T> condition ) {
        return find( collection, condition ) != null;
    }

    static public <T> T find( Collection<T> collection, IConditional<T> condition ) {
        for ( T t : collection ) {
            if ( condition.apply( t ) ) {
                return t;
            }
        }
        return null;
    }

    static public <T> Collection<T> filter( Collection<T> collection, IConditional<T> condition ) {
        List<T> result = new ArrayList<>();
        for ( T t : collection ) {
            if ( condition.apply( t ) ) {
                result.add( t );
            }
        }
        return result;
    }

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
                return t != null && t.equals( u );
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
