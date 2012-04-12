package com.siniatech.siniautils.collection;

import java.util.List;

public class ListHelper {

    static public <T> T head( List<T> list ) {
        return list.get( 0 );
    }

}
