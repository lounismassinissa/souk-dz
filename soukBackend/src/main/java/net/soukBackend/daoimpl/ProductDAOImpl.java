package net.soukBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.soukBackend.dao.ProductDAO;
import net.soukBackend.dto.Category;
import net.soukBackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId) {
		try{
			return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> list() {
		Query query = sessionFactory.getCurrentSession().createQuery("From Product", Product.class);
		return query.getResultList();
	}

	@Override
	public boolean add(Product product) {
		try{
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		
		try{
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active= :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class);
		query.setParameter("active", true);
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(Category categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active= :active AND categoryId= :categoryID";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory, Product.class);
		query.setParameter("active", true);
		query.setParameter("categoryID", categoryId);
		return query.getResultList();
	}

	@Override
	public List<Product> getLastestActiveProducts(int count) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active= :active ORDER BY id", Product.class);
		query.setParameter("active", true);
		return query.setFirstResult(0).setMaxResults(count).getResultList();
	}

}
