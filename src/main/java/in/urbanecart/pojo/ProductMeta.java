package in.urbanecart.pojo;

import java.util.Date;

//import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ProductMeta {

	 private Date createdAt;
	    private Date updatedAt;
	    private String barcode;
	    private String qrCode;
//	    @Column(columnDefinition = "json")
//	    private String additionalData;
}
