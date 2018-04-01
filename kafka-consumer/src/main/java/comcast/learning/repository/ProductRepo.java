package comcast.learning.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comcast.learning.model.ProductQty;

public interface ProductRepo extends CrudRepository<ProductQty, Long> {

public List<ProductQty> findAll();
	
public ProductQty findById(int id);

}
