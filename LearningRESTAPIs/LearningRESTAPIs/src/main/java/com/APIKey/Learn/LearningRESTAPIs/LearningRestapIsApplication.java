package com.APIKey.Learn.LearningRESTAPIs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningRestapIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningRestapIsApplication.class, args);
	}

}
//how does web server works (all happens behind the scenes) -
//browser/Postman ->
//Embedded Tomcat ->
//dispatcherServlet ->
//handlermapping -> which controller?
//handlerAdapter -> call controller method
//Controller method returns POJO/DTO(data transfer object) ->
//Http Message Converter (eg:jackson-> JASON)
//DispatcherServlet writes to HttpServletResponse
//clients get the jason (output)