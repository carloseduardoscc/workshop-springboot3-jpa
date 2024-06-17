package com.springproject.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.course.entities.Order;
import com.springproject.course.repositories.OrderRepository;

@Service //Marcado no Registro de componentes, para poder ser ligado como dependência por outras classes
//como no Autowired do OrderRespository
public class OrderService {
	
	@Autowired
	OrderRepository userRepository;

	public List<Order> findAll(){
		return userRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = userRepository.findById(id);
		return obj.get();
	}
	
}
