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
package com.siniatech.siniautils.swing;

import static com.siniatech.siniautils.swing.BoundsHelper.*;
import static junit.framework.Assert.*;

import java.util.Arrays;

import javax.swing.JComponent;

import org.junit.Test;

import com.siniatech.siniautils.test.fixtures.DummyLabel;

public class TestBoundsHelper_XMostComponent {

    static final private JComponent a = new DummyLabel( "a" );
    static final private JComponent b = new DummyLabel( "b" );
    static final private JComponent c = new DummyLabel( "c" );

    @Test
    public void getTopLeftmostComponent_failsWithNull() {
        try {
            getTopLeftmostComponent( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getTopLeftmostComponent_failsWithDuplicateComponentAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        try {
            getTopLeftmostComponent( Arrays.<JComponent> asList( a, a ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getTopLeftmostComponent_failsWithDuplicateCornerAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        try {
            getTopLeftmostComponent( Arrays.<JComponent> asList( a, b ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getTopLeftmostComponent_emptyList() {
        assertEquals( null, getTopLeftmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getTopLeftmostComponent_single() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getTopLeftmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getTopLeftmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getTopLeftmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getTopLeftmostComponent_multiple() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 25, 25, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getTopLeftmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getTopLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getTopLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getTopLeftmostComponent_alwaysReturnsLeftmost() {
        a.setBounds( 0, 100, 50, 50 );
        b.setBounds( 1, 75, 75, 100 );
        c.setBounds( 2, 50, 75, 100 );
        assertEquals( a, getTopLeftmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getTopLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getTopLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getTopLeftmostComponent_returnsTopmostOfEqualLeftmost() {
        a.setBounds( 0, 100, 50, 50 );
        b.setBounds( 0, 75, 75, 100 );
        c.setBounds( 0, 50, 75, 100 );
        assertEquals( b, getTopLeftmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( c, getTopLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( c, getTopLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getLeftTopmostComponent_failsWithNull() {
        try {
            getLeftTopmostComponent( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getLeftTopmostComponent_failsWithDuplicateComponentAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        try {
            getLeftTopmostComponent( Arrays.<JComponent> asList( a, a ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getLeftTopmostComponent_failsWithDuplicateCornerAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        try {
            getLeftTopmostComponent( Arrays.<JComponent> asList( a, b ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getLeftTopmostComponent_emptyList() {
        assertEquals( null, getLeftTopmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getLeftTopmostComponent_single() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getLeftTopmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getLeftTopmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getLeftTopmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getLeftTopmostComponent_multiple() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 25, 25, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getLeftTopmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getLeftTopmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getLeftTopmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getLeftTopmostComponent_alwaysReturnsTopmost() {
        a.setBounds( 100, 0, 50, 50 );
        b.setBounds( 70, 1, 75, 100 );
        c.setBounds( 35, 2, 75, 100 );
        assertEquals( a, getLeftTopmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getLeftTopmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getLeftTopmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getLeftTopmostComponent_returnsLeftmostOfEqualTopmost() {
        a.setBounds( 100, 0, 50, 50 );
        b.setBounds( 75, 0, 75, 100 );
        c.setBounds( 50, 0, 75, 100 );
        assertEquals( b, getLeftTopmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( c, getLeftTopmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( c, getLeftTopmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getTopRightmostComponent_failsWithNull() {
        try {
            getTopRightmostComponent( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getTopRightmostComponent_failsWithDuplicateComponentAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        try {
            getTopRightmostComponent( Arrays.<JComponent> asList( a, a ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getTopRightmostComponent_failsWithDuplicateCornerAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 25, 0, 25, 100 );
        try {
            getTopRightmostComponent( Arrays.<JComponent> asList( a, b ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getTopRightmostComponent_emptyList() {
        assertEquals( null, getTopRightmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getTopRightmostComponent_single() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getTopRightmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getTopRightmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getTopRightmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getTopRightmostComponent_multiple() {
        a.setBounds( 0, 0, 30, 50 );
        b.setBounds( 0, 25, 20, 100 );
        c.setBounds( 0, 50, 10, 100 );
        assertEquals( a, getTopRightmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getTopRightmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getTopRightmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getTopRightmostComponent_alwaysReturnsRightmost() {
        a.setBounds( 0, 100, 3, 50 );
        b.setBounds( 0, 75, 2, 100 );
        c.setBounds( 0, 50, 1, 100 );
        assertEquals( a, getTopRightmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getTopRightmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getTopRightmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getTopRightmostComponent_returnsTopmostOfEqualRightmost() {
        a.setBounds( 0, 35, 75, 50 );
        b.setBounds( 0, 75, 75, 100 );
        c.setBounds( 0, 150, 75, 100 );
        assertEquals( a, getTopRightmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getTopRightmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getTopRightmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getRightTopmostComponent_failsWithNull() {
        try {
            getRightTopmostComponent( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getRightTopmostComponent_failsWithDuplicateComponentAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        try {
            getRightTopmostComponent( Arrays.<JComponent> asList( a, a ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getRightTopmostComponent_failsWithDuplicateCornerAsResult() {
        a.setBounds( 0, 20, 50, 50 );
        b.setBounds( 10, 20, 40, 100 );
        try {
            getRightTopmostComponent( Arrays.<JComponent> asList( a, b ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getRightTopmostComponent_emptyList() {
        assertEquals( null, getRightTopmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getRightTopmostComponent_single() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getRightTopmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getRightTopmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getRightTopmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getRightTopmostComponent_multiple() {
        a.setBounds( 20, 0, 150, 50 );
        b.setBounds( 20, 25, 75, 100 );
        c.setBounds( 20, 50, 10, 100 );
        assertEquals( a, getRightTopmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getRightTopmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getRightTopmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getRightTopmostComponent_alwaysReturnsTopmost() {
        a.setBounds( 100, 0, 50, 50 );
        b.setBounds( 70, 1, 75, 100 );
        c.setBounds( 35, 2, 75, 100 );
        assertEquals( a, getRightTopmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getRightTopmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getRightTopmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getRightTopmostComponent_returnsRightmostOfEqualTopmost() {
        a.setBounds( 10, 0, 75, 50 );
        b.setBounds( 75, 0, 75, 100 );
        c.setBounds( 150, 0, 75, 100 );
        assertEquals( b, getRightTopmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( c, getRightTopmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( c, getRightTopmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getBottomLeftmostComponent_failsWithNull() {
        try {
            getBottomLeftmostComponent( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getBottomLeftmostComponent_failsWithDuplicateComponentAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        try {
            getBottomLeftmostComponent( Arrays.<JComponent> asList( a, a ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getBottomLeftmostComponent_failsWithDuplicateCornerAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 10, 75, 40 );
        try {
            getBottomLeftmostComponent( Arrays.<JComponent> asList( a, b ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getBottomLeftmostComponent_emptyList() {
        assertEquals( null, getBottomLeftmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getBottomLeftmostComponent_single() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getBottomLeftmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getBottomLeftmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getBottomLeftmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getBottomLeftmostComponent_multiple() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 25, 25, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getBottomLeftmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getBottomLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getBottomLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getBottomLeftmostComponent_alwaysReturnsLeftmost() {
        a.setBounds( 0, 100, 50, 50 );
        b.setBounds( 1, 75, 75, 100 );
        c.setBounds( 2, 50, 75, 100 );
        assertEquals( a, getBottomLeftmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getBottomLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getBottomLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getBottomLeftmostComponent_returnsBottommostOfEqualLeftmost() {
        a.setBounds( 0, 25, 50, 100 );
        b.setBounds( 0, 50, 75, 100 );
        c.setBounds( 0, 100, 75, 100 );
        assertEquals( b, getBottomLeftmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( c, getBottomLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( c, getBottomLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getLeftBottommostComponent_failsWithNull() {
        try {
            getLeftBottommostComponent( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getLeftBottommostComponent_failsWithDuplicateComponentAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        try {
            getLeftBottommostComponent( Arrays.<JComponent> asList( a, a ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getLeftBottommostComponent_failsWithDuplicateCornerAsResult() {
        a.setBounds( 0, 50, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        try {
            getLeftBottommostComponent( Arrays.<JComponent> asList( a, b ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getLeftBottommostComponent_emptyList() {
        assertEquals( null, getLeftBottommostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getLeftBottommostComponent_single() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getLeftBottommostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getLeftBottommostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getLeftBottommostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getLeftBottommostComponent_multiple() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 25, 25, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getLeftBottommostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getLeftBottommostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getLeftBottommostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getLeftBottommostComponent_alwaysReturnsBottommost() {
        a.setBounds( 100, 0, 50, 50 );
        b.setBounds( 70, 1, 75, 100 );
        c.setBounds( 35, 2, 75, 100 );
        assertEquals( a, getLeftBottommostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getLeftBottommostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getLeftBottommostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getLeftBottommostComponent_returnsLeftmostOfEqualBottommost() {
        a.setBounds( 100, 0, 50, 100 );
        b.setBounds( 75, 0, 75, 100 );
        c.setBounds( 50, 0, 75, 100 );
        assertEquals( b, getLeftBottommostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( c, getLeftBottommostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( c, getLeftBottommostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getBottomRightmostComponent_failsWithNull() {
        try {
            getBottomRightmostComponent( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getBottomRightmostComponent_failsWithDuplicateComponentAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        try {
            getBottomRightmostComponent( Arrays.<JComponent> asList( a, a ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getBottomRightmostComponent_failsWithDuplicateCornerAsResult() {
        a.setBounds( 0, 50, 50, 50 );
        b.setBounds( 25, 0, 25, 100 );
        try {
            getBottomRightmostComponent( Arrays.<JComponent> asList( a, b ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getBottomRightmostComponent_emptyList() {
        assertEquals( null, getBottomRightmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getBottomRightmostComponent_single() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getBottomRightmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getBottomRightmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getBottomRightmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getBottomRightmostComponent_multiple() {
        a.setBounds( 0, 0, 30, 50 );
        b.setBounds( 0, 25, 20, 100 );
        c.setBounds( 0, 50, 10, 100 );
        assertEquals( a, getBottomRightmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getBottomRightmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getBottomRightmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getBottomRightmostComponent_alwaysReturnsRightmost() {
        a.setBounds( 0, 0, 3, 50 );
        b.setBounds( 0, 5, 2, 100 );
        c.setBounds( 0, 10, 1, 100 );
        assertEquals( a, getBottomRightmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getBottomRightmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getBottomRightmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getBottomRightmostComponent_returnsBottommostOfEqualRightmost() {
        a.setBounds( 0, 35, 75, 50 );
        b.setBounds( 0, 75, 75, 100 );
        c.setBounds( 0, 150, 75, 100 );
        assertEquals( b, getBottomRightmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( c, getBottomRightmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( c, getBottomRightmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getRightBottommostComponent_failsWithNull() {
        try {
            getRightBottommostComponent( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getRightBottommostComponent_failsWithDuplicateComponentAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        try {
            getRightBottommostComponent( Arrays.<JComponent> asList( a, a ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getRightBottommostComponent_failsWithDuplicateCornerAsResult() {
        a.setBounds( 0, 10, 50, 110 );
        b.setBounds( 10, 20, 40, 100 );
        try {
            getRightBottommostComponent( Arrays.<JComponent> asList( a, b ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getRightBottommostComponent_emptyList() {
        assertEquals( null, getRightBottommostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getRightBottommostComponent_single() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getRightBottommostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getRightBottommostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getRightBottommostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getRightBottommostComponent_multiple() {
        a.setBounds( 20, 0, 150, 50 );
        b.setBounds( 20, 25, 75, 100 );
        c.setBounds( 20, 50, 10, 100 );
        assertEquals( a, getRightBottommostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getRightBottommostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getRightBottommostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getRightBottommostComponent_alwaysReturnsBottommost() {
        a.setBounds( 100, 0, 50, 100 );
        b.setBounds( 70, 1, 75, 100 );
        c.setBounds( 35, 2, 75, 100 );
        assertEquals( a, getRightBottommostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getRightBottommostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getRightBottommostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getRightBottommostComponent_returnsRightmostOfEqualBottommost() {
        a.setBounds( 10, 0, 75, 100 );
        b.setBounds( 75, 0, 75, 100 );
        c.setBounds( 150, 0, 75, 100 );
        assertEquals( b, getRightBottommostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( c, getRightBottommostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( c, getRightBottommostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getLeftmostComponent_failsWithNull() {
        try {
            getLeftmostComponent( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getLeftmostComponent_failsWithDuplicateComponentAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        try {
            getLeftmostComponent( Arrays.<JComponent> asList( a, a ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getLeftmostComponent_failsWithDuplicatePointAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 50, 75, 100 );
        try {
            getLeftmostComponent( Arrays.<JComponent> asList( a, b ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getLeftmostComponent_emptyList() {
        assertEquals( null, getLeftmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getLeftmostComponent_single() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getLeftmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getLeftmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getLeftmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getLeftmostComponent_multiple() {
        a.setBounds( 20, 0, 50, 50 );
        b.setBounds( 30, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getLeftmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getTopmostComponent_failsWithNull() {
        try {
            getTopmostComponent( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getTopmostComponent_failsWithDuplicateComponentAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        try {
            getTopmostComponent( Arrays.<JComponent> asList( a, a ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getTopmostComponent_failsWithDuplicatePointAsResult() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 50, 0, 75, 100 );
        try {
            getTopmostComponent( Arrays.<JComponent> asList( a, b ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getTopmostComponent_emptyList() {
        assertEquals( null, getTopmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getTopmostComponent_single() {
        a.setBounds( 0, 0, 50, 50 );
        b.setBounds( 0, 0, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getTopmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getTopmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getTopmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getTopmostComponent_multiple() {
        a.setBounds( 0, 20, 50, 50 );
        b.setBounds( 0, 40, 75, 100 );
        c.setBounds( 50, 50, 75, 100 );
        assertEquals( a, getTopmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getTopmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getTopmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

}
