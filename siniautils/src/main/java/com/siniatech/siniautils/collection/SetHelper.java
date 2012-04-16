package com.siniatech.siniautils.collection;

import java.util.HashSet;
import java.util.Set;

public class SetHelper {

    static public <T> Set<T> asSet( T... members ) {
        Set<T> set = new HashSet<>();
        for ( T t : members ) {
            set.add( t );
        }
        return set;
    }

    static public <T> Set<T> union( Set<T> s1, Set<T> s2 ) {
        Set<T> set = new HashSet<>( s1 );
        set.addAll( s2 );
        return set;
    }

    static public <T> Set<T> emptySet() {
        return new HashSet<>();
    }
    
}
