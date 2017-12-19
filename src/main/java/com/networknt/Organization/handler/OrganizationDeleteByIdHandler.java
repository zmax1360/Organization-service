
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



public class OrganizationDeleteByIdHandler implements HttpHandler {
	static final Logger logger = LoggerFactory.getLogger(OrganizationDeleteByIdHandler.class);

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		String id = exchange.getQueryParameters().get("id").peek();
		Organization organization = ContainerManger.service.getLicenseById(id);

		String output;
		if (organization == null) {
			Error e = new Error("id " + id + " has not found", new Date().getTime(), "not found",
					this.getClass().getName(), exchange.getRequestURI(), 404);
			exchange.setStatusCode(StatusCodes.NOT_FOUND);
			output = ClassMapper.MAPPER.writeValueAsString(e);
			exchange.getResponseSender().send((output));

		} else {
			ContainerManger.service.deleteLicenseById(id);
			exchange.setStatusCode(StatusCodes.NO_CONTENT);
		}
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");

	}
}
