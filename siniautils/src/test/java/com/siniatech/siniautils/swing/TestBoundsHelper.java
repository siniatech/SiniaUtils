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

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestBoundsHelper {

    static class TestLabel extends JLabel {
        private final String s;

        public TestLabel( String s ) {
            this.s = s;
        }

        @Override
        public String toString() {
            return s;
        }
    }

    static final private JComponent a = new TestLabel( "a" );
    static final private JComponent b = new TestLabel( "b" );
    static final private JComponent c = new TestLabel( "c" );

    @BeforeClass
    static public void setBounds() {
        a.setBounds( 50, 100, 500, 300 );
        b.setBounds( 100, 105, 400, 595 );
        c.setBounds( 0, 500, 200, 200 );
    }

    @Test
    public void getExtentOfComponents_failsWithNull() {
        try {
            getExtentOfComponents( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getExtentOfComponents_emptyList() {
        assertEquals( new Dimension( 0, 0 ), getExtentOfComponents( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getExtentOfComponents_single() {
        assertEquals( new Dimension( 550, 400 ), getExtentOfComponents( Arrays.<JComponent> asList( a ) ) );
        assertEquals( new Dimension( 500, 700 ), getExtentOfComponents( Arrays.<JComponent> asList( b ) ) );
        assertEquals( new Dimension( 200, 700 ), getExtentOfComponents( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getExtentOfComponents_multiple() {
        assertEquals( new Dimension( 550, 700 ), getExtentOfComponents( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( new Dimension( 500, 700 ), getExtentOfComponents( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( new Dimension( 550, 700 ), getExtentOfComponents( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getXExtentOfComponents_failsWithNull() {
        try {
            getXExtentOfComponents( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getXExtentOfComponents_emptyList() {
        assertEquals( 0, getXExtentOfComponents( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getXExtentOfComponents_single() {
        assertEquals( 550, getXExtentOfComponents( Arrays.<JComponent> asList( a ) ) );
        assertEquals( 500, getXExtentOfComponents( Arrays.<JComponent> asList( b ) ) );
        assertEquals( 200, getXExtentOfComponents( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getXExtentOfComponents_multiple() {
        assertEquals( 550, getXExtentOfComponents( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( 500, getXExtentOfComponents( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( 550, getXExtentOfComponents( Arrays.<JComponent> asList( a, b, c ) ) );
    }

    @Test
    public void getYExtentOfComponents_failsWithNull() {
        try {
            getYExtentOfComponents( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getYExtentOfComponents_emptyList() {
        assertEquals( 0, getYExtentOfComponents( Arrays.<JComponent> asList() ) );
    }

    @Test
    public void getYExtentOfComponents_single() {
        assertEquals( 400, getYExtentOfComponents( Arrays.<JComponent> asList( a ) ) );
        assertEquals( 700, getYExtentOfComponents( Arrays.<JComponent> asList( b ) ) );
        assertEquals( 700, getYExtentOfComponents( Arrays.<JComponent> asList( c ) ) );
    }

    @Test
    public void getYExtentOfComponents_multiple() {
        assertEquals( 700, getYExtentOfComponents( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( 700, getYExtentOfComponents( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( 700, getYExtentOfComponents( Arrays.<JComponent> asList( a, b, c ) ) );
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
        assertEquals( b, getTopLeftmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( a, getTopLeftmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
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
        assertEquals( b, getBottomRightmostComponent( Arrays.<JComponent> asList( a, b ) ) );
        assertEquals( b, getBottomRightmostComponent( Arrays.<JComponent> asList( b, c ) ) );
        assertEquals( b, getBottomRightmostComponent( Arrays.<JComponent> asList( a, b, c ) ) );
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

    @Test
    public void getComponentsWithOriginIn_failsWithNull_p1() {
        try {
            getComponentsWithOriginIn( null, new Rectangle( 0, 0, 100, 100 ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsWithOriginIn_failsWithNull_p2() {
        try {
            getComponentsWithOriginIn( Arrays.<JComponent> asList( a ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsWithOriginIn_emptyList() {
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList(), new Rectangle( 0, 0, 100, 100 ) ) );
    }

    @Test
    public void getComponentsWithOriginIn_single() {
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsWithOriginIn( Arrays.<JComponent> asList( a ), new Rectangle( 0, 0, 100, 200 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList( b ), new Rectangle( 0, 0, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList( c ), new Rectangle( 0, 0, 100, 100 ) ) );
    }

    @Test
    public void getComponentsWithOriginIn_multiple() {
        assertEquals( Arrays.<JComponent> asList( a, b ), getComponentsWithOriginIn( Arrays.<JComponent> asList( a, b ), new Rectangle( 0, 0, 200, 200 ) ) );
        assertEquals( Arrays.<JComponent> asList( b ), getComponentsWithOriginIn( Arrays.<JComponent> asList( b, c ), new Rectangle( 0, 0, 200, 200 ) ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsWithOriginIn( Arrays.<JComponent> asList( c, b, a ), new Rectangle( 0, 300, 100, 300 ) ) );
    }

    @Test
    public void getComponentsWithOriginIn_boundaries() {
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsWithOriginIn( Arrays.<JComponent> asList( a ), new Rectangle( 50, 100, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList( b ), getComponentsWithOriginIn( Arrays.<JComponent> asList( b ), new Rectangle( 99, 104, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList( c ), new Rectangle( 1, 501, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList( a ), new Rectangle( 0, 0, 50, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList( b ), getComponentsWithOriginIn( Arrays.<JComponent> asList( b ), new Rectangle( 50, 55, 51, 51 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList( c ), new Rectangle( 0, 0, 50, 499 ) ) );
    }

    @Test
    public void getComponentsThatIntersect_failsWithNull_p1() {
        try {
            getComponentsThatIntersect( null, new Rectangle( 0, 0, 100, 100 ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsThatIntersect_failsWithNull_p2() {
        try {
            getComponentsThatIntersect( Arrays.<JComponent> asList( a ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsThatIntersect_emptyList() {
        assertEquals( Arrays.<JComponent> asList(), getComponentsThatIntersect( Arrays.<JComponent> asList(), new Rectangle( 0, 0, 100, 100 ) ) );
    }

    @Test
    public void getComponentsThatIntersect_single() {
        assertEquals( Arrays.<JComponent> asList(), getComponentsThatIntersect( Arrays.<JComponent> asList( a ), new Rectangle( 0, 0, 50, 50 ) ) );
        assertEquals( Arrays.<JComponent> asList( b ), getComponentsThatIntersect( Arrays.<JComponent> asList( b ), new Rectangle( 300, 100, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsThatIntersect( Arrays.<JComponent> asList( c ), new Rectangle( 150, 400, 100, 200 ) ) );
    }

    @Test
    public void getComponentsThatIntersect_multiple() {
        assertEquals( Arrays.<JComponent> asList( a, b ), getComponentsThatIntersect( Arrays.<JComponent> asList( a, b ), new Rectangle( 0, 0, 200, 200 ) ) );
        assertEquals( Arrays.<JComponent> asList( b ), getComponentsThatIntersect( Arrays.<JComponent> asList( b, c ), new Rectangle( 0, 0, 200, 200 ) ) );
        assertEquals( Arrays.<JComponent> asList( c, a ), getComponentsThatIntersect( Arrays.<JComponent> asList( c, b, a ), new Rectangle( 0, 300, 100, 250 ) ) );
    }

    @Test
    public void getComponentsThatIntersect_nw() {
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsThatIntersect( Arrays.<JComponent> asList( a ), new Rectangle( 0, 0, 51, 101 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsThatIntersect( Arrays.<JComponent> asList( b ), new Rectangle( 0, 0, 100, 105 ) ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsThatIntersect( Arrays.<JComponent> asList( c ), new Rectangle( 0, 0, 50, 700 ) ) );
    }

    @Test
    public void getComponentsThatIntersect_ne() {
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsThatIntersect( Arrays.<JComponent> asList( a ), new Rectangle( 549, 0, 50, 101 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsThatIntersect( Arrays.<JComponent> asList( b ), new Rectangle( 500, 0, 100, 105 ) ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsThatIntersect( Arrays.<JComponent> asList( c ), new Rectangle( 150, 550, 100, 100 ) ) );
    }

    @Test
    public void getComponentsThatIntersect_sw() {
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsThatIntersect( Arrays.<JComponent> asList( a ), new Rectangle( 0, 399, 51, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsThatIntersect( Arrays.<JComponent> asList( b ), new Rectangle( 0, 700, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsThatIntersect( Arrays.<JComponent> asList( c ), new Rectangle( 0, 650, 150, 100 ) ) );
    }

    @Test
    public void getComponentsThatIntersect_se() {
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsThatIntersect( Arrays.<JComponent> asList( a ), new Rectangle( 549, 100, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsThatIntersect( Arrays.<JComponent> asList( b ), new Rectangle( 500, 104, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsThatIntersect( Arrays.<JComponent> asList( c ), new Rectangle( 150, 501, 100, 100 ) ) );
    }

    @Test
    public void getComponentsContaining_failsWithNull_p1() {
        try {
            getComponentsContaining( null, new Point( 0, 0 ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsContaining_failsWithNull_p2() {
        try {
            getComponentsContaining( Arrays.<JComponent> asList( a ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsContaining_emptyList() {
        assertEquals( Arrays.<JComponent> asList(), getComponentsContaining( Arrays.<JComponent> asList(), new Point( 0, 0 ) ) );
    }

    @Test
    public void getComponentsContaining_single() {
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsContaining( Arrays.<JComponent> asList( a ), new Point( 50, 105 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsContaining( Arrays.<JComponent> asList( b ), new Point( 90, 90 ) ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsContaining( Arrays.<JComponent> asList( c ), new Point( 50, 505 ) ) );
    }

    @Test
    public void getComponentsContaining_multiple() {
        assertEquals( Arrays.<JComponent> asList( a, b ), getComponentsContaining( Arrays.<JComponent> asList( a, b ), new Point( 110, 110 ) ) );
        assertEquals( Arrays.<JComponent> asList( b ), getComponentsContaining( Arrays.<JComponent> asList( b, c ), new Point( 100, 110 ) ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsContaining( Arrays.<JComponent> asList( c, b, a ), new Point( 0, 600 ) ) );
    }

    @Test
    public void getComponentaContaining_pointAtBounds() {
        JPanel panel = new JPanel();
        panel.setBounds( 20, 30, 40, 50 );
        List<JPanel> components = Arrays.asList( panel );
        assertEquals( 0, getComponentsContaining( components, new Point( 19, 35 ) ).size() );
        assertEquals( 1, getComponentsContaining( components, new Point( 20, 35 ) ).size() );
        assertEquals( 1, getComponentsContaining( components, new Point( 59, 35 ) ).size() );
        assertEquals( 0, getComponentsContaining( components, new Point( 60, 35 ) ).size() );
        assertEquals( 0, getComponentsContaining( components, new Point( 25, 29 ) ).size() );
        assertEquals( 1, getComponentsContaining( components, new Point( 25, 30 ) ).size() );
        assertEquals( 1, getComponentsContaining( components, new Point( 25, 79 ) ).size() );
        assertEquals( 0, getComponentsContaining( components, new Point( 25, 80 ) ).size() );
    }

    @Test
    public void confirmThatMaxXMaxYOnRectangleAreUseless() {
        JPanel panel = new JPanel();
        panel.setBounds( 20, 30, 40, 50 );
        List<JPanel> components = Arrays.asList( panel );
        int maxX = (int) panel.getBounds().getMaxX();
        int maxY = (int) panel.getBounds().getMaxY();
        // Madness! How can the bounds not contain the point you've just told me is the maximum x/y? 
        assertFalse( panel.getBounds().contains( new Point( maxX, maxY ) ) );
        assertEquals( 0, getComponentsContaining( components, new Point( maxX, maxY ) ).size() );
    }

    @Test
    public void getComponentsCrossingX_failsWithNull_p1() {
        try {
            getComponentsCrossingX( null, 0 );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsCrossingX_failsWithNull_p2() {
        try {
            getComponentsCrossingX( Arrays.<JComponent> asList( a ), new Integer( null ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsCrossingX_emptyList() {
        assertEquals( Arrays.<JComponent> asList(), getComponentsCrossingX( Arrays.<JComponent> asList(), 0 ) );
    }

    @Test
    public void getComponentsCrossingX_single() {
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsCrossingX( Arrays.<JComponent> asList( a ), 50 ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsCrossingX( Arrays.<JComponent> asList( b ), 90 ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsCrossingX( Arrays.<JComponent> asList( c ), 50 ) );
    }

    @Test
    public void getComponentsCrossingX_multiple() {
        assertEquals( Arrays.<JComponent> asList( a, b ), getComponentsCrossingX( Arrays.<JComponent> asList( a, b ), 110 ) );
        assertEquals( Arrays.<JComponent> asList( b, c ), getComponentsCrossingX( Arrays.<JComponent> asList( b, c ), 100 ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsCrossingX( Arrays.<JComponent> asList( c, b, a ), 0 ) );
    }

    @Test
    public void getComponentsCrossingY_failsWithNull_p1() {
        try {
            getComponentsCrossingY( null, 0 );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsCrossingY_failsWithNull_p2() {
        try {
            getComponentsCrossingY( Arrays.<JComponent> asList( a ), new Integer( null ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsCrossingY_emptyList() {
        assertEquals( Arrays.<JComponent> asList(), getComponentsCrossingY( Arrays.<JComponent> asList(), 0 ) );
    }

    @Test
    public void getComponentsCrossingY_single() {
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsCrossingY( Arrays.<JComponent> asList( a ), 105 ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsCrossingY( Arrays.<JComponent> asList( b ), 90 ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsCrossingY( Arrays.<JComponent> asList( c ), 505 ) );
    }

    @Test
    public void getComponentsCrossingY_multiple() {
        assertEquals( Arrays.<JComponent> asList( a, b ), getComponentsCrossingY( Arrays.<JComponent> asList( a, b ), 110 ) );
        assertEquals( Arrays.<JComponent> asList( b ), getComponentsCrossingY( Arrays.<JComponent> asList( b, c ), 110 ) );
        assertEquals( Arrays.<JComponent> asList( c, b ), getComponentsCrossingY( Arrays.<JComponent> asList( c, b, a ), 600 ) );
    }

    @Test
    public void getComponentContaining_failsWithNull_p1() {
        try {
            getComponentContaining( null, new Point( 0, 0 ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentContaining_failsWithNull_p2() {
        try {
            getComponentContaining( Arrays.<JComponent> asList( a ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentContaining_emptyList() {
        assertEquals( null, getComponentContaining( Arrays.<JComponent> asList(), new Point( 0, 0 ) ) );
    }

    @Test
    public void getComponentContaining_single() {
        assertEquals( a, getComponentContaining( Arrays.<JComponent> asList( a ), new Point( 50, 105 ) ) );
        assertEquals( null, getComponentContaining( Arrays.<JComponent> asList( b ), new Point( 90, 90 ) ) );
        assertEquals( c, getComponentContaining( Arrays.<JComponent> asList( c ), new Point( 50, 505 ) ) );
    }

    @Test
    public void getComponentContaining_multiple() {
        try {
            getComponentContaining( Arrays.<JComponent> asList( a, b ), new Point( 110, 110 ) );
            fail();
        } catch ( Exception e ) {
        }
        assertEquals( b, getComponentContaining( Arrays.<JComponent> asList( b, c ), new Point( 100, 110 ) ) );
        assertEquals( c, getComponentContaining( Arrays.<JComponent> asList( c, b, a ), new Point( 0, 600 ) ) );
    }

    @Test
    public void alignsVertically_failsWithNull_p1() {
        try {
            alignsVertically( null, new Rectangle( 100, 100 ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void alignsVertically_failsWithNull_p2() {
        try {
            alignsVertically( new Rectangle( 100, 100 ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void alignsVertically_aligns() {
        assertTrue( alignsVertically( new Rectangle( 0, 0, 100, 100 ), new Rectangle( 0, 0, 100, 100 ) ) );
        assertTrue( alignsVertically( new Rectangle( 0, 500, 100, 100 ), new Rectangle( 0, 0, 100, 300 ) ) );
        assertFalse( alignsVertically( new Rectangle( 500, 0, 100, 100 ), new Rectangle( 0, 0, 300, 100 ) ) );
        assertFalse( alignsVertically( new Rectangle( 0, 0, 100, 100 ), new Rectangle( 0, 0, 99, 100 ) ) );
        assertFalse( alignsVertically( new Rectangle( 1, 0, 100, 100 ), new Rectangle( 0, 0, 100, 100 ) ) );
    }

    @Test
    public void alignsHorizontally_failsWithNull_p1() {
        try {
            alignsHorizontally( null, new Rectangle( 100, 100 ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void alignsHorizontally_failsWithNull_p2() {
        try {
            alignsHorizontally( new Rectangle( 100, 100 ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void alignsHorizontally_aligns() {
        assertTrue( alignsHorizontally( new Rectangle( 0, 0, 100, 100 ), new Rectangle( 0, 0, 100, 100 ) ) );
        assertTrue( alignsHorizontally( new Rectangle( 500, 0, 100, 100 ), new Rectangle( 0, 0, 300, 100 ) ) );
        assertFalse( alignsHorizontally( new Rectangle( 0, 500, 100, 100 ), new Rectangle( 0, 0, 100, 300 ) ) );
        assertFalse( alignsHorizontally( new Rectangle( 0, 0, 100, 100 ), new Rectangle( 0, 0, 100, 99 ) ) );
        assertFalse( alignsHorizontally( new Rectangle( 0, 1, 100, 100 ), new Rectangle( 0, 0, 100, 100 ) ) );
    }

}
