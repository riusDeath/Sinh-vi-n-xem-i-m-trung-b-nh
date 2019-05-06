package com.thuannd.test.utils;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thuannd.xemdiemthi.utils.DBConnection;

public class TestDBConnection {

	private static Connection connection;
	
	@BeforeClass
	public static void init() {
		connection = DBConnection.connect();
	}
	
	@Test
	public void testIfConnectionNotNull() {
		assertNotNull(connection);
	}
	
}
