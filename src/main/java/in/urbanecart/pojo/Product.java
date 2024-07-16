package in.urbanecart.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Product {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	@Column(nullable=true)
	    private String title;
	 	@Column(nullable=true)
	    private String description;
	 	@Column(nullable=true)
	    private String category;
	    @Column(nullable=true)
	    private BigDecimal price;
	    @Column(nullable=true)
	    private BigDecimal discountPercentage;
	    private double rating;
	    @Column(nullable=true)
	    private int stock;
	    @ElementCollection // Use for a list of strings
	    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
	    @Column(name = "tag_name") // Column name in the product_tags table
	    private List<String> tags = new ArrayList<>();
	    private String brand;
	    private String sku;
	    private int weight;
	    @Embedded
	    private Dimension dimensions;
	    private String warrantyInformation;
	    private String shippingInformation;
	    private String availabilityStatus;
	    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
	    private List<Review> reviews = new ArrayList<>();
	    private String returnPolicy;
	    private int minimumOrderQuantity;
	    @Embedded
	    private ProductMeta meta;
	    @ElementCollection
	    private List<String> images = new ArrayList<>();
	    private String thumbnail;
	    
}
