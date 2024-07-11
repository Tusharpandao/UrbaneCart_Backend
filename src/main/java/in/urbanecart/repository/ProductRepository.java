package in.urbanecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.urbanecart.pojo.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
