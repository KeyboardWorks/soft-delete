package keyboard.works;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import keyboard.works.entity.ProductCategory;
import keyboard.works.repository.ProductCategoryRepository;

@SpringBootTest
@Sql(scripts = { "/sql/delete-product-category.sql", "/sql/insert-product-category.sql" })
public class ProductCategoryRepositoryTest {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Test
	public void createProductCategory() {
		
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCode("Product Category Code");
		productCategory.setName("Product Category Name");
		
		productCategory = productCategoryRepository.save(productCategory);
		
		System.out.println(productCategory.getId());
		System.out.println(productCategory.getName());
		System.out.println(productCategory.getCode());
		
		assertNotNull(productCategory);
		assertNotNull(productCategory.getId());
		
	}
	
	@Test
	public void testQuerySoftDelete() {
		
		Long count = productCategoryRepository.count();
		
		assertEquals(1, count);
		
	}
	
	@Test
	public void testSoftDelete() {
		
		productCategoryRepository.deleteById("002");
		
		Long count = productCategoryRepository.count();
		
		assertEquals(0, count);
		
	}
	
}
