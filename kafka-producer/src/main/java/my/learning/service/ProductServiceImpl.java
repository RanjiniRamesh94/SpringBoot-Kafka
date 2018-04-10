package my.learning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.learning.model.Product;
import my.learning.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	
	Product product = new Product();

	@Override
	public List<Product> listAllProducts() {

		List<Product> allProducts = new ArrayList<Product>();

		allProducts = (List<Product>) productRepo.findAll();

		return allProducts;

	}

	/*@Override
	public Product getByProductId(int productId) {

	
		
		product = productRepo.findById(productId);

		return product;

	}*/

	@Override
	public String createProduct(Product request) {
		try {

			
			
			productRepo.save(request);
			System.out.println(request.getProductName());

			return "Created Successfully";

		}

		catch (Exception e) {

			return "Creation failed" + e.getMessage();
		}

	}

	/*@Override
	public String updateProduct(int productId, Product update) {

		product = productRepo.findById(productId);

		if (null == product) {

			return "Person ID not found in DB";

		}

		else {

			try {
				product.setProductName(update.getProductName());
				return "Resource updated Successfully";
			}

			catch (Exception e) {

				return "Updation Falied";

			}

		}

	}
*/
	@Override
	public String deleteProduct(int productId) {
		product = productRepo.findById(productId);

		if (null == product) {

			return "Person ID not found in DB";

		}

		else {

			try {
				productRepo.delete(product);
			}

			catch (Exception e) {

				return "Deletion Falied";

			}

			return "Product Deleted Successfully";

		}

	}

}
