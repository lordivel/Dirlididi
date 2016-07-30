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

	//GET /PROBLEM
	public static void TestGetProblems() {

		Response response = server.newRequest("/problem").request().buildGet()
				.invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	//POST /PROBLEM
	public static void TestPostNewProblem() {
		Entity<String> someEntity = Entity.entity(
				"name, description, code, tip", MediaType.APPLICATION_JSON);
		Response response = server
				.newRequest("/problem").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	//GET /PROBLEM/{id}
	public static void TEstGetProblemWithId() {
		Response response = server.newRequest("/problem/" + PROBLEM_ID)
				.request().buildGet().invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	//GET /PROBLEM/{id}/TEST
	public static void TestGetProblemTests() {
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/test").request()
				.buildGet().invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	//GET /PROBLEM/{id}/TEST/{testid}
	public static void TestGetProblemTestWithId() {
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/test/" + TEST_ID)
				.request().buildGet().invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	//POST /PROBLEM/{id}/SOLUTION
	public static void TestPostSolutionToProblem() {
		Entity<String> someEntity = Entity.entity("solutionString, user",
				MediaType.APPLICATION_JSON);
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/solution").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	//POST /PROBLEM/{id}/TEST
	public static void TestPostNewProblemTest() {
		Entity<String> someEntity = Entity.entity(
				"name, tip, entry, expectedResult", MediaType.APPLICATION_JSON);
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/test").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}
	
	//POST /LOGIN
	public static void TestLogin() {
		Entity<String> someEntity = Entity.entity(
				"login, pass", MediaType.APPLICATION_JSON);
		Response response = server
				.newRequest("/login").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

}
