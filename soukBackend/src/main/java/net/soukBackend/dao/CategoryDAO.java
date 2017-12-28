package net.soukBackend.dao;

import java.util.List;

import net.soukBackend.dto.Category;

public interface CategoryDAO {
	
	
	List<Category> list();
	Category get(int id);

}
