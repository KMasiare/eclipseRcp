package kotleon;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Cat {
	private String name;
	private String gender;
	private Integer age;
	private String owner;
	
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	
	public Cat() {
		
	}

	public Cat(String name, String gender, Integer age, String owner) {
		super();
		this.setName(name);
		this.setGender(gender);
		this.setAge(age);
		this.setOwner(owner);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void addPropertyChangeListener (String propertyName,
		      PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(propertyName, listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
	    changeSupport.removePropertyChangeListener(listener);
	  }
	
	
}
