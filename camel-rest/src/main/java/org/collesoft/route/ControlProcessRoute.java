package org.collesoft.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ControlProcessRoute extends RouteBuilder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControlProcessRoute.class);

	@Override
	public void configure() throws Exception {
		
		from("direct:startProcess").process(new Processor() {
			
			@Override
			public void process(Exchange arg0) throws Exception {
				
				LOGGER.debug("start process");
				
			}
		});
		
		from("direct:stopProcess").process(new Processor() {
			
			@Override
			public void process(Exchange arg0) throws Exception {
				
				LOGGER.debug("stop process");
				
			}
		});

	}

}
