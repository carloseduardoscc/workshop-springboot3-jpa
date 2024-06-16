package com.springproject.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.course.entities.User;
import com.springproject.course.services.UserService;

//Marca a classe como Resource, um endpoint para outras aplicações usarem

@RestController //Marca como um controlador REST
@RequestMapping(value = "/users") //Mapeia o endereço para acessar os comandos dessa classe
public class UserResource {
	
	@Autowired //Faz automaricamente a injeção de dependência com o UserService
	UserService userService;
	
	@GetMapping //Mapeamento para o comando GET
	public ResponseEntity<List<User>> findAll (){
		List<User> userList = userService.findAll();
		return ResponseEntity.ok().body(userList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
