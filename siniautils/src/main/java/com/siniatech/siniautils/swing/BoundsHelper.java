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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.siniatech.siniautils.collection.CollectionHelper;

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

    /*
     * TODO - these four 'corner' finders could prob do with more thorough
     * testing/speccing
     */
    /**
     * Gets the leftmost component - when more than one chooses the topmost
     */
    static public Component getTopLeftmostComponent( Collection<? extends Component> components ) {
        Component topLeftComponent = null;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( topLeftComponent == null || //
                bounds.getMinX() < topLeftComponent.getBounds().getMinX() || //
                ( bounds.getMinX() == topLeftComponent.getBounds().getMinX() && bounds.getMinY() < topLeftComponent.getBounds().getMinY() ) ) {
                topLeftComponent = component;
            }
        }
        return topLeftComponent;
    }

    /**
     * Gets the topmost component - when more than one chooses the leftmost
     */
    static public Component getLeftTopmostComponent( Collection<? extends Component> components ) {
        Component topLeftComponent = null;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( topLeftComponent == null || //
                bounds.getMinY() < topLeftComponent.getBounds().getMinY() || //
                ( bounds.getMinX() < topLeftComponent.getBounds().getMinX() && bounds.getMinY() == topLeftComponent.getBounds().getMinY() ) ) {
                topLeftComponent = component;
            }
        }
        return topLeftComponent;
    }

    static public Component getTopRightmostComponent( Collection<? extends Component> components ) {
        Component topRightComponent = null;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( topRightComponent == null || ( bounds.getMaxX() >= topRightComponent.getBounds().getMinX() && bounds.getMinY() <= topRightComponent.getBounds().getMinY() ) ) {
                topRightComponent = component;
            }
        }
        return topRightComponent;
    }

    static public Component getBottomLeftmostComponent( Collection<? extends Component> components ) {
        Component bottomLeftComponent = null;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( bottomLeftComponent == null || ( bounds.getMinX() <= bottomLeftComponent.getBounds().getMinX() && bounds.getMaxY() >= bottomLeftComponent.getBounds().getMaxY() ) ) {
                bottomLeftComponent = component;
            }
        }
        return bottomLeftComponent;
    }

    static public Component getBottomRightmostComponent( Collection<? extends Component> components ) {
        Component bottomRightComponent = null;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( bottomRightComponent == null || ( bounds.getMaxX() >= bottomRightComponent.getBounds().getMaxX() && bounds.getMaxY() >= bottomRightComponent.getBounds().getMaxY() ) ) {
                bottomRightComponent = component;
            }
        }
        return bottomRightComponent;
    }

    static public Component getLeftmostComponent( Collection<? extends Component> components ) {
        Component leftmostComponent = null;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( leftmostComponent == null || bounds.x < leftmostComponent.getBounds().x ) {
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
    static public <T extends Component> Collection<T> getComponentsWithOriginIn( Collection<T> components, Rectangle bounds ) {
        List<T> componentsOriginInBounds = new ArrayList<>();
        for ( T component : components ) {
            if ( bounds.contains( component.getLocation() ) ) {
                componentsOriginInBounds.add( component );
            }
        }
        return componentsOriginInBounds;
    }

    static public <T extends Component> Collection<T> getComponentsThatIntersect( Collection<T> components, Rectangle bounds ) {
        List<T> componentsInBounds = new ArrayList<>();
        for ( T component : components ) {
            if ( bounds.intersects( component.getBounds() ) ) {
                componentsInBounds.add( component );
            }
        }
        return componentsInBounds;
    }

    static public <T extends Component> Collection<T> getComponentsContaining( Collection<T> components, Point point ) {
        List<T> componentsContaining = new ArrayList<>();
        for ( T component : components ) {
            if ( component.getBounds().contains( point ) ) {
                componentsContaining.add( component );
            }
        }
        return componentsContaining;
    }

    /**
     * Returns the components that intersect the horizontal line at y
     */
    static public <T extends Component> Collection<T> getComponentsCrossingY( Collection<T> components, int y ) {
        List<T> componentsCrossing = new ArrayList<>();
        for ( T component : components ) {
            Rectangle bounds = component.getBounds();
            if ( bounds.y <= y && ( bounds.y + bounds.height ) > y ) {
                componentsCrossing.add( component );
            }
        }
        return componentsCrossing;
    }

    /**
     * Returns the components that intersect the vertical line at x
     */
    static public <T extends Component> Collection<T> getComponentsCrossingX( Collection<T> components, int x ) {
        List<T> componentsCrossing = new ArrayList<>();
        for ( T component : components ) {
            Rectangle bounds = component.getBounds();
            if ( bounds.x <= x && ( bounds.x + bounds.width ) > x ) {
                componentsCrossing.add( component );
            }
        }
        return componentsCrossing;
    }

    static public <T extends Component> T getComponentContaining( Collection<T> components, Point point ) {
        Collection<T> componentsContaining = getComponentsContaining( components, point );
        if ( componentsContaining.size() > 1 ) {
            throw new IllegalStateException( "Only one component expected at " + point );
        }
        return componentsContaining.size() == 0 ? null : CollectionHelper.getArbitraryMember( componentsContaining );
    }

    static public boolean alignsVertically( Rectangle r1, Rectangle r2 ) {
        return r1.getMaxX() == r2.getMaxX() && r1.getMinX() == r2.getMinX();
    }

    static public boolean alignsHorizontally( Rectangle r1, Rectangle r2 ) {
        return r1.getMaxY() == r2.getMaxY() && r1.getMinY() == r2.getMinY();
    }

    // need a getComponentsWhollyIn at some point
}
