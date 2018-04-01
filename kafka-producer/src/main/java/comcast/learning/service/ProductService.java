package comcast.learning.service;

import java.util.List;

import comcast.learning.model.Product;

public interface ProductService {

	public List<Product> listAllProducts();

	//public Product getByProductId(int productId);

	public String createProduct(Product request);

	//public String updateProduct(int productId, Product update);

	public String deleteProduct(int productId);

}
