package in.urbanecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.urbanecart.pojo.Product;
import in.urbanecart.pojo.Review;
import in.urbanecart.repository.ProductRepository;
import in.urbanecart.repository.ReviewRepository;
@Service
public class ProductService {
	  @Autowired
	    private ProductRepository productRepository;
	    @Autowired
	    private ReviewRepository reviewRepository;



	    public Product addProduct(Product product) {

	        // 1. Save the Product first
	        Product savedProduct = productRepository.save(product); // Get the generated ID


	        // 3. Associate and save Reviews
	        for (Review review : product.getReviews()) {
	            review.setProduct(savedProduct); // Set the product reference
	            reviewRepository.save(review);
	        }

	        return savedProduct; 
	    }

}
