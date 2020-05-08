package it.contrader.dto;

public class ActivityDTO {
	
	private int id;    
	
	private String name;
	
	private int time;
	
	private int rest;
	
	public ActivityDTO() {   
		
	}
	
	public ActivityDTO (String name, int time, int rest) {  
		this.name = name;
		this.time = time;
		this.rest = rest;
		
	}
	
	public ActivityDTO (int id, String name, int time, int rest) {  
		this.id = id;
		this.name = name;
		this.time = time;
		this.rest = rest;
		
	}
	
	public int getId() {   //stiamo recuperando id di activity 
		return this.id;
	}
	public void setId(int id) {  // stiamo modificando il valore di id 
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTime() {
		return this.time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getRest() {
		return rest;
	}
	public void setRest(int rest) {
		this.rest = rest;
	}	
	@Override   //trasforma l'oggetto in un stringa
	public String toString() {
		return id + "\t"  + name + "\t\t" + time + "\t\t" + rest + "\t\t";
		
	}
}