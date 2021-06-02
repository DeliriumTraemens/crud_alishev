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
		people.add(new Person(++PEOPLE_COUNT,"Tom",24,"tom@mail.com"));
		people.add(new Person(++PEOPLE_COUNT,"Jack",34,"jack@mail.com"));
		people.add(new Person(++PEOPLE_COUNT,"James",35,"jamesom@mail.com"));
		people.add(new Person(++PEOPLE_COUNT,"Garry",47,"garry@mail.com"));
		people.add(new Person(++PEOPLE_COUNT,"Greg",49,"greg@mail.com"));
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
		Person  personToBeUpdated = show(id);
				personToBeUpdated.setId(id);
				personToBeUpdated.setName(updatedPerson.getName());
				personToBeUpdated.setAge(updatedPerson.getAge());
				personToBeUpdated.setEmail(updatedPerson.getEmail());
		
//		people.set(id-=1, personToBeUpdated);
		System.out.println(people);
	}
	
	public void delete(int id) {
		people.removeIf(p->p.getId()==id);
	
	}
}
