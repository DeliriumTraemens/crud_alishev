package org.nick.crud_alishev.dao;

import org.nick.crud_alishev.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
	
//	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_alishev");
		dataSource.setUsername("root");
		dataSource.setPassword("12345");
		return dataSource;
		
	}
	
//	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
	
	
	
//	private static int PEOPLE_COUNT;
	
	
	

	
	public List<Person> index(){
		List<Person> people = new ArrayList<>();
		
//		Создаем переменную для запроса
		try {
			Statement statement = connection.createStatement();
			String SQL = "SELECT * FROM Person";
//			executeQuery только получает запрошенные данные из базы, не изменяет данные
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
	
	
	public Person show(int id) {
		Person person = null/*new Person()*/;
		
		try {
			PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM Person WHERE id=?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			
			
			person = new Person();
			
			person.setId(resultSet.getInt("id"));
			person.setName(resultSet.getString("name"));
			person.setEmail(resultSet.getString("email"));
			person.setAge(resultSet.getInt("age"));
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		return person;
	}
	
	
	public void save(Person person) {
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("INSERT INTO Person VALUES (1,?,?,?)");
			preparedStatement.setString(1, person.getName());
			preparedStatement.setInt(2,person.getAge());
			preparedStatement.setString(3,person.getEmail());
					preparedStatement.executeUpdate();
			
			
//
			
		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	public void update(int id, Person updatedPerson) {
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");
				preparedStatement.setString(1,updatedPerson.getName());
				preparedStatement.setInt(2,updatedPerson.getAge());
				preparedStatement.setString(3,updatedPerson.getEmail());
				preparedStatement.setInt(4,id);
			
			preparedStatement.executeUpdate();
		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			PreparedStatement preparedStatement =
					connection.prepareStatement("DELETE FROM Person WHERE id=?");
						preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		}
		catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
}
