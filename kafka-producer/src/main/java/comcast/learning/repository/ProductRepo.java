package comcast.learning.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comcast.learning.model.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {

public List<Product> findAll();
	
public Product findById(int id);

}
