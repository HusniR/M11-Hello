FROM openjdk:14
COPY ./main-1.0.jar /
CMD ["java", "-cp", "main-1.0.jar", "hello.HelloWorld"]
