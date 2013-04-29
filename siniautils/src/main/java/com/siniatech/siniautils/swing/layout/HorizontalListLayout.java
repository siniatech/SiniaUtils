package com.siniatech.siniautils.swing.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.border.Border;

public class HorizontalListLayout implements LayoutManager {

    private static final Insets EMPTY_INSETS = new Insets( 0, 0, 0, 0 );
    private final int hGap;

    public HorizontalListLayout() {
        this( 0 );
    }

    public HorizontalListLayout( int hGap ) {
        this.hGap = hGap;
    }

    @Override
    public void addLayoutComponent( String name, Component comp ) {
    }

    @Override
    public void removeLayoutComponent( Component comp ) {
    }

    @Override
    public Dimension preferredLayoutSize( Container parent ) {
        Insets borderInsets = getBorderInsets( parent );
        int h = parent.getHeight();
        Component[] components = parent.getComponents();
        int w = borderInsets.left + borderInsets.right;
        for ( int i = 0; i < components.length; i++ ) {
            Dimension preferredSize = components[i].getPreferredSize();
            h = preferredSize.height > h ? preferredSize.height : h;
            w += preferredSize.width + hGap;
        }
        return new Dimension( w, h );
    }

    @Override
    public Dimension minimumLayoutSize( Container parent ) {
        return preferredLayoutSize( parent );
    }

    @Override
    public void layoutContainer( Container parent ) {
        Insets borderInsets = getBorderInsets( parent );
        int x = borderInsets.left;
        int y = borderInsets.top;
        int h = preferredLayoutSize( parent ).height - y - borderInsets.bottom;
        Component[] components = parent.getComponents();
        for ( int i = 0; i < components.length; i++ ) {
            Component component = components[i];
            int w = component.getPreferredSize().width;
            component.setBounds( x, y, w, h );
            x += w;
            x += hGap;
        }
    }

    private Insets getBorderInsets( Component component ) {
        if ( component instanceof JComponent ) {
            Border border = ( (JComponent) component ).getBorder();
            if ( border != null ) {
                return border.getBorderInsets( component );
            }
        }
        return EMPTY_INSETS;
    }

}
