package com.springproject.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.course.entities.Order;
import com.springproject.course.services.OrderService;

//Marca a classe como Resource, um endpoint para outras aplicações usarem

@RestController //Marca como um controlador REST
@RequestMapping(value = "/orders") //Mapeia o endereço para acessar os comandos dessa classe
public class OrderResource {
	
	@Autowired //Faz automaricamente a injeção de dependência com o OrderService
	OrderService userService;
	
	@GetMapping //Mapeamento para o comando GET
	public ResponseEntity<List<Order>> findAll (){
		List<Order> userList = userService.findAll();
		return ResponseEntity.ok().body(userList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
