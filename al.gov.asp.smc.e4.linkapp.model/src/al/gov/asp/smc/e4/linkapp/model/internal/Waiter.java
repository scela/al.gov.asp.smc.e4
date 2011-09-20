package al.gov.asp.smc.e4.linkapp.model.internal;
import java.util.ArrayList;
import java.util.List;

import al.gov.asp.smc.e4.linkapp.model.outer.IPublic;
import al.gov.asp.smc.e4.linkapp.model.outer.Person;


public class Waiter implements IPublic {

	private List<Person> persons = new ArrayList<Person>();
	private Person person;
	public Waiter() {
		persons.clear();
		persons.add(new Person("Sopot","Cela",23,false));
		persons.add(new Person("Ervina","Gjana",22,true));
		persons.add(new Person("Enid","Gjoleka",24,false));
		persons.add(new Person("Kali","Pela",12,true));
	}
	
	@Override
	public List<Person> getPersons() {
		
		return persons;
		
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public void clear() {
		
		persons.clear();
		
	}

}
