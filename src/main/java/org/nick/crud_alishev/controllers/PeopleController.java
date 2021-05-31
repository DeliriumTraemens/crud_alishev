package org.nick.crud_alishev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
	
	
	@GetMapping()
	public String index(Model model){
//		Получим все элементы из ДАО, и передадим их в представление
		return null;
	}
	
	@GetMapping("{/id")
	public String show(@PathVariable("id") int id, Model model){
//		Получим Один элемент по его Id из Dao и передадим его в представление
		return null;
	}
	
}
