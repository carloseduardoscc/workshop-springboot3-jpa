package com.springproject.course.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Modelo de dominio com todo o mapeamento para banco de dados usado para o UserResource

//É importante sobrescrever HashCode e equals para o uso do framework

@Entity //Marca a classe como uma entidade
@Table( name = "tb_users" ) //renomeia a tabela como tb_users e não User por ser uma palavra reservada
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //Marca o atributo como chave primária
	@GeneratedValue( strategy = GenerationType.IDENTITY ) //Marca o auto-incremento no banco de dados ID: 1, 2, 3 ...
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public User() {}

	public User(Long id, String name, String email, String phone, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return id == other.id;
	}
	
}
