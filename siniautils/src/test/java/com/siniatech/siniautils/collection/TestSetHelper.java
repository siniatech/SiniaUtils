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

import static com.siniatech.siniautils.collection.SetHelper.*;
import static com.siniatech.siniautils.test.AssertHelper.*;
import static junit.framework.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.siniatech.siniautils.named.Named;

public class TestSetHelper {

    @Test
    public void asSet_handlesNull() throws Exception {
        Set<String> nullSet = SetHelper.<String> asSet( (String) null );
        assertEquals( 1, nullSet.size() );
        assertContains( null, nullSet );
    }

    @Test
    public void asSet_obj() throws Exception {
        List<String> a = Arrays.asList( "a" );
        List<String> b = Arrays.asList( "b", "B" );
        List<String> c = Arrays.asList( "C", "3", "c" );
        Set<List<String>> intSet = asSet( a, b, c );
        assertEquals( 3, intSet.size() );
        assertContains( a, intSet );
        assertContains( b, intSet );
        assertContains( c, intSet );
    }

    @Test
    public void asSet_primitive() throws Exception {
        Set<Integer> intSet = asSet( 1, 2, 3 );
        assertEquals( 3, intSet.size() );
        assertContains( 1, intSet );
        assertContains( 2, intSet );
        assertContains( 3, intSet );
    }

    @SuppressWarnings("cast")
    @Test
    public void emptySet_isZeroCardinalitySet() throws Exception {
        assertEquals( 0, emptySet().size() );
        assertTrue( emptySet() instanceof Set );
    }

    @Test
    public void union_failsOnNull_p1() throws Exception {
        try {
            union( asSet( "a" ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void union_failsOnNull_p2() throws Exception {
        try {
            union( null, asSet( "a" ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void union_obj() throws Exception {
        Named a = new Named( "a" );
        Named b = new Named( "b" );
        assertEquals( asSet( a, b ), union( asSet( a ), asSet( b ) ) );
        assertEquals( asSet( a, b ), union( asSet( a, b ), SetHelper.<Named> asSet() ) );
        assertEquals( asSet( a, b ), union( SetHelper.<Named> asSet(), asSet( a, b ) ) );
        assertEquals( asSet( a, b ), union( asSet( a, b ), asSet( a, b ) ) );
    }

    @Test
    public void union_primitive() throws Exception {
        assertEquals( asSet( 1, 2 ), union( asSet( 1 ), asSet( 2 ) ) );
        assertEquals( asSet( 1, 2 ), union( asSet( 1, 2 ), SetHelper.<Integer> asSet() ) );
        assertEquals( asSet( 1, 2 ), union( SetHelper.<Integer> asSet(), asSet( 1, 2 ) ) );
        assertEquals( asSet( 1, 2 ), union( asSet( 1, 2 ), asSet( 1, 2 ) ) );
    }

}
