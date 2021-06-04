package org.nick.crud_alishev.dao;

import org.nick.crud_alishev.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
	private static int PEOPLE_COUNT;
	
	private static final String URL = "jdbc:mysql://localhost:3306/spring_alishev";
	private static String USERNAME = "root";
	private static String PASSWORD ="12345";
	private static Connection connection;
	static{
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	
	public List<Person> index(){
		List<Person> people = new ArrayList<>();
		
//		Создаем переменную для запроса
		try {
			Statement statement = connection.createStatement();
			String SQL = "SELECT * FROM Person";
			ResultSet resultSet  = statement.executeQuery(SQL);
			
			while (resultSet.next()){
				Person person = new Person();
				person.setId(resultSet.getInt("id"));
				person.setName(resultSet.getString("name"));
				person.setAge(resultSet.getInt("age"));
				person.setEmail(resultSet.getString("email"));
				
				people.add(person);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return people;
	}
	
//	public Person show(int id){
////		return people.stream().filter(person->person.getId()==id)/*Условие для фильтра - найти по id*/
////				       .findAny()/*Найти если есть*/
////				       .orElse(null);/*В случае отсутствия соответствия вернуть null*/
//
//	}
	
	public void save(Person person) {
//		person.setId(++PEOPLE_COUNT);
//		people.add(person);
	}
	
	public void update(int id, Person updatedPerson) {
//		Person  personToBeUpdated = show(id);
//				personToBeUpdated.setId(id);
//				personToBeUpdated.setName(updatedPerson.getName());
//				personToBeUpdated.setAge(updatedPerson.getAge());
//				personToBeUpdated.setEmail(updatedPerson.getEmail());
//
////		people.set(id-=1, personToBeUpdated);
//		System.out.println(people);
	}
	
	public void delete(int id) {
//		people.removeIf(p->p.getId()==id);
	
	}
}
