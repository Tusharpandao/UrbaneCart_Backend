package in.urbanecart.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMetaDto {
	  private Date createdAt;
	    private Date updatedAt;
	    private String barcode;
	    private String qrCode;
}
