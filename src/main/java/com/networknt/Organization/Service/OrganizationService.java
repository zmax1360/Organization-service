package com.networknt.Organization.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.networknt.Organization.model.Organization;

public interface OrganizationService {

	ArrayList<Organization> getall() throws SQLException;

	Organization createLicense(Map<String, Object> MapOrganization) throws SQLException;

	Organization getLicenseById(String organization) throws SQLException;

	void deleteLicenseById(String organization) throws SQLException;

	Organization updateOrganizationById(Map<String, Object> bodyOrganization) throws SQLException;
}
