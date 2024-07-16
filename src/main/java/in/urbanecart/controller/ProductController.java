package in.urbanecart.controller;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.urbanecart.response.ResponseStructure;

import in.urbanecart.dto.ProductDto;
import in.urbanecart.pojo.Product;
import in.urbanecart.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping
    public ResponseEntity<Page<ProductDto>> getAllProducts(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "100") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        Sort sort = sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        // Get paginated products
        Page<Product> productPage = productService.findAll(pageable);

        // Convert to Page<ProductDto> using the service's method
        Page<ProductDto> productDtoPage = productPage.map(productService::convertToDto);

        return ResponseEntity.ok(productDtoPage);
    }


	

	
	

}
