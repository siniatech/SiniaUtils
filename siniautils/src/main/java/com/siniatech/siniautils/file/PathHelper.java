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
package com.siniatech.siniautils.file;

import static java.nio.file.Files.*;
import static org.apache.commons.codec.digest.DigestUtils.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
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
        try (BufferedWriter out = newBufferedWriter( path, Charset.defaultCharset() )) {
            out.write( contents );
            return path;
        }
    }

    static public String getFileContents( Path file ) throws IOException {
        try (BufferedReader in = newBufferedReader( file, Charset.defaultCharset() )) {
            StringBuffer sb = new StringBuffer();
            String line;
            while ( ( line = in.readLine() ) != null ) {
                sb.append( line );
            }
            return sb.toString();
        }
    }

    static public String sha( Path path ) throws IOException {
        try (InputStream in = newInputStream( path )) {
            return sha256Hex( in );
        }
    }
}
