package comcast.learning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comcast.learning.model.ProductQty;
import comcast.learning.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	
	ProductQty product = new ProductQty();

	@Override
	public List<ProductQty> listAllProducts() {

		List<ProductQty> allProducts = new ArrayList<ProductQty>();

		allProducts = (List<ProductQty>) productRepo.findAll();

		return allProducts;

	}

	/*@Override
	public Product getByProductId(int productId) {

	
		
		product = productRepo.findById(productId);

		return product;

	}*/

	/*@Override
	public String createProduct(ProductQty request) {
		try {

			System.out.println("In try block");
			
			productRepo.save(request);
			System.out.println(request.getProductName());

			return "Created Successfully";

		}

		catch (Exception e) {

			return "Creation failed" + e.getMessage();
		}

	}*/

	@Override
	public String updateProduct(int productId, ProductQty update) {

		product = productRepo.findById(productId);

		if (null == product) {

			return "Person ID not found in DB";

		}

		else {

			try {
				product.setProductQty(update.getProductQty());
				productRepo.save(product);
				return "Resource updated Successfully";
			}

			catch (Exception e) {

				return "Updation Falied";

			}

		}

	}

	/*@Override
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
*/
}
