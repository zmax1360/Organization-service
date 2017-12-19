
package com.networknt.Organization.handler;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.networknt.Organization.Container.ContainerManger;
import com.networknt.Organization.Mapper.ClassMapper;
import com.networknt.Organization.model.Organization;
import com.networknt.body.BodyHandler;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import io.undertow.util.StatusCodes;

public class OrganizationsPostHandler implements HttpHandler {
	static final Logger logger = LoggerFactory.getLogger(OrganizationsPostHandler.class);

	@SuppressWarnings("unchecked")
	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		
		final Map<String, Object> body = (Map<String, Object>) exchange.getAttachment(BodyHandler.REQUEST_BODY);
		Organization newOrganizations = ContainerManger.service.createLicense(body);
		exchange.setStatusCode(StatusCodes.CREATED);
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send(ClassMapper.MAPPER.writeValueAsString(newOrganizations));
		exchange.endExchange();
	}
}
