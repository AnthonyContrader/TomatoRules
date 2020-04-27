package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Activity;


public class ActivityDAO {
	
	private final String QUERY_ALL = "SELECT * FROM activity";  //final atttributo che applichi alla classe. Devi eseguire questo comando
	private final String QUERY_CREATE = "INSERT INTO activity (name, time) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM activity WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE activity SET name=?, time=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM activity WHERE id=?";
	
	public ActivityDAO() {   //costruttore vuoto
		
	}
	
	public List<Activity> getAll() {  //metodo che prende tutto
		List<Activity> activityList = new ArrayList<>();  //inizializzo la lista
		Connection connection = ConnectionSingleton.getInstance(); //consente di istanziare gli oggetti uno per uno
		try {   //prova a farmi la QUERY_ALL
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Activity activity;
			while (resultSet.next()) {  //mentre c'è questo metodo(resultSet) devi fare (ottenere gli attributi)
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
	/* !!*/		int time = resultSet.getInt("time");
				activity = new Activity(name,time);
				activity.setId(id);  
 			    activityList.add(activity); //aggiungi ogni oggetto all'entita con queli attributi
			}
		} catch (SQLException e) {  //genera eccezioni
			e.printStackTrace();
		}
		return activityList;  //ritorna alla lista
		
	} 
    
	public boolean insert(Activity activityToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, activityToInsert.getName());
/* !!*/		preparedStatement.setInt(2, activityToInsert.getTime());
			preparedStatement.execute();
			return true;
	    } catch (SQLException e) {
	    	return false;
	    }
	
	}
	
	public Activity read(int activityId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, activityId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			
			String name = resultSet.getString("name");
			int time = resultSet.getInt("time");
			Activity activity = new Activity(name, time);
			activity.setId(resultSet.getInt("id"));
			
			return activity;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public boolean update(Activity activityToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		
		//Check if id is present
		if (activityToUpdate.getId() == 0)
			return false;
		
		Activity activityRead = read(activityToUpdate.getId());
		if (!activityRead.equals(activityToUpdate)) {
			try {
				// Fill the activityToUpdate object
				if (activityToUpdate.getName() == null || activityToUpdate.getName().equals("")) {
					activityToUpdate.setName(activityRead.getName());
				}
				
	/*!!*/		if (activityToUpdate.getTime() == 0 ) {  
					activityToUpdate.setTime(activityRead.getTime());
				}
				
				// Update the activity
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, activityToUpdate.getName());
				preparedStatement.setInt(2, activityToUpdate.getTime());
				preparedStatement.setInt(3, activityToUpdate.getId());
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
	
