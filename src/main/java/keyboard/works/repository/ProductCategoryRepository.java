package keyboard.works.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import keyboard.works.entity.ProductCategory;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, String> {

}
