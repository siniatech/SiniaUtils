package com.siniatech.siniautils.fn;

import static com.siniatech.siniautils.fn.ConditionalHelper.*;
import static junit.framework.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.siniatech.siniautils.collection.SetHelper;

public class TestConditionalHelper {

    @Test
    public void alwaysTrue_handlesNull() throws Exception {
        assertTrue( alwaysTrue().apply( null ) );
    }

    @Test
    public void alwaysTrue_obj() throws Exception {
        assertTrue( alwaysTrue().apply( "32" ) );
        assertTrue( alwaysTrue().apply( Arrays.asList() ) );
        assertTrue( alwaysTrue().apply( new HashSet<>() ) );
    }

    @Test
    public void alwaysTrue_prim() throws Exception {
        assertTrue( alwaysTrue().apply( 32 ) );
        assertTrue( alwaysTrue().apply( 1L ) );
        assertTrue( alwaysTrue().apply( false ) );
    }

    @Test
    public void alwaysFalse_handlesNull() throws Exception {
        assertFalse( alwaysFalse().apply( null ) );
    }

    @Test
    public void alwaysFalse_obj() throws Exception {
        assertFalse( alwaysFalse().apply( "32" ) );
        assertFalse( alwaysFalse().apply( Arrays.asList() ) );
        assertFalse( alwaysFalse().apply( new HashSet<>() ) );
    }

    @Test
    public void alwaysFalse_prim() throws Exception {
        assertFalse( alwaysFalse().apply( 32 ) );
        assertFalse( alwaysFalse().apply( 1L ) );
        assertFalse( alwaysFalse().apply( false ) );
    }

    @Test
    public void equalsValue_handlesNull() throws Exception {
        assertTrue( equalsValue( null ).apply( null ) );
        assertFalse( equalsValue( 3 ).apply( null ) );
        assertFalse( equalsValue( null ).apply( 3 ) );
    }

    @Test
    public void equalsValue_obj() throws Exception {
        assertTrue( equalsValue( "32" ).apply( "32" ) );
        assertTrue( equalsValue( Arrays.asList( 23 ) ).apply( Arrays.asList( 23 ) ) );
        assertTrue( equalsValue( new HashSet<>() ).apply( new HashSet<>() ) );
        assertFalse( equalsValue( "33" ).apply( "32" ) );
        assertFalse( equalsValue( Arrays.asList( "23" ) ).apply( Arrays.asList( "23", "44" ) ) );
        assertFalse( equalsValue( SetHelper.asSet( "99" ) ).apply( SetHelper.asSet( "88" ) ) );
    }

    @Test
    public void equalsValue_prim() throws Exception {
        assertTrue( equalsValue( 32 ).apply( 32 ) );
        assertTrue( equalsValue( 1L ).apply( 1L ) );
        assertTrue( equalsValue( false ).apply( false ) );
        assertFalse( equalsValue( 33 ).apply( 32 ) );
        assertFalse( equalsValue( 9L ).apply( 1L ) );
        assertFalse( equalsValue( true ).apply( false ) );
    }

    @Test
    public void equalsIdentity_handlesNull() throws Exception {
        assertTrue( equalsIdentity( null ).apply( null ) );
        assertFalse( equalsIdentity( 3 ).apply( null ) );
        assertFalse( equalsIdentity( null ).apply( 3 ) );
    }

    @Test
    public void equalsIdentity_obj() throws Exception {
        String string = "32";
        List<Integer> list = Arrays.asList( 23 );
        Set<String> set = SetHelper.asSet( "99" );
        assertTrue( equalsIdentity( string ).apply( string ) );
        assertTrue( equalsIdentity( list ).apply( list ) );
        assertTrue( equalsIdentity( set ).apply( set ) );
        assertFalse( equalsIdentity( "33" ).apply( string ) );
        assertFalse( equalsIdentity( Arrays.asList( "23" ) ).apply( Arrays.asList( "23", "44" ) ) );
        assertFalse( equalsIdentity( set ).apply( SetHelper.asSet( "88" ) ) );
        assertFalse( equalsIdentity( Arrays.asList( 23 ) ).apply( list ) );
        assertFalse( equalsIdentity( set ).apply( SetHelper.asSet( "99S" ) ) );
    }

    @Test
    public void equalsIdentity_prim() throws Exception {
        assertTrue( equalsIdentity( 32 ).apply( 32 ) );
        assertTrue( equalsIdentity( 1L ).apply( 1L ) );
        assertTrue( equalsIdentity( false ).apply( false ) );
        assertFalse( equalsIdentity( 33 ).apply( 32 ) );
        assertFalse( equalsIdentity( 9L ).apply( 1L ) );
        assertFalse( equalsIdentity( true ).apply( false ) );
    }

    @Test
    public void and_failsOnNull_p1() throws Exception {
        try {
            and( alwaysTrue(), null ).apply( 1 );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void and_failsOnNull_p2() throws Exception {
        try {
            and( null, alwaysTrue() ).apply( 1 );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void and_logic() throws Exception {
        assertTrue( and( alwaysTrue(), alwaysTrue() ).apply( null ) );
        assertFalse( and( alwaysFalse(), alwaysTrue() ).apply( null ) );
        assertFalse( and( alwaysTrue(), alwaysFalse() ).apply( null ) );
        assertFalse( and( alwaysFalse(), alwaysFalse() ).apply( null ) );
    }

    @Test
    public void or_failsOnNull_p1() throws Exception {
        try {
            or( alwaysFalse(), null ).apply( 1 );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void or_failsOnNull_p2() throws Exception {
        try {
            or( null, alwaysTrue() ).apply( 1 );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void or_logic() throws Exception {
        assertTrue( or( alwaysTrue(), alwaysTrue() ).apply( null ) );
        assertTrue( or( alwaysFalse(), alwaysTrue() ).apply( null ) );
        assertTrue( or( alwaysTrue(), alwaysFalse() ).apply( null ) );
        assertFalse( or( alwaysFalse(), alwaysFalse() ).apply( null ) );
    }

}
