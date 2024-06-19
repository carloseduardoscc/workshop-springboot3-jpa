package com.springproject.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springproject.course.entities.Category;
import com.springproject.course.entities.Order;
import com.springproject.course.entities.Product;
import com.springproject.course.entities.User;
import com.springproject.course.entities.enums.OrderStatus;
import com.springproject.course.repositories.CategoryRepository;
import com.springproject.course.repositories.OrderRepository;
import com.springproject.course.repositories.ProductRepository;
import com.springproject.course.repositories.UserRepository;

@Configuration // Marca a classe como de configuração
@Profile("test") // Usada quando o perfil é "test"
public class TestConfig implements CommandLineRunner {

	@Autowired // Injeção de dependência com o UserRepository
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception { // Configurações executadas automaticamente com o início da
														// aplicação

		// Seeding / população inicial do banco de dados usado
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		Order o1 = new Order(null, Instant.parse("2024-06-15T13:42:50Z"), OrderStatus.DELIVERED, u1);
		Order o2 = new Order(null, Instant.parse("2024-05-30T22:40:20Z"), OrderStatus.SHIPPED, u2);
		Order o3 = new Order(null, Instant.parse("2024-06-14T12:31:10Z"), OrderStatus.SHIPPED, u1);

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		userRepository.saveAll(Arrays.asList(u1, u2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	}

}
