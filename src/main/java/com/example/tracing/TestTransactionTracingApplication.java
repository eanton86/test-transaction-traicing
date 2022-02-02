package com.example.tracing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TestTransactionTracingApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(TestTransactionTracingApplication.class, args);

		var myService = applicationContext.getBean(MyService.class);

		var traceWithNewSpan1 = myService.getTraceWithNewSpan();
		var traceWithNewSpan2 = myService.getTraceWithNewSpan();
		System.out.println("Good: " + traceWithNewSpan1 + " != " + traceWithNewSpan2);

		var traceForTransaction1 = myService.getTraceWithTransactional();
		var traceForTransaction2 = myService.getTraceWithTransactional();
		System.out.println("Not good: " + traceForTransaction1 + " == " + traceForTransaction2);

		System.exit(0);
	}


}
