package com.siniatech.siniautils.collection;

import java.util.ArrayList;
import java.util.List;

public class ListHelper {

    static public <T> T head( List<T> list ) {
        return list.size() == 0 ? null : list.get( 0 );
    }

    static public <T> List<T> tail( List<T> list ) {
        List<T> tail = new ArrayList<>( list );
        tail.remove( head( list ) );
        return tail;
    }
}
