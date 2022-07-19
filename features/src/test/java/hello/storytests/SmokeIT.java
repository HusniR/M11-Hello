package hello.storytests;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URL;

public class SmokeIT {

	private String json = null;

	@When("^I call HelloWorld$")
	public void run_hello_world() throws Exception {

		/* Determine the URL of the Hello service. */
		String serviceURL = System.getenv("SERVICE_URL");
		if (serviceURL == null) throw new RuntimeException("SERVICE_URL not set in environment");

		/* Send an HTTP GET request to /hello. */
        Object content = (new URL(serviceURL + "/hello")).openConnection().getContent();

		/* Read output stream into a String */
		this.json = "";
		if (content instanceof InputStream) {
			BufferedReader br = new BufferedReader(new InputStreamReader((InputStream)content));
			for (;;) {
				String line = br.readLine();
				if (line == null) break;
				this.json += line;
			}
		} else {
			throw new Exception("Unexpected content type: " + content.getClass().getName());
		}
	}

	@Then("^it returns \"Hello world!\"$")
	public void it_returns_hello_world() throws Exception {
		assertEquals("Hello world!", this.json);
	}
}
