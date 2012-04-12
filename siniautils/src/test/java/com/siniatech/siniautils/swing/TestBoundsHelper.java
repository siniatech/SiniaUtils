package com.siniatech.siniautils.swing;

import static junit.framework.Assert.*;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import org.junit.Test;

public class TestBoundsHelper {

    @Test
    public void compShouldContainPointAtBounds() {
        JPanel panel = new JPanel();
        panel.setBounds( 20, 30, 40, 50 );
        List<JPanel> components = Arrays.asList( panel );
        assertEquals( 0, BoundsHelper.getComponentsContaining( components, new Point( 19, 35 ) ).size() );
        assertEquals( 1, BoundsHelper.getComponentsContaining( components, new Point( 20, 35 ) ).size() );
        assertEquals( 1, BoundsHelper.getComponentsContaining( components, new Point( 59, 35 ) ).size() );
        assertEquals( 0, BoundsHelper.getComponentsContaining( components, new Point( 60, 35 ) ).size() );
        assertEquals( 0, BoundsHelper.getComponentsContaining( components, new Point( 25, 29 ) ).size() );
        assertEquals( 1, BoundsHelper.getComponentsContaining( components, new Point( 25, 30 ) ).size() );
        assertEquals( 1, BoundsHelper.getComponentsContaining( components, new Point( 25, 79 ) ).size() );
        assertEquals( 0, BoundsHelper.getComponentsContaining( components, new Point( 25, 80 ) ).size() );
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
        assertEquals( 0, BoundsHelper.getComponentsContaining( components, new Point( maxX, maxY ) ).size() );
    }
}
