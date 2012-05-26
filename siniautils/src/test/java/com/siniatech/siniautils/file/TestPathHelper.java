package com.siniatech.siniautils.file;

import static com.siniatech.siniautils.file.PathHelper.*;
import static com.siniatech.siniautils.test.AssertHelper.*;
import static java.nio.file.Files.*;
import static junit.framework.Assert.*;

import java.io.File;
import java.nio.file.FileSystems;
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
    public void sha_shouldBeEqualForSameFile() throws Exception {
        Path p = createFileWithContents( pathString( "f" ), "hello" );
        assertEquals( sha( p ), sha( p ) );
    }

    @Test
    public void sha_shouldBeEqualForFilesWithSameContents() throws Exception {
        Path p1 = createFileWithContents( pathString( "f1" ), "hello" );
        Path p2 = createFileWithContents( pathString( "f2" ), "hello" );
        assertEquals( sha( p1 ), sha( p2 ) );
    }

    @Test
    public void sha_shouldNotBeEqualForFilesWithDiffContents() throws Exception {
        Path p1 = createFileWithContents( pathString( "f1" ), "hello" );
        Path p2 = createFileWithContents( pathString( "f2" ), "goodbye" );
        assertNotEquals( sha( p1 ), sha( p2 ) );
    }

    @Test
    public void sha_failsOnNull() throws Exception {
        try {
            sha( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void createFileWithContents_failsOnNull_p1() throws Exception {
        try {
            createFileWithContents( null, "hello" );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void createFileWithContents_failsOnNull_p2() throws Exception {
        try {
            createFileWithContents( pathString( "f1" ), null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void createFileWithContents_failsWithExistingFile() throws Exception {
        createFileWithContents( pathString( "f1" ), "first" );
        try {
            createFileWithContents( pathString( "f1" ), "second" );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void createFileWithContents_createsFile() throws Exception {
        Path path = FileSystems.getDefault().getPath( pathString( "f1" ) );
        assertFalse( exists( path ) );
        createFileWithContents( pathString( "f1" ), "hello" );
        assertTrue( exists( path ) );
    }

    @Test
    public void createFileWithContents_createsCorrectContents() throws Exception {
        Path path = FileSystems.getDefault().getPath( pathString( "f1" ) );
        Path createdFile = createFileWithContents( pathString( "f1" ), "hello" );
        assertEquals( path, createdFile );
        assertEquals( "hello", getFileContents( createdFile ) );
    }

    @Test
    public void getFileContents_failsOnNull() throws Exception {
        try {
            getFileContents( null );
            fail();
        } catch ( Exception e ) {
        }
    }

    @Test
    public void getFileContents_failsWithNonExistingFile() throws Exception {
        try {
            getFileContents( FileSystems.getDefault().getPath( pathString( "f1" ) ) );
            fail();
        } catch ( Exception e ) {
        }
    }
    
    @Test
    public void getFileContents_getsCorrectContents() throws Exception {
        assertEquals( "hello", getFileContents( createFileWithContents( pathString( "f1" ), "hello" ) ) );
    }
}
