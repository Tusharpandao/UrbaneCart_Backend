package in.urbanecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.urbanecart.pojo.CategoryList;
import in.urbanecart.response.ResponseData;
import in.urbanecart.service.CategoryListServices;

@RestController
@RequestMapping("/products")
public class CategoryListController {
	@Autowired
	private CategoryListServices categoryListServices;
	
	@GetMapping("/category-list")
	public ResponseEntity<?> getCategories() {
		
	List<String> categories = categoryListServices.getCategories();

	if (categories != null && !categories.isEmpty()) {
		return new ResponseEntity<ResponseData<CategoryList>>
		(new ResponseData<CategoryList>("All categories found successfully",categories),HttpStatus.OK);
	}
	return new ResponseEntity<String>(new String("Category list not found"),HttpStatus.NOT_FOUND);
	}	
		
	
	
	@PostMapping("/add_category_list")
	public ResponseEntity<?> addCategory(@RequestBody List<CategoryList>categoryLists ) {
		List<String> savedcategories = categoryListServices.addCategories(categoryLists);

		if (savedcategories!= null && !savedcategories.isEmpty()) {
			return new ResponseEntity<ResponseData<CategoryList>>
			(new ResponseData<CategoryList>("All categories Added successfully",savedcategories),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<String>
		(new String("Categories not Added"),HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	
	

}
