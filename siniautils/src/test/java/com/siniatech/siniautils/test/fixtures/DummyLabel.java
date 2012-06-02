package com.siniatech.siniautils.test.fixtures;

import javax.swing.JLabel;

public class DummyLabel extends JLabel {
    private final String s;

    public DummyLabel( String s ) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
