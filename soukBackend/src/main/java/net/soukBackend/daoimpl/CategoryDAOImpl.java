package net.soukBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.soukBackend.dao.CategoryDAO;
import net.soukBackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	
	private static List<Category> categories = new ArrayList<Category>();
	static{
		Category category = new Category();
		category.setId(1);
		category.setName("television");
		category.setDescription("television Thosom");
		category.setImageURL("Cat_1.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("smartphone");
		category.setDescription("Smartphone");
		category.setImageURL("Cat_2.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("cables");
		category.setDescription("television Thosom");
		category.setImageURL("Cat_3.png");
		
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category:categories){
			if(category.getId() == id){
				return category;
			}
		}
		return null;
	}

}
