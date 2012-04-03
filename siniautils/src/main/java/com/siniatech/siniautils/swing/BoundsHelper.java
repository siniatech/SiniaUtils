package com.siniatech.siniautils.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BoundsHelper {

    static public Dimension getExtentOfComponents( Collection<? extends Component> components ) {
        int maxX = 0, maxY = 0;
        for ( Component comp : components ) {
            Rectangle bounds = comp.getBounds();
            maxX = ( bounds.x + bounds.width ) > maxX ? bounds.x + bounds.width : maxX;
            maxY = ( bounds.y + bounds.height ) > maxY ? bounds.y + bounds.height : maxY;
        }
        return new Dimension( maxX, maxY );
    }
    
    static public int getXExtentOfComponents( Collection<? extends Component> components ) {
        int maxX = 0;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            int xExtent = bounds.width + bounds.x;
            maxX = xExtent > maxX ? xExtent : maxX;
        }
        return maxX;
    }

    static public int getYExtentOfComponents( Collection<? extends Component> components ) {
        int maxY = 0;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            int yExtent = bounds.height + bounds.y;
            maxY = yExtent > maxY ? yExtent : maxY;
        }
        return maxY;
    }

    static public Component getTopLeftmostComponent( Collection<? extends Component> components ) {
        Component topLeftComponent = null;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( topLeftComponent == null || ( bounds.x <= topLeftComponent.getBounds().x && bounds.y <= topLeftComponent.getBounds().y ) ) {
                topLeftComponent = component;
            }
        }
        return topLeftComponent;
    }

    static public Component getLeftmostComponent( Collection<? extends Component> components ) {
        Component leftmostComponent = null;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( leftmostComponent == null || bounds.x <= leftmostComponent.getBounds().x ) {
                leftmostComponent = component;
            }
        }
        return leftmostComponent;
    }

    static public Component getTopmostComponent( Collection<? extends Component> components ) {
        Component topmostComponent = null;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( topmostComponent == null || bounds.y <= topmostComponent.getBounds().y ) {
                topmostComponent = component;
            }
        }
        return topmostComponent;
    }

    /**
     * Returns components whose origin is in bounds.
     */
    static public Collection<? extends Component> getComponentsIn( Collection<? extends Component> components, Rectangle bounds ) {
        List<Component> componentsInBounds = new ArrayList<Component>();
        for ( Component component : components ) {
            if ( bounds.contains( component.getLocation() ) ) {
                componentsInBounds.add( component );
            }
        }
        return componentsInBounds;
    }

    // need a getComponentsWhollyIn at some point
}
