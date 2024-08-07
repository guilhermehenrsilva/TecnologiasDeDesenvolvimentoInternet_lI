package model.dao;

import java.util.List;

import model.ModelException;
import model.Product;


public interface ProductDAO {

	boolean save(Product product) throws ModelException;

	boolean update(Product product) throws ModelException;

	boolean delete(Product product) throws ModelException;

	List<Product> listAll() throws ModelException;

	Product findById(int id) throws ModelException;
}


