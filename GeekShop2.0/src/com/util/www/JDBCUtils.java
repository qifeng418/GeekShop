package com.util.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {
	
	private static DataSource ds;
	
	// to initialize DataSource using Druid configuration 
	static {
		
		try {
			
			Properties pro = new Properties();
			pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
			ds = DruidDataSourceFactory.createDataSource(pro);
			
		}	catch (IOException e) {
			e.printStackTrace();
		}	catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getConnection() 
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	} 
	
	/**
	 * getDataSource()
	 * @return DataSource
	 */
	public static DataSource getDataSource() {
		return ds;
	}

	/**
	 * close()
	 * @param stmt
	 * @param conn
	 */
	public static void colse(Statement stmt, Connection conn) {

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * close() without ResultSet
	 * @param stmt
	 * @param conn
	 * @param rs
	 */
	public static void colse(Statement stmt, Connection conn, ResultSet rs) {

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
