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

import org.junit.BeforeClass;
import org.junit.Test;

import com.siniatech.siniautils.test.fixtures.DummyLabel;

public class TestBoundsHelper_XMostComponent {

    static final private JComponent a = new DummyLabel( "a" );
    static final private JComponent b = new DummyLabel( "b" );
    static final private JComponent c = new DummyLabel( "c" );

    @BeforeClass
    static public void setBounds() {
        a.setBounds( 50, 100, 500, 300 );
        b.setBounds( 100, 105, 400, 595 );
        c.setBounds( 0, 500, 200, 200 );
    }

    @Test
    public void getTopLeftmostComponent_failsWithNull() {
        try {
            getTopLeftmostComponent( null );
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
        assertEquals( a, getTopLeftmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getTopLeftmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getTopLeftmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getTopLeftmostComponent_multiple() {
        assertEquals( a, getTopLeftmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( c, getTopLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( c, getTopLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
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
    public void getTopRightmostComponent_emptyList() {
        assertEquals( null, getTopRightmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getTopRightmostComponent_single() {
        assertEquals( a, getTopRightmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getTopRightmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getTopRightmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getTopRightmostComponent_multiple() {
        assertEquals( a, getTopRightmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getTopRightmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getTopRightmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
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
    public void getBottomLeftmostComponent_emptyList() {
        assertEquals( null, getBottomLeftmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getBottomLeftmostComponent_single() {
        assertEquals( a, getBottomLeftmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getBottomLeftmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getBottomLeftmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getBottomLeftmostComponent_multiple() {
        assertEquals( a, getBottomLeftmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( c, getBottomLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( c, getBottomLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
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
    public void getBottomRightmostComponent_emptyList() {
        assertEquals( null, getBottomRightmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getBottomRightmostComponent_single() {
        assertEquals( a, getBottomRightmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getBottomRightmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getBottomRightmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getBottomRightmostComponent_multiple() {
        assertEquals( a, getBottomRightmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getBottomRightmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getBottomRightmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
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
    public void getLeftmostComponent_emptyList() {
        assertEquals( null, getLeftmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getLeftmostComponent_single() {
        assertEquals( a, getLeftmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getLeftmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getLeftmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getLeftmostComponent_multiple() {
        assertEquals( a, getLeftmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( c, getLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( c, getLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
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
    public void getTopmostComponent_emptyList() {
        assertEquals( null, getTopmostComponent( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getTopmostComponent_single() {
        assertEquals( a, getTopmostComponent( Arrays.<JComponent> asList( a ) ) );
        assertEquals( b, getTopmostComponent( Arrays.<JComponent> asList( b ) ) );
        assertEquals( c, getTopmostComponent( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getTopmostComponent_multiple() {
        assertEquals( a, getTopmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getTopmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getTopmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
    }

}
