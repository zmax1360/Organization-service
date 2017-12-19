
package com.networknt.Organization.handler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.networknt.Organization.Container.ContainerManger;
import com.networknt.Organization.Mapper.ClassMapper;
import com.networknt.Organization.model.Error;
import com.networknt.Organization.model.Organization;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import io.undertow.util.StatusCodes;



public class OrganizationGetByIdHandler implements HttpHandler {
	static final Logger logger = LoggerFactory.getLogger(OrganizationGetByIdHandler.class);

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		String id = exchange.getQueryParameters().get("id").peek();
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		Organization organization = ContainerManger.service.getLicenseById(id);
		String output;
		if (organization == null) {
			Error e = new Error("licenseId " + id + " has not found",new Date().getTime(),"not found",this.getClass().getName(),exchange.getRequestURI(),404);					
			exchange.setStatusCode(StatusCodes.NOT_FOUND);
			output = ClassMapper.MAPPER.writeValueAsString(e);
			
		} else {
			output = ClassMapper.MAPPER.writeValueAsString(organization);
		}
		exchange.setStatusCode(StatusCodes.ACCEPTED);
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send((output));
	}
}
