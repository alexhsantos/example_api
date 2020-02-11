package com.products.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Rest Products")
@CrossOrigin(origins = "*")
public class ProductResource {
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value = "list all products stored in data base")
	public List<Product> list(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	@ApiOperation(value = "returns a product from an id")
	public Product get(@PathVariable(value="id") long id){
		return productRepository.findById(id);
	}
	
	@PostMapping("/product")
	@ApiOperation(value = "stores a product from a json")
	public Product store(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/product")
	@ApiOperation(value = "deletes a product from a json")
	public void delete(@RequestBody Product product) {	
		productRepository.delete(product);
	}
	
	@PutMapping("/product")
	@ApiOperation(value = "updates a product from a json")
	public Product update(@RequestBody Product product) {
		return productRepository.save(product);
	}
}
