package com.springproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.course.entities.Category;

//Interface que é implementada pelo Spring, e extende JpaRespository indicando o tipo da entidade, e o id
//e automaticamente é criada um repositório de acesso ao banco de dados
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
