package com.siniatech.siniautils.test;

import static junit.framework.Assert.*;

public class AssertHelper {

    static public void assertNotEquals( Object o1, Object o2 ) {
        assertFalse( o1.equals( o2 ) );
    }

}
