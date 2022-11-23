package repository;

import java.util.UUID;

import domain.Category;
import utils.JpaRespository;



public class CategoryRepository extends JpaRespository<Category, UUID>{

	public CategoryRepository() {
		super(Category.class);
	}
	
}