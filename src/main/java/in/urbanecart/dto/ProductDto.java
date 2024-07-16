package in.urbanecart.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
@Data
public class ProductDto {

	
	 private Long id;
	    private String title;
	    private String description;
	    private String category;
	    private BigDecimal price;
	    private BigDecimal discountPercentage;
	    private double rating;
	    private int stock;
	    private List<String> tags;  
	    private String brand;
	    private String sku;
	    private int weight;
	    private DimensionDto dimensions;
	    private String warrantyInformation;
	    private String shippingInformation;
	    private String availabilityStatus;
	    private String returnPolicy;
	    private int minimumOrderQuantity;
	    private ProductMetaDto meta; 
	    private List<String> images;
	    private String thumbnail;
	    private List<ReviewDto> reviews; 

}
