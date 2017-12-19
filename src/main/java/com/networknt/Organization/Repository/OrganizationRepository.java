package com.networknt.Organization.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.networknt.Organization.Container.ContainerManger;
import com.networknt.Organization.model.Organization;

public class OrganizationRepository {
	public static ArrayList<Organization> getAll() throws SQLException {
		ArrayList<Organization> listOrganization = new ArrayList<>();
		try (Connection dbConnection = ContainerManger.ds.getConnection()) {
			String sql = "select * from Organization";
			Statement st = dbConnection.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Organization l = new Organization(rs.getString("id"), rs.getString("name"), rs.getString("contactName"),
						rs.getString("contactPhone"), rs.getString("contactEmail"));
				listOrganization.add(l);
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return listOrganization.size() > 0 ? listOrganization : null;
	}

	public static Organization retrive(String Id) throws SQLException {
		ArrayList<Organization> listOrganization = new ArrayList<>();
		String sql = "select * FROM Organization where id = ?";
		try (Connection dbConnection = ContainerManger.ds.getConnection();
				PreparedStatement query = dbConnection.prepareStatement(sql)) {
			query.setString(1, Id);

			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				Organization l = new Organization(rs.getString("id"), rs.getString("name"), rs.getString("contactName"),
						rs.getString("contactPhone"), rs.getString("contactEmail"));
				listOrganization.add(l);
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return listOrganization.size() > 0 ? listOrganization.get(0) : null;
	}

	public static void delete(String Id) throws SQLException {
		String sql = "DELETE FROM Organization where id = ?";
		try (Connection dbConnection = ContainerManger.ds.getConnection();
				PreparedStatement query = dbConnection.prepareStatement(sql)) {

			query.setString(1, Id);

			query.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public static Organization create(Organization organization) throws SQLException {
		String sql = "INSERT INTO Organization(id ,name ,contactName ,contactPhone ,contactEmail)  VALUES (?,?,?,?,?)";
		try (Connection dbConnection = ContainerManger.ds.getConnection();
				PreparedStatement query = dbConnection.prepareStatement(sql)) {

			query.setString(1, organization.getId());
			query.setString(2, organization.getName());
			query.setString(3, organization.getContactName());
			query.setString(4, organization.getContactPhone());
			query.setString(5, organization.getContactEmail());

			query.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return retrive(organization.getId());

	}

	public static Organization update(Organization organization) throws SQLException {
		String sql = "update Organization  and name =? and contactName = ? and contactPhone = ? and contactEmail = ? where id =? ";
		try (Connection dbConnection = ContainerManger.ds.getConnection();
				PreparedStatement update = dbConnection.prepareStatement(sql)) {

			update.setString(1, organization.getName());
			update.setString(2, organization.getContactName());
			update.setString(3, organization.getContactPhone());
			update.setString(4, organization.getContactEmail());
			update.setString(5, organization.getId());
			update.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return retrive(organization.getId());

	}

}
