package hello;

import static spark.Spark.*;

public class HelloWorld {
	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorld();

		//System.out.println(helloWorld.sayHi());
		get("/hello", (req, res) -> helloWorld.sayHi());
	}
	public String sayHi() {
		return "Hello world!";
	}
}
