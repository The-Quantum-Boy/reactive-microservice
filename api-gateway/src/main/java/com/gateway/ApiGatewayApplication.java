package com.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication implements ApplicationRunner {

	@Autowired
	DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> services = this.discoveryClient.getServices();
		List<ServiceInstance> instances = new ArrayList<>();
		services.forEach(serviceName -> {
			this.discoveryClient.getInstances(serviceName).forEach(instance ->{
				instances.add(instance);
			});
		});

		System.out.println("list->"+instances);
	}
}

