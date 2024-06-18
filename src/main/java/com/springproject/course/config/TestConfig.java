package com.springproject.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springproject.course.entities.Order;
import com.springproject.course.entities.User;
import com.springproject.course.entities.enums.OrderStatus;
import com.springproject.course.repositories.OrderRepository;
import com.springproject.course.repositories.UserRepository;

@Configuration //Marca a classe como de configuração
@Profile("test") //Usada quando o perfil é "test"
public class TestConfig implements CommandLineRunner{

	@Autowired //Injeção de dependência com o UserRepository
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception { //Configurações executadas automaticamente com o início da aplicação
		
		//Seeding / população inicial do banco de dados usado
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2024-06-15T13:42:50Z"), OrderStatus.DELIVERED, u1);
		Order o2 = new Order(null, Instant.parse("2024-05-30T22:40:20Z"), OrderStatus.SHIPPED, u2);
		Order o3 = new Order(null, Instant.parse("2024-06-14T12:31:10Z"), OrderStatus.SHIPPED, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
}
