package comcast.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comcast.learning.kafka.KafkaSender;
import comcast.learning.model.Product;
import comcast.learning.service.ProductServiceImpl;

@RestController
@RequestMapping("/store")
public class ProductController {

	Product product = new Product();

	@Autowired
	ProductServiceImpl productServiceImpl;

	@GetMapping(value = "/listAllProducts")
	public List<Product> listAllProducts() {

		List<Product> allValues = new ArrayList<Product>();

		allValues = productServiceImpl.listAllProducts();

		return allValues;

	}

	/*
	 * @GetMapping(value = "/product/{id}") public Product
	 * getByProductId(@PathVariable(value = "id") int productId) {
	 * 
	 * product = productServiceImpl.getByProductId(productId);
	 * 
	 * return product;
	 * 
	 * }
	 */

	@PostMapping(value = "/product")
	public String createProduct(@RequestBody Product request) {

		System.out.println("ProductName :  " + request.getProductName() + request.getId());

		String response = productServiceImpl.createProduct(request);

		KafkaSender kafkaSender = new KafkaSender();

		kafkaSender.send("create");

		return response;

	}

	/*
	 * @PutMapping(value = "/product/{id}") public String
	 * updateProduct(@PathVariable(value = "id") int productId, @RequestBody Product
	 * update) {
	 * 
	 * String response = productServiceImpl.updateProduct(productId, update);
	 * 
	 * return response; }
	 */

	@DeleteMapping(value = "/product/{id}")
	public String deletePerson(@PathVariable(value = "id") int productId) {

		String response = productServiceImpl.deleteProduct(productId);
		KafkaSender kafkaSender = new KafkaSender();

		kafkaSender.send("delete");
		return response;

	}

}
