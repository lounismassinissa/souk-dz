package net.soukBackend.dao;

import java.util.List;

import net.soukBackend.dto.Category;
import net.soukBackend.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	// business methodes
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(Category categoryId);
	List<Product> getLastestActiveProducts(int count);


}
