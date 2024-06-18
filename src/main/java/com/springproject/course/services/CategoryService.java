package com.springproject.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.course.entities.Category;
import com.springproject.course.repositories.CategoryRepository;

@Service //Marcado no Registro de componentes, para poder ser ligado como dependência por outras classes
//como no Autowired do CategoryRespository
public class CategoryService {
	
	@Autowired
	CategoryRepository userRepository;

	public List<Category> findAll(){
		return userRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = userRepository.findById(id);
		return obj.get();
	}
	
}
