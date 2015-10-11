package org.collesoft.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestServiceRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		rest("/api").get("/start").to("direct:startProcess").get("/stop").to("direct:stopProcess");

	}

}
