package model.dao;

import java.util.List;

import model.ModelException;
import model.Seller;

public class MySQLSellerDAO implements SellerDAO {

	@Override
	public boolean save(Seller seller) throws ModelException {
		
		return false;
	}

	@Override
	public boolean uptade(Seller seller) throws ModelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Seller seller) throws ModelException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Seller> listAll() throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seller findById(int id) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}
			
}
