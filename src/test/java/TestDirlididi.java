package test.java;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import main.java.Dirlididi;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestDirlididi {

	private static final String FAKE_ID = "fakeId";

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

	// GET /PROBLEM
	@Test
	public  void TestGetProblems() {

		Response response = server.newRequest("/problem").request().buildGet()
				.invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	// POST /PROBLEM
	@Test
	public void TestPostNewProblem() {
		Entity<String> someEntity = Entity.entity(
				"name, description, code, tip", MediaType.APPLICATION_JSON);
		Response response = server.newRequest("/problem").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	// GET /PROBLEM/{id}
	@Test
	public void TEstGetProblemWithId() {
		Response response = server.newRequest("/problem/" + PROBLEM_ID)
				.request().buildGet().invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	// GET /PROBLEM/{id}/TEST
	@Test
	public void TestGetProblemTests() {
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/test").request()
				.buildGet().invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	// GET /PROBLEM/{id}/TEST/{testid}
	@Test
	public void TestGetProblemTestWithId() {
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/test/" + TEST_ID)
				.request().buildGet().invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	// POST /PROBLEM/{id}/SOLUTION
	@Test
	public void TestPostSolutionToProblem() {
		Entity<String> someEntity = Entity.entity("solutionString, user",
				MediaType.APPLICATION_JSON);
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/solution").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	// POST /PROBLEM/{id}/TEST
	@Test
	public void TestPostNewProblemTest() {
		Entity<String> someEntity = Entity.entity(
				"name, tip, entry, expectedResult", MediaType.APPLICATION_JSON);
		Response response = server
				.newRequest("/problem/" + PROBLEM_ID + "/test").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	// POST /LOGIN
	@Test
	public void TestLogin() {
		Entity<String> someEntity = Entity.entity("login, pass",
				MediaType.APPLICATION_JSON);
		Response response = server.newRequest("/login").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	// POST /ACCOUNT
	@Test
	public void testCreateAccount() {
		Entity<String> someEntity = Entity.entity("email, pass",
				MediaType.APPLICATION_JSON);
		Response response = server.newRequest("/account").request()
				.buildPost(someEntity).invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	// GET /ACCOUNT
	@Test
	public void getAllAccount() {
		Entity<String> someEntity = Entity.entity("email, pass",
				MediaType.APPLICATION_JSON);
		Response response = server.newRequest("/account").request().buildGet()
				.invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

	// GET /ACCOUNT
	@Test
	public void getAnAccount() {
		Response response = server.newRequest("/account/" + FAKE_ID).request().buildGet()
				.invoke();

		assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	}

}
