package com.siniatech.siniautils.swing;

import static com.siniatech.siniautils.swing.BoundsHelper.*;
import static junit.framework.Assert.*;

import java.awt.Dimension;
import java.awt.Point;
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
        b.setBounds( 100, 100, 400, 600 );
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
