package it.contrader.model;

public class Tool {

	// Proprieta'
	private int id;
	private String name;
	private String description;

	// Costruttori
	public Tool() {
	}
	public Tool (String name, String description) {
		this.name           = name;
		this.description    = description;
	}
	public Tool (int id, String name, String description) {
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

	// Metodo di confronto
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tool other = (Tool) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
}
