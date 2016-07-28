package test.java;

import main.java.Dirlididi;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestDirlididi {

	    public static InMemoryRestServer server;
	    @BeforeClass
	    public static void beforeClass() throws Exception {
	        server = InMemoryRestServer.create(new Dirlididi());
	    }
	    @AfterClass
	    public static void afterClass() throws Exception {
	        server.close();
	    }

}
