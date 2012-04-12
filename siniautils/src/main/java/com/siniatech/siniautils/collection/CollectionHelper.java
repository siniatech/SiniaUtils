package com.siniatech.siniautils.collection;

import java.util.Collection;

public class CollectionHelper {

    static public <T> T getArbitraryMember( Collection<T> s ) {
        return s.isEmpty() ? null : s.iterator().next();
    }

}
