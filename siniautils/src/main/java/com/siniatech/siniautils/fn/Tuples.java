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
package com.siniatech.siniautils.fn;

public class Tuples {
    public static <T, U> ITuple2<T, U> tuple2( T first, U second ) {
        return new Tuple2<T, U>( first, second );
    }
}
