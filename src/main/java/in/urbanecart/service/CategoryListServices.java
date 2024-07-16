package in.urbanecart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanecart.pojo.Category;

import in.urbanecart.repository.CategoryListRepository;

import in.urbanecart.pojo.CategoryList;

@Service
public class CategoryListServices {
	@Autowired
	private CategoryListRepository categoryListRepository;

	public List<String> getCategories() {
		
		List<CategoryList> all = categoryListRepository.findAll();
		List<String> categoryList = new ArrayList<>();
		if (all != null && !all.isEmpty()) {
			
			for (CategoryList category : all) {
			    categoryList.add(category.getName());
			}
		}
		return categoryList ;
	}

	public List<String> addCategories(List<CategoryList> categoryLists) {
		
		List<CategoryList> saveAll = categoryListRepository.saveAll(categoryLists);
		
		List<String> categoryNames = new ArrayList<>();
		if (saveAll != null && !saveAll.isEmpty()) {
			
            for (CategoryList category : saveAll) {
                categoryNames.add(category.getName());
            }
			
		}
	
		return categoryNames;
	}

	
}
