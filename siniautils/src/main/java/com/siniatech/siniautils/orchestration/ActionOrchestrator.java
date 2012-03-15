package com.siniatech.siniautils.orchestration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

import com.siniatech.siniautils.fn.IResponse1;

public abstract class ActionOrchestrator<T, U extends IResponse1<T>> implements IResponse1<U> {

    private BlockingQueue<U> actionQueue;

    public ActionOrchestrator( ExecutorService threadPool ) {
        this.actionQueue = new LinkedBlockingQueue<>();

        threadPool.submit( new Runnable() {
            @Override
            public void run() {
                try {
                    while ( true ) {
                        actionQueue.take().respond( getActionContext() );
                    }
                } catch ( InterruptedException e ) {
                    onInterruption( e );
                }
            }
        } );
    }

    abstract protected T getActionContext();

    @Override
    public void respond( U action ) {
        addActionToQueue( action );
    }

    protected void addActionToQueue( U action ) {
        try {
            actionQueue.put( action );
        } catch ( InterruptedException e ) {
            onInterruption( e );
        }
    }

    abstract protected void onInterruption( InterruptedException e );

}
