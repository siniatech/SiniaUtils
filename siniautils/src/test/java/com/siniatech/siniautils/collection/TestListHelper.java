package com.siniatech.siniautils.collection;

import static com.siniatech.siniautils.collection.ListHelper.*;
import static junit.framework.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.siniatech.siniautils.named.INamed;
import com.siniatech.siniautils.named.Named;

public class TestListHelper {

    static final private INamed a = new Named( "a" );
    static final private INamed b = new Named( "b" );
    static final private INamed c = new Named( "c" );

    @Test
    public void head_failsOnNull() throws Exception {
        try {
            head( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void head_handlesEmptyCollection() throws Exception {
        assertNull( head( Arrays.asList() ) );
    }

    @Test
    public void head_getsHead() throws Exception {
        assertEquals( a, head( Arrays.asList( a, b, c ) ) );
        assertEquals( b, head( Arrays.asList( b, c ) ) );
        assertEquals( c, head( Arrays.asList( c, a, b ) ) );
    }

    @Test
    public void tail_failsOnNull() throws Exception {
        try {
            tail( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void tail_handlesEmptyCollection() throws Exception {
        assertEquals( Arrays.asList(), tail( Arrays.asList() ) );
    }

    @Test
    public void tail_getsTail() throws Exception {
        assertEquals( Arrays.asList( b, c ), tail( Arrays.asList( a, b, c ) ) );
        assertEquals( Arrays.asList( c ), tail( Arrays.asList( b, c ) ) );
        assertEquals( Arrays.asList(), tail( Arrays.asList( c ) ) );
    }

}
