package org.collesoft.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestServiceRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		restConfiguration().component("restlet").host("localhost").bindingMode(RestBindingMode.auto);
		
		rest("/api").get("/start").to("direct:startProcess").get("/stop").to("direct:stopProcess");

	}

}
