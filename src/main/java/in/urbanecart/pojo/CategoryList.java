package in.urbanecart.pojo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CategoryList {
	@Id
	private String name;

}
