package in.urbanecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.urbanecart.pojo.CategoryList;

public interface CategoryListRepository extends JpaRepository<CategoryList,String> {

}
