package org.nick.crud_alishev.controllers;

import org.nick.crud_alishev.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
	
	/*Autowired заменен на подключение (внедрение) бина класса personDAO через конструктор*/
	private final PersonDAO personDAO;/*Объявили класс*/
//	И передали его в качестве параметра конструктора текущего класса
	public PeopleController(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	@GetMapping()
	public String index(Model model){
//		Получим все элементы из ДАО, и передадим их в представление
//		В параметрах атрибута в кавычках то имя, которое передается в модель;
//		после запятой указывается метод(источник данных для данной переменной)
//		в данном случае в переменную "people" передается список, возвращаемый методом индекс
		model.addAttribute("people", personDAO.index());
		return "people/index";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model){
//		Получим Один элемент по его Id из Dao и передадим его в представление
		model.addAttribute("person",personDAO.show(id));
		return "people/show";
	}
	
	
}
