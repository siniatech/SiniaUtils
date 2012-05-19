package com.siniatech.siniautils.collection;

import static junit.framework.Assert.*;
import static com.siniatech.siniautils.test.AssertHelper.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TestCollectionHelper {

    static final private String a = "a";
    static final private String b = "b";
    static final private String c = "c";

    @Test
    public void getArbitraryMember_failsOnNull() throws Exception {
        try {
            CollectionHelper.getArbitraryMember( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getArbitraryMember_handlesEmptyCollection() throws Exception {
        assertNull( CollectionHelper.getArbitraryMember( Arrays.asList() ) );
    }

    @Test
    public void getArbitraryMember_arbMemberInCollection() throws Exception {
        assertNull( CollectionHelper.getArbitraryMember( Arrays.asList() ) );
    }

    @Test
    public void getArbitraryMember_arbMemberInList() throws Exception {
        List<String> list = Arrays.asList( a, b, c );
        String arbitraryMember = CollectionHelper.getArbitraryMember( list );
        assertContains( arbitraryMember, list );
    }
    
    @Test
    public void getArbitraryMember_arbMemberInSet() throws Exception {
        Set<String> set = SetHelper.asSet( a, b, c );
        String arbitraryMember = CollectionHelper.getArbitraryMember( set );
        assertContains( arbitraryMember, set );
    }

}
