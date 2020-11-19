package org.com.productMang;

import org.com.productMang.dao.ProductRepository;
import org.com.productMang.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProductMangApplication implements CommandLineRunner {
   @Autowired
	private ProductRepository productRepository;
   @Autowired
   private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(ProductMangApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		productRepository.save(new Product(null,"ORDINATEUR",1200,5));
		productRepository.save(new Product(null,"SMARTPHONE",600,10));
		productRepository.save(new Product(null,"IMPRIMANTE",300,15));
		productRepository.save(new Product(null,"TV",300,15));
		productRepository.save(new Product(null,"MACHINE",300,15));
		productRepository.findAll().forEach(p->{
			System.out.println(p.getDesignation());
		});

	}
}
