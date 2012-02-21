package com.siniatech.siniautils.file;

import static com.siniatech.siniautils.file.PathHelper.*;
import static com.siniatech.siniautils.test.AssertHelper.*;
import static junit.framework.Assert.*;

import java.io.File;
import java.nio.file.Path;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class TestPathHelper {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    private String pathString( String filename ) {
        return folder.getRoot().getAbsolutePath() + File.pathSeparator + filename;
    }

    @Test
    public void shaShouldBeEqualForSameFile() throws Exception {
        Path p = createFileWithContents( pathString( "f" ), "hello" );
        assertEquals( sha1( p ), sha1( p ) );
    }

    @Test
    public void shaShouldBeEqualForFilesWithSameContents() throws Exception {
        Path p1 = createFileWithContents( pathString( "f1" ), "hello" );
        Path p2 = createFileWithContents( pathString( "f2" ), "hello" );
        assertEquals( sha1( p1 ), sha1( p2 ) );
    }

    @Test
    public void shaShouldNotBeEqualForFilesWithDiffContents() throws Exception {
        Path p1 = createFileWithContents( pathString( "f1" ), "hello" );
        Path p2 = createFileWithContents( pathString( "f2" ), "goodbye" );
        assertNotEquals( sha1( p1 ), sha1( p2 ) );
    }
}
