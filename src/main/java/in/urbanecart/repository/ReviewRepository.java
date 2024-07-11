package in.urbanecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.urbanecart.pojo.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
