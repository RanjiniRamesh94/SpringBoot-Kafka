package comcast.learning.service;

import java.util.List;

import comcast.learning.model.ProductQty;

public interface ProductService {

	public List<ProductQty> listAllProducts();

	/*//public Product getByProductId(int productId);

	public String createProduct(ProductQty request);*/

	public String updateProduct(int productId, ProductQty update);

	/*public String deleteProduct(int productId);*/

}
