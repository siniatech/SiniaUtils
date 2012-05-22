package com.siniatech.siniautils.collection;

import static com.siniatech.siniautils.collection.SetHelper.*;
import static com.siniatech.siniautils.test.AssertHelper.*;
import static junit.framework.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TestSetHelper {

    @Test
    public void asSet_handlesNull() throws Exception {
        Set<String> nullSet = SetHelper.<String> asSet( (String) null );
        assertEquals( 1, nullSet.size() );
        assertContains( null, nullSet );
    }

    @Test
    public void asSet_obj() throws Exception {
        List<String> a = Arrays.asList( "a" );
        List<String> b = Arrays.asList( "b", "B" );
        List<String> c = Arrays.asList( "C", "3", "c" );
        Set<List<String>> intSet = asSet( a, b, c );
        assertEquals( 3, intSet.size() );
        assertContains( a, intSet );
        assertContains( b, intSet );
        assertContains( c, intSet );
    }

    @Test
    public void asSet_primitive() throws Exception {
        Set<Integer> intSet = asSet( 1, 2, 3 );
        assertEquals( 3, intSet.size() );
        assertContains( 1, intSet );
        assertContains( 2, intSet );
        assertContains( 3, intSet );
    }

    @Test
    public void emptySet_isZeroCardinalitySet() throws Exception {
        assertEquals( 0, emptySet().size() );
        assertTrue( emptySet() instanceof Set );
    }

}
