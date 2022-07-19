package hello.unittest;

import hello.HelloWorld;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestHelloWorld {

	@Test
	public void testSayHi() {
		HelloWorld h = new HelloWorld();
		String result = h.sayHi();
		assertEquals("Hello world!", result);
	}
}
