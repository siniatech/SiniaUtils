package com.siniatech.siniautils.orchestration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

import com.siniatech.siniautils.fn.IResponse1;

public abstract class BackgroundThreadActionQueue<T> implements IResponse1<T> {

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
