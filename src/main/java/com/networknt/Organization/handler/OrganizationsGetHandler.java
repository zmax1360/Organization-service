
package com.networknt.Organization.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.networknt.Organization.Container.ContainerManger;
import com.networknt.Organization.Mapper.ClassMapper;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;



public class OrganizationsGetHandler implements HttpHandler {
	static final Logger logger = LoggerFactory.getLogger(OrganizationsGetHandler.class);

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send(ClassMapper.MAPPER.writeValueAsString(ContainerManger.service.getall()));
	
	}
}
