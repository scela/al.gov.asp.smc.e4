package al.gov.asp.smc.e4.linkapp.model.outer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Person {
	
	private String firstName;
	private String lastName;
	private int age;
	private boolean married;
	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
			this);
	
	public Person(){
		this ("Sopot", "Cela", 23, false);
	}
	
	public Person(String firstName, String lastName, int age, boolean married) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.married = married;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	
	@Override
	public String toString() {
		
		return firstName+" "+lastName;
		
	}
	
	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

}
