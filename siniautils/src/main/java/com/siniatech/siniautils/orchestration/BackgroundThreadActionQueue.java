/*******************************************************************************
 * SiniaUtils
 * Copyright (c) 2011-2 Siniatech Ltd  
 * http://www.siniatech.com/products/siniautils
 *
 * All rights reserved. This project and the accompanying materials are made 
 * available under the terms of the MIT License which can be found in the root  
 * of the project, and at http://www.opensource.org/licenses/mit-license.php
 *
 ******************************************************************************/
package com.siniatech.siniautils.orchestration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

import com.siniatech.siniautils.fn.IResponse1;

abstract public class BackgroundThreadActionQueue<T> implements IResponse1<T> {

    private BlockingQueue<T> actionQueue;

    public BackgroundThreadActionQueue( ExecutorService threadPool ) {
        this.actionQueue = new LinkedBlockingQueue<>();

        threadPool.submit( new Runnable() {
            @Override
            public void run() {
                try {
                    while ( true ) {
                        executeAction( actionQueue.take() );
                    }
                } catch ( InterruptedException e ) {
                    onInterruption( e );
                }
            }
        } );
    }

    abstract protected void executeAction( T action );

    abstract protected void onInterruption( InterruptedException e );

    @Override
    public void respond( T action ) {
        addActionToQueue( action );
    }

    protected void addActionToQueue( T action ) {
        try {
            actionQueue.put( action );
        } catch ( InterruptedException e ) {
            onInterruption( e );
        }
    }

}
