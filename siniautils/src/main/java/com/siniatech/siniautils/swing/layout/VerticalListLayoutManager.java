package com.siniatech.siniautils.swing.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class VerticalListLayoutManager implements LayoutManager {

    private final int listItemHeight;

    public VerticalListLayoutManager( int listItemHeight ) {
        this.listItemHeight = listItemHeight;
    }

    @Override
    public void addLayoutComponent( String name, Component comp ) {
    }

    @Override
    public void removeLayoutComponent( Component comp ) {
    }

    @Override
    public Dimension preferredLayoutSize( Container parent ) {
        return new Dimension( 100, listItemHeight * parent.getComponents().length );
    }

    @Override
    public Dimension minimumLayoutSize( Container parent ) {
        return new Dimension( 0, 0 );
    }

    @Override
    public void layoutContainer( Container parent ) {
        int w = parent.getWidth();
        Component[] components = parent.getComponents();
        for ( int i = 0; i < components.length; i++ ) {
            components[i].setBounds( 0, i * listItemHeight, w, listItemHeight );
        }
    }

}
