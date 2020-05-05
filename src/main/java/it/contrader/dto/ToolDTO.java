package it.contrader.dto;

public class ToolDTO {

	// Proprieta'
	private int id;
	private String name;
	private String description;

	// Costruttori
	public ToolDTO() {
	}
	public ToolDTO (String name, String description) {
		this.name           = name;
		this.description    = description;
	}
	public ToolDTO (int id, String name, String description) {
		this.id             = id;
		this.name           = name;
		this.description    = description;
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

	// Trasformazione in stringa
	@Override
	public String toString() {
		return  id + "\t"  + name +"\t\t" + description;
	}
}
