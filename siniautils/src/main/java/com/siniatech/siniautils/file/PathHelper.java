package com.siniatech.siniautils.file;

import static java.nio.file.Files.*;
import static org.apache.commons.codec.digest.DigestUtils.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathHelper {

    static public Path createFileWithContents( String pathString, String contents ) throws IOException {
        Path path = FileSystems.getDefault().getPath( pathString );
        if ( exists( path ) ) {
            throw new IOException( "File " + pathString + " already exists." );
        } else {
            createFile( path );
        }
        BufferedWriter out = newBufferedWriter( path, Charset.defaultCharset() );
        out.write( contents );
        out.close();
        return path;
    }

    static public String getFileContents( Path file ) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader in = newBufferedReader( file, Charset.defaultCharset() );
        String line;
        while ( ( line = in.readLine() ) != null ) {
            sb.append( line );
        }
        in.close();
        return sb.toString();
    }

    static public String sha( Path path ) throws IOException {
        return sha256Hex( newInputStream( path ) );
    }
}
