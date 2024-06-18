package com.springproject.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.course.entities.Category;
import com.springproject.course.services.CategoryService;

//Marca a classe como Resource, um endpoint para outras aplicações usarem

@RestController //Marca como um controlador REST
@RequestMapping(value = "/categories") //Mapeia o endereço para acessar os comandos dessa classe
public class CategoryResource {
	
	@Autowired //Faz automaricamente a injeção de dependência com o CategoryService
	CategoryService userService;
	
	@GetMapping //Mapeamento para o comando GET
	public ResponseEntity<List<Category>> findAll (){
		List<Category> userList = userService.findAll();
		return ResponseEntity.ok().body(userList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
