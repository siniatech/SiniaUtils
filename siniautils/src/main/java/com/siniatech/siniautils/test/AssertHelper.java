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
package com.siniatech.siniautils.test;

import static org.junit.Assert.*;

import java.util.Collection;

public class AssertHelper {
    static public void assertNotEquals( Object o1, Object o2 ) {
        assertFalse( o1.equals( o2 ) );
    }

    static public <T> void assertContains( T t, Collection<T> coll ) {
        assertTrue( coll.contains( t ) );
    }
}
