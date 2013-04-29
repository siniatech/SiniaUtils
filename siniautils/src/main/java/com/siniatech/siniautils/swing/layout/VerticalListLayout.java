package com.siniatech.siniautils.swing.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.border.Border;

public class VerticalListLayout implements LayoutManager {

    private static final Insets EMPTY_INSETS = new Insets( 0, 0, 0, 0 );
    private final int vGap;

    public VerticalListLayout() {
        this(0);
    }
    public VerticalListLayout(int vGap) {
        this.vGap = vGap;
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
        int w = parent.getWidth();
        Component[] components = parent.getComponents();
        int h = borderInsets.top + borderInsets.bottom;
        for ( int i = 0; i < components.length; i++ ) {
            Dimension preferredSize = components[i].getPreferredSize();
            w = preferredSize.width > w ? preferredSize.width : w;
            h += preferredSize.height + vGap;
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
        int w = preferredLayoutSize( parent ).width - x - borderInsets.right;
        int y = borderInsets.top;
        Component[] components = parent.getComponents();
        for ( int i = 0; i < components.length; i++ ) {
            Component component = components[i];
            int h = component.getPreferredSize().height;
            component.setBounds( x, y, w, h );
            y += h;
            y += vGap;
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
