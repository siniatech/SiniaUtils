package com.siniatech.siniautils.swing;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class BoundsHelper {

    static public Component getTopLeftmostComponent(List<Component> components) {
        Component topLeftComponent = null;
        for (Component component : components) {
            Rectangle bounds = component.getBounds();
            if (topLeftComponent == null || (bounds.x <= topLeftComponent.getBounds().x && bounds.y <= topLeftComponent.getBounds().y)) {
                topLeftComponent = component;
            }
        }
        return topLeftComponent;
    }

    static public Component getLeftmostComponent(List<Component> components) {
        Component leftmostComponent = null;
        for (Component component : components) {
            Rectangle bounds = component.getBounds();
            if (leftmostComponent == null || bounds.x <= leftmostComponent.getBounds().x) {
                leftmostComponent = component;
            }
        }
        return leftmostComponent;
    }

    static public Component getTopmostComponent(List<Component> components) {
        Component topmostComponent = null;
        for (Component component : components) {
            Rectangle bounds = component.getBounds();
            if (topmostComponent == null || bounds.y <= topmostComponent.getBounds().y) {
                topmostComponent = component;
            }
        }
        return topmostComponent;
    }

    /**
     * Returns components whose origin is in bounds.
     */
    static public List<Component> getComponentsIn(List<Component> components, Rectangle bounds) {
        List<Component> componentsInBounds = new ArrayList<Component>();
        for (Component component : components) {
            if (bounds.contains(component.getLocation())) {
                componentsInBounds.add(component);
            }
        }
        return componentsInBounds;
    }

    // need a getComponentsWhollyIn at some point
}

