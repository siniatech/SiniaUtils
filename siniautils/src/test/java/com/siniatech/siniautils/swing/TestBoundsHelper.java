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

    static final private JComponent a = new JLabel( "a" );
    static final private JComponent b = new JLabel( "b" );
    static final private JComponent c = new JLabel( "c" );

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
    public void getComponentsOriginIn_failsWithNull_p1() {
        try {
            getComponentsWithOriginIn( null, new Rectangle( 0, 0, 100, 100 ) );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsOriginIn_failsWithNull_p2() {
        try {
            getComponentsWithOriginIn( Arrays.<JComponent> asList( a ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getComponentsOriginIn_emptyList() {
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList(), new Rectangle( 0, 0, 100, 100 ) ) );
    }

    @Test
    public void getComponentsOriginIn_single() {
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsWithOriginIn( Arrays.<JComponent> asList( a ), new Rectangle( 0, 0, 100, 200 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList( b ), new Rectangle( 0, 0, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList( c ), new Rectangle( 0, 0, 100, 100 ) ) );
    }

    @Test
    public void getComponentsOriginIn_multiple() {
        assertEquals( Arrays.<JComponent> asList( a, b ), getComponentsWithOriginIn( Arrays.<JComponent> asList( a, b ), new Rectangle( 0, 0, 200, 200 ) ) );
        assertEquals( Arrays.<JComponent> asList( b ), getComponentsWithOriginIn( Arrays.<JComponent> asList( b, c ), new Rectangle( 0, 0, 200, 200 ) ) );
        assertEquals( Arrays.<JComponent> asList( c ), getComponentsWithOriginIn( Arrays.<JComponent> asList( c, b, a ), new Rectangle( 0, 300, 100, 300 ) ) );
    }

    @Test
    public void getComponentsOriginIn_boundaries() {
                                                        a.setBounds( 50, 100, 500, 300 );
                                                        b.setBounds( 100, 105, 400, 595 );
                                                        c.setBounds( 0, 500, 200, 200 );
        assertEquals( Arrays.<JComponent> asList( a ), getComponentsWithOriginIn( Arrays.<JComponent> asList( a ), new Rectangle( 50, 100, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList( b ), getComponentsWithOriginIn( Arrays.<JComponent> asList( b ), new Rectangle( 99, 104, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList( c ), new Rectangle( 1, 501, 100, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList( ), getComponentsWithOriginIn( Arrays.<JComponent> asList( a ), new Rectangle( 0, 0, 50, 100 ) ) );
        assertEquals( Arrays.<JComponent> asList( b ), getComponentsWithOriginIn( Arrays.<JComponent> asList( b ), new Rectangle( 50, 55, 51, 51 ) ) );
        assertEquals( Arrays.<JComponent> asList(), getComponentsWithOriginIn( Arrays.<JComponent> asList( c ), new Rectangle( 0, 0, 50, 499 ) ) );
    }

    @Test
    public void compShouldContainPointAtBounds() {
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
}
