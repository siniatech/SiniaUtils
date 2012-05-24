package com.siniatech.siniautils.collection;

import static com.siniatech.siniautils.collection.CollectionHelper.*;
import static com.siniatech.siniautils.fn.ConditionalHelper.*;
import static com.siniatech.siniautils.test.AssertHelper.*;
import static junit.framework.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.siniatech.siniautils.named.INamed;
import com.siniatech.siniautils.named.Named;

public class TestCollectionHelper {

    static final private INamed a = new Named( "a" );
    static final private INamed b = new Named( "b" );
    static final private INamed c = new Named( "c" );

    @Test
    public void getArbitraryMember_failsOnNull() throws Exception {
        try {
            getArbitraryMember( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getArbitraryMember_handlesEmptyCollection() throws Exception {
        assertNull( getArbitraryMember( Arrays.asList() ) );
    }

    @Test
    public void getArbitraryMember_arbMemberInList() throws Exception {
        List<INamed> list = Arrays.asList( a, b, c );
        INamed arbitraryMember = getArbitraryMember( list );
        assertContains( arbitraryMember, list );
    }

    @Test
    public void getArbitraryMember_arbMemberInSet() throws Exception {
        Set<INamed> set = SetHelper.asSet( a, b, c );
        INamed arbitraryMember = getArbitraryMember( set );
        assertContains( arbitraryMember, set );
    }

    @Test
    public void exists_failsOnNull_p1() throws Exception {
        try {
            exists( null, alwaysTrue() );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void exists_failsOnNull_p2() throws Exception {
        try {
            exists( Arrays.asList( a, b, c ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void exists_handlesEmptyCollection() throws Exception {
        assertFalse( exists( Arrays.<INamed> asList(), equalsValue( a ) ) );
        assertFalse( exists( Arrays.<INamed> asList(), equalsValue( b ) ) );
        assertFalse( exists( Arrays.<INamed> asList(), equalsValue( c ) ) );
    }

    @Test
    public void exists_inList() throws Exception {
        List<INamed> list = Arrays.asList( a, c );
        assertTrue( exists( list, equalsValue( a ) ) );
        assertFalse( exists( list, equalsValue( b ) ) );
        assertTrue( exists( list, equalsValue( c ) ) );
    }

    @Test
    public void exists_inSet() throws Exception {
        Set<INamed> set = SetHelper.asSet( a, b );
        assertTrue( exists( set, equalsValue( a ) ) );
        assertTrue( exists( set, equalsValue( b ) ) );
        assertFalse( exists( set, equalsValue( c ) ) );
    }

    @Test
    public void find_failsOnNull_p1() throws Exception {
        try {
            find( null, alwaysTrue() );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void find_failsOnNull_p2() throws Exception {
        try {
            find( Arrays.asList( a, b, c ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void find_handlesEmptyCollection() throws Exception {
        assertNull( find( Arrays.<INamed> asList(), equalsValue( a ) ) );
        assertNull( find( Arrays.<INamed> asList(), equalsValue( b ) ) );
        assertNull( find( Arrays.<INamed> asList(), equalsValue( c ) ) );
    }

    @Test
    public void find_inList() throws Exception {
        List<INamed> list = Arrays.asList( a, c );
        assertEquals( a, find( list, equalsValue( a ) ) );
        assertNull( find( list, equalsValue( b ) ) );
        assertEquals( c, find( list, equalsValue( c ) ) );
    }

    @Test
    public void find_inListReturnsFirstMatch() throws Exception {
        List<INamed> list = Arrays.asList( a, c, b );
        assertEquals( a, find( list, or( equalsValue( a ), equalsValue( c ) ) ) );
        assertEquals( c, find( list, or( equalsValue( b ), equalsValue( c ) ) ) );
    }

    @Test
    public void find_inSet() throws Exception {
        Set<INamed> set = SetHelper.asSet( a, b );
        assertEquals( a, find( set, equalsValue( a ) ) );
        assertEquals( b, find( set, equalsValue( b ) ) );
        assertNull( find( set, equalsValue( c ) ) );
    }

    @Test
    public void filter_failsOnNull_p1() throws Exception {
        try {
            filter( null, alwaysTrue() );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void filter_failsOnNull_p2() throws Exception {
        try {
            filter( Arrays.asList( a, b, c ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void filter_handlesEmptyCollection() throws Exception {
        assertEquals( Arrays.<INamed> asList(), filter( Arrays.<INamed> asList(), equalsValue( a ) ) );
        assertEquals( Arrays.<INamed> asList(), filter( Arrays.<INamed> asList(), equalsValue( b ) ) );
        assertEquals( Arrays.<INamed> asList(), filter( Arrays.<INamed> asList(), equalsValue( c ) ) );
    }

    @Test
    public void filter_inList() throws Exception {
        List<INamed> list = Arrays.asList( a, c );
        assertEquals( Arrays.<INamed> asList( a ), filter( list, equalsValue( a ) ) );
        assertEquals( Arrays.<INamed> asList(), filter( list, equalsValue( b ) ) );
        assertEquals( Arrays.<INamed> asList( a, c ), filter( list, or( equalsValue( a ), equalsValue( c ) ) ) );
    }

    @Test
    public void filter_inSet() throws Exception {
        Set<INamed> set = SetHelper.asSet( a, b );
        assertEquals( Arrays.<INamed> asList( a ), filter( set, equalsValue( a ) ) );
        assertEquals( Arrays.<INamed> asList( b ), filter( set, equalsValue( b ) ) );
        assertEquals( Arrays.<INamed> asList(), filter( set, equalsValue( c ) ) );
        Collection<INamed> result = filter( set, or( equalsValue( a ), equalsValue( b ) ) );
        assertEquals( 2, result.size() );
        assertContains( a, result );
        assertContains( b, result );
    }

}
