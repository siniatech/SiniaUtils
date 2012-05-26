package com.siniatech.siniautils.orchestration;

import static junit.framework.Assert.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

// sif - haven't tested interruption
public class TestBackgroundThreadActionQueue {

    private ExecutorService threadPool;
    private Integer counter;

    @Before
    public void initTest() {
        counter = 0;
        threadPool = Executors.newCachedThreadPool();
    }

    @Test
    public void respond_executesInCorrectOrder() throws Exception {
        SimpleQueue queue = new SimpleQueue( threadPool );
        queue.respond( 1 );
        queue.respond( 2 );
        queue.respond( 3 );
        queue.respond( 4 );
        Thread.sleep( 100 );
        assertEquals( new Integer( 4 ), counter );
    }

    @Test
    public void respond_failsWithNullArgument() throws Exception {
        SimpleQueue queue = new SimpleQueue( threadPool );
        try {
            queue.respond( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void constructor_failsEarlyWithNullThreadPool() throws Exception {
        try {
            new SimpleQueue( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void constructor_failsEarlyWithShutdownThreadPool() throws Exception {
        threadPool.shutdownNow();
        assertEquals( true, threadPool.isShutdown() );
        try {
            new SimpleQueue( threadPool );
            fail();
        } catch ( Exception e ) {
        }
    }

    class SimpleQueue extends BackgroundThreadActionQueue<Integer> {
        public SimpleQueue( ExecutorService threadPool ) {
            super( threadPool );
        }

        @Override
        protected void executeAction( Integer actionNumber ) {
            counter++;
            assertEquals( actionNumber, counter );
        }

        @Override
        protected void onInterruption( InterruptedException e ) {
        }
    }
}
