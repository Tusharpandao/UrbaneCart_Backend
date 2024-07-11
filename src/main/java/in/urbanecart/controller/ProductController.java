package in.urbanecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.urbanecart.pojo.Product;
import in.urbanecart.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody List<Product> products) { // Accept a list of Product objects
	    for (Product product : products) {
	        Product savedProduct = productService.addProduct(product);
	        if (savedProduct == null) {
	            return new ResponseEntity<>("Product Not Added", HttpStatus.BAD_REQUEST);
	        }
	    }
	    return new ResponseEntity<>("Products Added Successfully", HttpStatus.OK);
	}
	
	
	

}
