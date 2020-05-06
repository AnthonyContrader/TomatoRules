package it.contrader.dto;

public class CategoryDTO {

	private int id; 
	
	private String name;
	
	private String description; 
	
	private int idtool;

    public CategoryDTO() { 
    	
    }
    
    public CategoryDTO (String name, String description, int idtool) {
    	this.name = name;
    	this.description = description;
    	this.idtool = idtool;
    }
    
    public CategoryDTO (int id, String name, String description, int idtool) {
    	this.id = id;
    	this.name = name;
    	this.description= description;
    	this.idtool = idtool;
    }
    
    
    public int getId() {
    	return this.id;
     }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public String getName() {
    	return this.name;
    }
    public void setName(String name) {
    	this.name = name;
    	
    }
    public String getDescription() {
    	return this.description;
    }
    
    public void setDescription(String description) {
    	this.description = description;
    }
    
    public int getIdtool() {
    	return this.idtool;
    }
    
    public void setIdtool(int idtool) {
    	this.idtool = idtool;
    }
    
    @Override
    public String toString() {
    	return id + "\t" + name + "\t\t" + description + "\t\t" + idtool + "\t\t";
    }

}
