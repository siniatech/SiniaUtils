package com.siniatech.siniautils.collection;

import java.util.Collection;

import com.siniatech.siniautils.fn.IConditional;

public class CollectionHelper {

    static public <T> T getArbitraryMember( Collection<T> s ) {
        return s.isEmpty() ? null : s.iterator().next();
    }

    static public <T> boolean exists( Collection<T> collection, IConditional<T> condition ) {
        for ( T t : collection ) {
            if ( condition.apply( t ) ) {
                return true;
            }
        }
        return false;
    }

}
