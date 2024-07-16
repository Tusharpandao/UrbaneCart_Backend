package in.urbanecart.service;


import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.urbanecart.dto.DimensionDto;
import in.urbanecart.dto.ProductDto;
import in.urbanecart.dto.ProductMetaDto;
import in.urbanecart.dto.ReviewDto;
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



		public Page<Product> findAll(Pageable pageable) {
			
			return productRepository.findAll(pageable);
		}
		// Method to convert Product to ProductDto
	    public ProductDto convertToDto(Product product) {
	        ProductDto dto = new ProductDto();
	        dto.setId(product.getId());
	        dto.setTitle(product.getTitle());
	        dto.setDescription(product.getDescription());
	        dto.setCategory(product.getCategory());
	        // ... map other Product fields to the DTO
	        dto.setDimensions(new DimensionDto(
	                product.getDimensions().getWidth(),
	                product.getDimensions().getHeight(),
	                product.getDimensions().getDepth()
	        ));
	        dto.setMeta(new ProductMetaDto(
	                product.getMeta().getCreatedAt(),
	                product.getMeta().getUpdatedAt(),
	                product.getMeta().getBarcode(),
	                product.getMeta().getQrCode()
	        ));

	        dto.setTags(product.getTags());
	        dto.setBrand(product.getBrand());
	        dto.setSku(product.getSku());
	        dto.setWarrantyInformation(product.getWarrantyInformation());
	        dto.setShippingInformation(product.getShippingInformation());
	        dto.setAvailabilityStatus(product.getAvailabilityStatus());
	        dto.setReturnPolicy(product.getReturnPolicy());
	        dto.setMinimumOrderQuantity(product.getMinimumOrderQuantity());

	        // Map the reviews and convert each review to a ReviewDto
	        List<ReviewDto> reviewDtos = new ArrayList<>();
	        for (Review review : product.getReviews()) {
	            ReviewDto reviewDto = new ReviewDto();
	            reviewDto.setId(review.getId());
	            reviewDto.setRating(review.getRating());
	            reviewDto.setComment(review.getComment());
	            reviewDto.setDate(review.getDate());
	            reviewDto.setReviewerName(review.getReviewerName());
	            reviewDto.setReviewerEmail(review.getReviewerEmail());
	            reviewDtos.add(reviewDto);
	        }

	        // Set the reviews in the ProductDto
	        dto.setReviews(reviewDtos);

	        // set images and thumbnail
	        dto.setImages(product.getImages());
	        dto.setThumbnail(product.getThumbnail());


	        return dto;
	    }





		
		
		
		

}
