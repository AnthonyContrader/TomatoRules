package it.contrader.model;

public class Activity {
	
	//attributi
	private int id;    
	
	private String name;
	
	private int time;    //minuti
	
	/**
	 *  Definiamo i costruttori
	 */
	public Activity() {   //costruttore vuoto
		
	}
	
	public Activity (String name, int time) {  //costruttore senza id
		this.name = name;
		this.time = time;
		
	}
	
	public Activity (int id, String name, int time) {  //costruttore con id
		this.id = id;
		this.name = name;
		this.time = time;
	}
	
	/**
	 *  Metodi Getter e Setter: recuperano e modificano gli attributi
	 * @return
	 */
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
	
	@Override   //trasforma l'oggetto in un stringa
	public String toString() {
		return id + "\t"  + name + "\t\t" + time + "\t\t";
	}
	
	@Override   //confrontare gli oggetti in una stringa
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if(!name.equals(other.name))
			return false;
		
		if (time != other.time)    //chiedere!!
			return false;
		return true;
		
		}
	}


