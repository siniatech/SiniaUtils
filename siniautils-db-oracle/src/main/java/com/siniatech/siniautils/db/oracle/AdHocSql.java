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
package com.siniatech.siniautils.db.oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class AdHocSql {
    public static void main( String args[] ) throws SQLException {
        if ( args.length < 4 ) {
            StringBuilder sb = new StringBuilder( "\n" );
            sb.append( "Usage: \n" );
            sb.append( "AdHocSql username password url query\n" );
            throw new IllegalArgumentException( sb.toString() );
        }
        String username = args[0];
        String password = args[1];
        String database = args[2];
        String query = args[3];
        OracleDataSource ods = new OracleDataSource();
        ods.setURL( database );
        ods.setUser( username );
        ods.setPassword( password );
        Connection conn = ods.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery( query );
        ResultSetMetaData metadata = rset.getMetaData();
        int columnCount = metadata.getColumnCount();
        for ( int i = 1; i <= columnCount; i++ ) {
            int columnDisplaySize = metadata.getColumnDisplaySize( i );
            String columnName = metadata.getColumnName( i );
            System.out.print( String.format( "%" + columnDisplaySize + "s ", columnName ) );
        }
        System.out.print( "\n" );
        while ( rset.next() ) {
            for ( int i = 1; i <= columnCount; i++ ) {
                int columnDisplaySize = metadata.getColumnDisplaySize( i );
                String columnData = rset.getString( i );
                String data = columnData != null && columnData.length() > columnDisplaySize ? columnData.substring( 0, columnDisplaySize - 1 ) : columnData;
                System.out.print( String.format( "%" + columnDisplaySize + "s ", data ) );
            }
            System.out.print( "\n" );
        }
        stmt.close();
    }
}