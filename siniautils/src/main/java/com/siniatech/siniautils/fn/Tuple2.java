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

public class Tuple2<T, U> implements ITuple2<T, U> {

    private final T first;
    private final U second;

    public Tuple2( T first, U second ) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T _1() {
        return first;
    }

    @Override
    public U _2() {
        return second;
    }

}
