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

    private static boolean hasSameTop( Component comp, Rectangle bounds ) {
        return comp != null && bounds.getMinY() == comp.getBounds().getMinY();
    }

    private static boolean hasSameLeft( Component comp, Rectangle bounds ) {
        return comp != null && bounds.getMinX() == comp.getBounds().getMinX();
    }

    private static boolean hasSameRight( Component comp, Rectangle bounds ) {
        return comp != null && bounds.getMaxX() == comp.getBounds().getMaxX();
    }

    private static boolean hasSameBottom( Component comp, Rectangle bounds ) {
        return comp != null && bounds.getMaxY() == comp.getBounds().getMaxY();
    }

    private static boolean hasSameTopLeft( Component comp, Rectangle bounds ) {
        return comp != null && hasSameLeft( comp, bounds ) && hasSameTop( comp, bounds );
    }

    private static boolean hasSameTopRight( Component comp, Rectangle bounds ) {
        return comp != null && hasSameRight( comp, bounds ) && hasSameTop( comp, bounds );
    }

    private static boolean hasSameBottomLeft( Component comp, Rectangle bounds ) {
        return comp != null && hasSameLeft( comp, bounds ) && hasSameBottom( comp, bounds );
    }

    private static boolean hasSameBottomRight( Component comp, Rectangle bounds ) {
        return comp != null && hasSameRight( comp, bounds ) && hasSameBottom( comp, bounds );
    }

    /**
     * Gets the leftmost component - when more than one chooses the topmost
     */
    static public Component getTopLeftmostComponent( Collection<? extends Component> components ) {
        Component topLeftComponent = null;
        boolean haveMoreThanOneResult = false;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( topLeftComponent == null || //
                bounds.getMinX() < topLeftComponent.getBounds().getMinX() || //
                ( hasSameLeft( topLeftComponent, bounds ) && bounds.getMinY() <= topLeftComponent.getBounds().getMinY() ) ) {
                haveMoreThanOneResult = hasSameTopLeft( topLeftComponent, bounds );
                topLeftComponent = component;
            }
        }
        if ( haveMoreThanOneResult ) {
            throw new IllegalArgumentException( "More than one valid result found" + components );
        }
        return topLeftComponent;
    }

    /**
     * Gets the topmost component - when more than one chooses the leftmost
     */
    static public Component getLeftTopmostComponent( Collection<? extends Component> components ) {
        Component topLeftComponent = null;
        boolean haveMoreThanOneResult = false;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( topLeftComponent == null || //
                bounds.getMinY() < topLeftComponent.getBounds().getMinY() || //
                ( bounds.getMinX() <= topLeftComponent.getBounds().getMinX() && hasSameTop( topLeftComponent, bounds ) ) ) {
                haveMoreThanOneResult = hasSameTopLeft( topLeftComponent, bounds );
                topLeftComponent = component;
            }
            if ( haveMoreThanOneResult ) {
                throw new IllegalArgumentException( "More than one valid result found" );
            }
        }
        return topLeftComponent;
    }

    /**
     * Gets the rightmost component - when more than one chooses the topmost
     */
    static public Component getTopRightmostComponent( Collection<? extends Component> components ) {
        Component topRightComponent = null;
        boolean haveMoreThanOneResult = false;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( topRightComponent == null || //
                bounds.getMaxX() > topRightComponent.getBounds().getMaxX() || //
                ( hasSameRight( topRightComponent, bounds ) && bounds.getMinY() <= topRightComponent.getBounds().getMinY() ) ) {
                haveMoreThanOneResult = hasSameTopRight( topRightComponent, bounds );
                topRightComponent = component;
            }
        }
        if ( haveMoreThanOneResult ) {
            throw new IllegalArgumentException( "More than one valid result found" );
        }
        return topRightComponent;
    }

    /**
     * Gets the topmost component - when more than one chooses the rightmost
     */
    static public Component getRightTopmostComponent( Collection<? extends Component> components ) {
        Component topRightComponent = null;
        boolean haveMoreThanOneResult = false;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( topRightComponent == null || //
                bounds.getMinY() < topRightComponent.getBounds().getMinY() || //
                ( bounds.getMaxX() >= topRightComponent.getBounds().getMaxX() && hasSameTop( topRightComponent, bounds ) ) ) {
                haveMoreThanOneResult = hasSameTopRight( topRightComponent, bounds );
                topRightComponent = component;
            }
            if ( haveMoreThanOneResult ) {
                throw new IllegalArgumentException( "More than one valid result found" );
            }
        }
        return topRightComponent;
    }

    /**
     * Gets the leftmost component - when more than one chooses the bottommost
     */
    static public Component getBottomLeftmostComponent( Collection<? extends Component> components ) {
        Component bottomLeftComponent = null;
        boolean haveMoreThanOneResult = false;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( bottomLeftComponent == null || //
                bounds.getMinX() < bottomLeftComponent.getBounds().getMinX() || //
                ( hasSameLeft( bottomLeftComponent, bounds ) && bounds.getMaxY() >= bottomLeftComponent.getBounds().getMaxY() ) ) {
                haveMoreThanOneResult = hasSameBottomLeft( bottomLeftComponent, bounds );
                bottomLeftComponent = component;
            }
        }
        if ( haveMoreThanOneResult ) {
            throw new IllegalArgumentException( "More than one valid result found" );
        }
        return bottomLeftComponent;
    }

    /**
     * Gets the bottommost component - when more than one chooses the leftmost
     */
    static public Component getLeftBottommostComponent( Collection<? extends Component> components ) {
        Component bottomLeftComponent = null;
        boolean haveMoreThanOneResult = false;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( bottomLeftComponent == null || //
                bounds.getMaxY() > bottomLeftComponent.getBounds().getMaxY() || //
                ( bounds.getMinX() <= bottomLeftComponent.getBounds().getMinX() && hasSameBottom( bottomLeftComponent, bounds ) ) ) {
                haveMoreThanOneResult = hasSameBottomLeft( bottomLeftComponent, bounds );
                bottomLeftComponent = component;
            }
            if ( haveMoreThanOneResult ) {
                throw new IllegalArgumentException( "More than one valid result found" );
            }
        }
        return bottomLeftComponent;
    }

    /**
     * Gets the rightmost component - when more than one chooses the bottommost
     */
    static public Component getBottomRightmostComponent( Collection<? extends Component> components ) {
        Component bottomRightComponent = null;
        boolean haveMoreThanOneResult = false;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( bottomRightComponent == null || //
                bounds.getMaxX() > bottomRightComponent.getBounds().getMaxX() || //
                ( hasSameRight( bottomRightComponent, bounds ) && bounds.getMaxY() >= bottomRightComponent.getBounds().getMaxY() ) ) {
                haveMoreThanOneResult = hasSameBottomRight( bottomRightComponent, bounds );
                bottomRightComponent = component;
            }
        }
        if ( haveMoreThanOneResult ) {
            throw new IllegalArgumentException( "More than one valid result found" );
        }
        return bottomRightComponent;
    }

    /**
     * Gets the bottommost component - when more than one chooses the rightmost
     */
    static public Component getRightBottommostComponent( Collection<? extends Component> components ) {
        Component bottomRightComponent = null;
        boolean haveMoreThanOneResult = false;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( bottomRightComponent == null || //
                bounds.getMaxY() > bottomRightComponent.getBounds().getMaxY() || //
                ( bounds.getMaxX() >= bottomRightComponent.getBounds().getMaxX() && hasSameBottom( bottomRightComponent, bounds ) ) ) {
                haveMoreThanOneResult = hasSameBottomRight( bottomRightComponent, bounds );
                bottomRightComponent = component;
            }
            if ( haveMoreThanOneResult ) {
                throw new IllegalArgumentException( "More than one valid result found" );
            }
        }
        return bottomRightComponent;
    }

    static public Component getLeftmostComponent( Collection<? extends Component> components ) {
        Component leftmostComponent = null;
        boolean haveMoreThanOneResult = false;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( leftmostComponent == null || bounds.x <= leftmostComponent.getBounds().x ) {
                haveMoreThanOneResult = leftmostComponent != null && bounds.x == leftmostComponent.getBounds().x;
                leftmostComponent = component;
            }
        }
        if ( haveMoreThanOneResult ) {
            throw new IllegalArgumentException( "More than one valid result found" );
        }
        return leftmostComponent;
    }

    static public Component getTopmostComponent( Collection<? extends Component> components ) {
        Component topmostComponent = null;
        boolean haveMoreThanOneResult = false;
        for ( Component component : components ) {
            Rectangle bounds = component.getBounds();
            if ( topmostComponent == null || bounds.y <= topmostComponent.getBounds().y ) {
                haveMoreThanOneResult = topmostComponent != null && bounds.y == topmostComponent.getBounds().y;
                topmostComponent = component;
            }
        }
        if ( haveMoreThanOneResult ) {
            throw new IllegalArgumentException( "More than one valid result found" );
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
