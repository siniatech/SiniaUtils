package com.siniatech.siniautils.fn;

public interface IResponse0 {

    void respond();

    static public class Utils {
        static public IResponse0 emptyResponse = new IResponse0() {
            @Override
            public void respond() {
            }
        };
    }
}
