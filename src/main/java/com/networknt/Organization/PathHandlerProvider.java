
package com.networknt.Organization;

import com.networknt.config.Config;
import com.networknt.server.HandlerProvider;
import io.undertow.Handlers;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Methods;
import com.networknt.info.ServerInfoGetHandler;
import com.networknt.health.HealthGetHandler;
import com.networknt.Organization.handler.*;

public class PathHandlerProvider implements HandlerProvider {
    @Override
    public HttpHandler getHandler() {
        return Handlers.routing()
        
            .add(Methods.POST, "/v1/organizations", new OrganizationsPostHandler())
        
            .add(Methods.GET, "/v1/organizations", new OrganizationsGetHandler())
        
            .add(Methods.GET, "/v1/health", new HealthGetHandler())
        
            .add(Methods.GET, "/v1/server/info", new ServerInfoGetHandler())
        
            .add(Methods.GET, "/v1/organizations/{id}", new OrganizationGetByIdHandler())
        
            .add(Methods.DELETE, "/v1/organizations/{id}", new OrganizationDeleteByIdHandler())
        
            .add(Methods.PUT, "/v1/organizations/{id}", new OrganizationPutByIdHandler())
            
            .add(Methods.PUT, "/v1/licenses", new LicensesGetHandler())
        
        ;
    }
}
