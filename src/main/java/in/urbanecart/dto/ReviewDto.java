package in.urbanecart.dto;

import java.util.Date;

import lombok.Data;
@Data
public class ReviewDto {
	 private Long id;
	    private int rating;
	    private String comment;
	    private Date date;
	    private String reviewerName;
	    private String reviewerEmail;
}
