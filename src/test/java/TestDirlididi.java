package test.java;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.Dirlididi;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestDirlididi {

	public static InMemoryRestServer server;

	public final static String PROBLEM_ID = "fakeProblemId";

	public final static String TEST_ID = "testId";

	@BeforeClass
	public static void beforeClass() throws Exception {
		server = InMemoryRestServer.create(new Dirlididi());
	}

	@AfterClass
	public static void afterClass() throws Exception {
		server.close();
	}

	public static void TestGetProblems() {

		Response response = server.newRequest("/problem").request().buildGet()
				.invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	public static void TestGetProblemTests() {
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/test").request()
				.buildGet().invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	public static void TestGetProblemTestWithId() {
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/test/" + TEST_ID)
				.request().buildGet().invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	public static void TestPostSolutionToProblem() {
		Entity<String> someEntity = Entity.entity("solutionString, user",
				MediaType.APPLICATION_JSON);
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/solution").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	public static void TestPostNewProblemTest() {
		Entity<String> someEntity = Entity.entity(
				"name, tip, entry, expectedResult", MediaType.APPLICATION_JSON);
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/test").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

}
