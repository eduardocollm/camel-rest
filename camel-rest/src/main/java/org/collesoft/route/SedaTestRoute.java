package org.collesoft.route;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SedaTestRoute extends RouteBuilder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SedaTestRoute.class);

	@Override
	public void configure() throws Exception {
		
		from("file:///Users/eduardocoll/test/camel").split().tokenize("\n").to("seda:doSomething");
		
		from("seda:doSomething?concurrentConsumers=100").log(LoggingLevel.DEBUG, LOGGER, body().toString()).process(new Processor() {
			
			@Override
			public void process(Exchange arg0) throws Exception {
				
				Thread.sleep(1000);
				
			}
		});

	}

}
