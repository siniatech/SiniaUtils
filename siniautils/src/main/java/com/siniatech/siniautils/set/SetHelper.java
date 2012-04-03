package com.siniatech.siniautils.set;

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
}
