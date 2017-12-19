package com.networknt.Organization.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.networknt.Organization.Repository.OrganizationRepository;
import com.networknt.Organization.model.Organization;

public class OrganizationServiceImpl implements OrganizationService {

	@Override
	public ArrayList<Organization> getall() throws SQLException {
		// TODO Auto-generated method stub
		return OrganizationRepository.getAll();
	}

	@Override
	public Organization createLicense(Map<String, Object> MapOrganization) throws SQLException {
		// TODO Auto-generated method stub
		Organization newOrganization = new Organization(MapOrganization);
		return OrganizationRepository.create(newOrganization);
	}

	@Override
	public Organization getLicenseById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return OrganizationRepository.retrive(id);
	}

	@Override
	public void deleteLicenseById(String id) throws SQLException {
		// TODO Auto-generated method stub
		OrganizationRepository.delete(id);
	}

	@Override
	public Organization updateOrganizationById( Map<String, Object> bodyOrganization) throws SQLException {
		// TODO Auto-generated method stub
		Organization newOrganization = new Organization(bodyOrganization);
		return OrganizationRepository.update(newOrganization);
	}

}
