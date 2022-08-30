package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@SpringBootTest
class S02springdatajpaApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
	}

	@Test
	void saveProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);

		Product product = new Product();
		product.setName("headset");
		product.setDescription("Bluetooth headset");
		product.setPrice(2000);

		repo.save(product);

	}

	@Test
	void readProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);

		Optional<Product> optionalproduct = repo.findById(3);
		if (optionalproduct.isPresent()) {
			Product pro = optionalproduct.get();
			System.out.println(pro);

		}

	}

	@Test
	void deleteProduct() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		repo.deleteById(14);
		repo.deleteById(15);
	}
	
	@Test
	void findByName() {
		ProductRepository repo = context.getBean(ProductRepository.class);
		
		List<Product> products = repo.findByName("laptop");
		System.out.println(products);
	}
}