package com.siniatech.siniautils.test;

import static org.junit.Assert.*;

import java.util.Collection;

public class AssertHelper {
    static public void assertNotEquals( Object o1, Object o2 ) {
        assertFalse( o1.equals( o2 ) );
    }

    static public <T> void assertContains( T t, Collection<T> coll ) {
        assertTrue( coll.contains( t ) );
    }
}
