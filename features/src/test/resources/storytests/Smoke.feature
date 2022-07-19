Feature: Smoke

	Scenario: Basic

		When I call HelloWorld
		Then it returns "Hello world!"
