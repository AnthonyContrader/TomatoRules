package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Tool;

public class ToolDAO implements DAO<Tool> {

	// Istruzioni SQL
	private final String QUERY_ALL      =    "SELECT * FROM tool";
	private final String QUERY_CREATE   =      "INSERT INTO tool (name, description) VALUES (?,?)";
	private final String QUERY_READ     =    "SELECT * FROM tool WHERE id=?";
	private final String QUERY_UPDATE   =           "UPDATE tool SET name=?, description=? WHERE id=?";
	private final String QUERY_DELETE   =      "DELETE FROM tool WHERE id=?";

	// Costruttori
	public ToolDAO() {
	}

	// Istruzioni per l'utilizzo dei dati
	public List<Tool> getAll() {
		List<Tool> toolsList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Tool tool;
			while (resultSet.next()) {
				int    id           = resultSet.getInt("id");
				String name         = resultSet.getString("name");
				String description  = resultSet.getString("description");
				tool = new Tool(name, description);
				tool.setId(id);
				toolsList.add(tool);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toolsList;
	}
	public boolean insert(Tool toolToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, toolToInsert.getName());
			preparedStatement.setString(2, toolToInsert.getDescription());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	public Tool read(int toolId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, toolId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String name, description;
			name        = resultSet.getString("name");
			description = resultSet.getString("description");
			Tool tool   = new Tool(name, description);
			tool.setId(resultSet.getInt("id"));
			return tool;
		} catch (SQLException e) {
			return null;
		}
	}
	public boolean update(Tool toolToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if (toolToUpdate.getId() == 0)
			return false;
		Tool toolRead = read(toolToUpdate.getId());
		if (!toolRead.equals(toolToUpdate)) {
			try {
				if (toolToUpdate.getName() == null || toolToUpdate.getName().equals("")) {
					toolToUpdate.setName(toolRead.getName());
				}
				if (toolToUpdate.getDescription() == null || toolToUpdate.getDescription().equals("")) {
					toolToUpdate.setDescription(toolRead.getDescription());
				}
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, toolToUpdate.getName());
				preparedStatement.setString(2, toolToUpdate.getDescription());
				preparedStatement.setInt   (3, toolToUpdate.getId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}
}
