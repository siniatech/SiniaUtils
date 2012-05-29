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
import java.util.List;

public class ListHelper {

    static public <T> T head( List<T> list ) {
        return list.size() == 0 ? null : list.get( 0 );
    }

    static public <T> List<T> tail( List<T> list ) {
        List<T> tail = new ArrayList<>( list );
        tail.remove( head( list ) );
        return tail;
    }
}
