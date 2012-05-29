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

}
