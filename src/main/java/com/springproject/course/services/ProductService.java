package com.springproject.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.course.entities.Product;
import com.springproject.course.repositories.ProductRepository;

@Service //Marcado no Registro de componentes, para poder ser ligado como dependência por outras classes
//como no Autowired do ProductRespository
public class ProductService {
	
	@Autowired
	ProductRepository userRepository;

	public List<Product> findAll(){
		return userRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = userRepository.findById(id);
		return obj.get();
	}
	
}
