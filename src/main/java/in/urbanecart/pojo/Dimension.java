package in.urbanecart.pojo;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Dimension {

	 private double width;
	    private double height;
	    private double depth;
}
