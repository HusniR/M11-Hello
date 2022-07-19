/* This class serves only to enable Cucumber to be run by JUnit.
 Ref: http://maven.apache.org/surefire/maven-surefire-plugin/examples/cucumber.html
 */
package hello.storytests;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions( features = "src/test/resources/storytests",
	plugin = {
		"pretty:target/cucumber-pretty-report.txt",
		"html:target/cucumber-html-report.html",
		"json:target/cucumber-json-report.json"
	} )
// Options described here: https://testingneeds.wordpress.com/2015/09/15/junit-runner-with-cucumberoptions/
public class JUnitDriverIT {}
