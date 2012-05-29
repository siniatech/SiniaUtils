/*******************************************************************************
 * SiniaUtils
 * Copyright (c) 2011-2 Siniatech Ltd  
 * http://www.siniatech.com/products/siniautils
 *
 * All rights reserved. This project and the accompanying materials are made 
 * available under the terms of the MIT License which can be found in the root  
 * of the project, and at http://www.opensource.org/licenses/mit-license.php
 *
 ******************************************************************************/
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
