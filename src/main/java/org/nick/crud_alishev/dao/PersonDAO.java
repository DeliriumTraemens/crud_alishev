package org.nick.crud_alishev.dao;

import org.nick.crud_alishev.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
	private static int PEOPLE_COUNT;
	private List<Person> people;
	{
		
		people = new ArrayList<>();
		people.add(new Person(++PEOPLE_COUNT,"Tom"));
		people.add(new Person(++PEOPLE_COUNT,"Jack"));
		people.add(new Person(++PEOPLE_COUNT,"James"));
		people.add(new Person(++PEOPLE_COUNT,"Garry"));
	}
	
	@Override
	public String toString() {
		return "PersonDAO{" +
				       "people=" + people +
				       '}';
	}
	
	public List<Person> index(){
		return people;
	}
	
	public Person show(int id){
		return people.stream().filter(person->person.getId()==id)/*Условие для фильтра - найти по id*/
				       .findAny()/*Найти если есть*/
				       .orElse(null);/*В случае отсутствия соответствия вернуть null*/
	
	}
	
	public void save(Person person) {
		person.setId(++PEOPLE_COUNT);
		people.add(person);
	}
	
	public void update(int id, Person updatedPerson) {
		Person personToBeUpdated = show(id);
		personToBeUpdated.setName(updatedPerson.getName());
		personToBeUpdated.setId(id);
//		people.set(id, personToBeUpdated);
		System.out.println(people);
	}
}
