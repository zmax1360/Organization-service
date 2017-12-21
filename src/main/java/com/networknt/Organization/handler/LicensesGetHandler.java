package com.networknt.Organization.handler;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xnio.OptionMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.networknt.Organization.model.License;
import com.networknt.client.Http2Client;
import com.networknt.cluster.Cluster;
import com.networknt.config.Config;
import com.networknt.exception.ClientException;
import com.networknt.security.JwtHelper;
import com.networknt.server.Server;
import com.networknt.service.SingletonServiceFactory;

import io.undertow.UndertowOptions;
import io.undertow.client.ClientConnection;
import io.undertow.client.ClientRequest;
import io.undertow.client.ClientResponse;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.HttpString;
import io.undertow.util.Methods;

public class LicensesGetHandler implements HttpHandler {

	static String CONFIG_NAME = "api_organizations";
	static Logger logger = LoggerFactory.getLogger(LicensesGetHandler.class);
	static String apilicensesHost ="";
	static String apilicensesPath = (String) Config.getInstance().getJsonMapConfig(CONFIG_NAME)
			.get("api_licenses_path");
	static Cluster cluster = SingletonServiceFactory.getBean(Cluster.class);
	static Map<String, Object> securityConfig = (Map<String, Object>) Config.getInstance().getJsonMapConfig(JwtHelper.SECURITY_CONFIG);
	static boolean securityEnabled = (Boolean) securityConfig.get(JwtHelper.ENABLE_VERIFY_JWT);
	static Http2Client client = Http2Client.getInstance();
	static String tag = Server.config.getEnvironment();
	static ClientConnection connectionlicenses;

	public LicensesGetHandler() {
		try {
			apilicensesHost = cluster.serviceToUrl("https", "License_services-1.0.0", tag, null);
			connectionlicenses = client.connect(new URI(apilicensesHost), Http2Client.WORKER, Http2Client.SSL,
					Http2Client.POOL, OptionMap.create(UndertowOptions.ENABLE_HTTP2, true)).get();
		} catch (Exception e) {
			logger.error("Exeption:", e);
		}
	}

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		List<String> list = new ArrayList<>();
		if (connectionlicenses == null || !connectionlicenses.isOpen()) {
			try {
				connectionlicenses = client.connect(new URI(apilicensesHost), Http2Client.WORKER, Http2Client.SSL,
						Http2Client.POOL, OptionMap.create(UndertowOptions.ENABLE_HTTP2, true)).get();
			} catch (Exception e) {
				logger.error("Exeption:", e);
				throw new ClientException(e);
			}
		}
		final CountDownLatch latch = new CountDownLatch(1);
        final AtomicReference<ClientResponse> referencelicenses = new AtomicReference<>();
     
        try {
            ClientRequest requestlicenses = new ClientRequest().setMethod(Methods.GET).setPath(apilicensesPath);
            if(securityEnabled) client.propagateHeaders(requestlicenses, exchange);
            connectionlicenses.sendRequest(requestlicenses, client.createClientCallback(referencelicenses, latch));
            latch.await();
            int statusCodelicenses = referencelicenses.get().getResponseCode();
            if(statusCodelicenses >= 300){
                throw new Exception("Failed to call API B: " + statusCodelicenses);
            }
            List<String> apibList = Config.getInstance().getMapper().readValue(referencelicenses.get().getAttachment(Http2Client.RESPONSE_BODY),
                    new TypeReference<List<License>>(){});
        
            list.addAll(apibList);

          
        } catch (Exception e) {
            logger.error("Exception:", e);
            throw new ClientException(e);
        }
    	exchange.getResponseHeaders().add(new HttpString("Content-Type"), "application/json");
        exchange.getResponseSender().send(Config.getInstance().getMapper().writeValueAsString(list));
    

	}

}
