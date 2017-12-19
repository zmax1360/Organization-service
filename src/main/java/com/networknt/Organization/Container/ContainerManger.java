package com.networknt.Organization.Container;

import javax.sql.DataSource;

import com.networknt.Organization.Service.OrganizationService;
import com.networknt.service.SingletonServiceFactory;

public class ContainerManger {

	public static final DataSource ds = (DataSource) SingletonServiceFactory.getBean(DataSource.class);
	public static OrganizationService service = SingletonServiceFactory.getBean(OrganizationService.class);
}
