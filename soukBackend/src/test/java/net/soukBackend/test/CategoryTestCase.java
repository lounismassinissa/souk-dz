package net.soukBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.soukBackend.dao.CategoryDAO;
import net.soukBackend.dto.Category;

public class CategoryTestCase {
	
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.soukBackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

/*
	@Test 
	public void testAddCategory(){
		category = new Category();
		category.setName("television");
		category.setDescription("television Thosom");
		category.setImageURL("Cat_1.png");
		assertEquals("Successfully add the category inside the table!", true, categoryDAO.add(category));
	}
	

	
	
	@Test
	public void testGetCategory(){
		category = categoryDAO.get(2);
		assertEquals("Successfully fetched a single category from the table!", "television", category.getName());

	
	@Test
	public void testUpdateCategory(){
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated a single category int the table!", true, categoryDAO.update(category));
	}
		}

	
	@Test
	public void testDeleteCategory(){
		category = categoryDAO.get(2);
		
		assertEquals("Successfully delete a single category int the table!", true, categoryDAO.delete(category));
	}
	

	@Test
	public void testListCategory(){
		
		
		assertEquals("Successfully fetched the list of  categories from the table!", 1, categoryDAO.list().size());
	}
	
	*/
	
	@Test
	public void testCRUDCategory(){
		
		// add test
		category = new Category();
		category.setName("Laptop");
		category.setDescription("Description laptop");
		category.setImageURL("Cat_1.png");
		assertEquals("Successfully add the category inside the table!", true, categoryDAO.add(category));
		
		category = new Category();
		category.setName("Television");
		category.setDescription("Description television");
		category.setImageURL("Cat_2.png");
		assertEquals("Successfully add the category inside the table!", true, categoryDAO.add(category));
		
		// fetching test
		category = categoryDAO.get(2);
		assertEquals("Successfully fetched a single category from the table!", "Television", category.getName());
		
		// update test
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully updated a single category int the table!", true, categoryDAO.update(category));
		
		// delete test
		category = categoryDAO.get(2);
		assertEquals("Successfully delete a single category int the table!", true, categoryDAO.delete(category));
		
		// list test
		assertEquals("Successfully fetched the list of  categories from the table!", 1, categoryDAO.list().size());
	}
	
	
}
