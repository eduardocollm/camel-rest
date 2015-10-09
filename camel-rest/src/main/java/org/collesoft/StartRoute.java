package org.collesoft;

import org.apache.camel.LoggingLevel;
import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartRoute extends FatJarRouter {

	@Override
	public void configure() throws Exception {
		super.configure();
		from("direct:start").log(LoggingLevel.INFO, "APPLICATION STarting");
	}

}