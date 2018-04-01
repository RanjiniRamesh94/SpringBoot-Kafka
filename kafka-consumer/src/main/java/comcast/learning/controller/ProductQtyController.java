package comcast.learning.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comcast.learning.kafka.ConsumerApp;
import comcast.learning.kafka.Receiver;
import comcast.learning.model.Consumer;
import comcast.learning.model.ProductQty;
import comcast.learning.service.ProductServiceImpl;

@RestController
@RequestMapping("/store")
public class ProductQtyController {

	ProductQty product = new ProductQty();

	@Autowired
	ProductServiceImpl productServiceImpl;

	@GetMapping(value = "/listAllProducts")
	public List<ProductQty> listAllProducts() {

		List<ProductQty> allValues = new ArrayList<ProductQty>();

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

	

	
	  @PutMapping(value = "/product/{id}") public String
	  updateProduct(@PathVariable(value = "id") int productId, @RequestBody ProductQty
	  update) {
	 
		  Consumer consumer=new Consumer();
		  
		  String abc=consumer.getContent();
		  
		  if(abc.equalsIgnoreCase("create")) {
			  
			  update.setProductQty(update.getProductQty()+1);
		  }
		  
		  else {
			  update.setProductQty(update.getProductQty()-1);
			  
		  }
	 String response = productServiceImpl.updateProduct(productId, update);
	  
	  return response; }
	 

	 

}
