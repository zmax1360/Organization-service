
package com.networknt.Organization.handler;

import java.util.Date;
import java.util.Map;

import com.networknt.Organization.Container.ContainerManger;
import com.networknt.Organization.Mapper.ClassMapper;
import com.networknt.Organization.model.Error;
import com.networknt.Organization.model.Organization;
import com.networknt.body.BodyHandler;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import io.undertow.util.StatusCodes;;

public class OrganizationPutByIdHandler implements HttpHandler {
	
	@SuppressWarnings("unchecked")
	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		String id = exchange.getQueryParameters().get("id").peek();
		final Map<String, Object> body = (Map<String, Object>) exchange.getAttachment(BodyHandler.REQUEST_BODY);

		Organization organization = ContainerManger.service.getLicenseById(id);
		String output;
		if (organization == null) {
			Error e = new Error("licenseId " + id + " has not found", new Date().getTime(), "not found",
					this.getClass().getName(), exchange.getRequestURI(), 404);
			exchange.setStatusCode(StatusCodes.NOT_FOUND);
			output = ClassMapper.MAPPER.writeValueAsString(e);

		} else {

			ContainerManger.service.updateOrganizationById(body);
			exchange.setStatusCode(StatusCodes.OK);
			output = ClassMapper.MAPPER.writeValueAsString(organization);
		}
		exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
		exchange.getResponseSender().send((output));

	}
}
