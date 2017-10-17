package io.spring.esdemo;

import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EsDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EsDemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
	}
}
