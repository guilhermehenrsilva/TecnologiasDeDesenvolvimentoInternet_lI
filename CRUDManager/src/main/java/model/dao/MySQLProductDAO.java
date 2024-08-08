package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.Company;
import model.ModelException;
import model.Product;


public class MySQLProductDAO implements ProductDAO {

	public boolean save (Product product) throws ModelException {
		
		DBHandler db = new DBHandler();
		
		String sqlInsert = "INSERT INTO product VALUES (DEFAULT, ?, ?, ?, ?)";
		
		db.prepareStatement(sqlInsert);
		
		db.setString(1, product.getNome());
		db.setString(2, product.getQuantidade());
		db.setString(3, product.getMarca());
		db.setInt(4, product.getCompany().getId());

		return db.executeUpdate() > 0;
	}
	
	@Override
	public boolean update(Product product) throws ModelException {

		DBHandler db = new DBHandler();

		String sqlUpdate = "UPDATE product SET nome = ?, quantidade = ?, marca = ?, company_id = ? where id = ?";

		db.prepareStatement(sqlUpdate);

		db.setString(1, product.getNome());
		db.setString(2, product.getQuantidade());
		db.setString(3, product.getMarca());
		db.setInt(4, product.getCompany().getId());
		db.setInt(5, product.getId());

		return db.executeUpdate() > 0;
	}
	
	@Override
	public boolean delete(Product product) throws ModelException {
		DBHandler db = new DBHandler();

		String sqlDelete = " DELETE FROM product WHERE ID = ?";

		db.prepareStatement(sqlDelete);
		db.setInt(1, product.getId());

		return db.executeUpdate() > 0;
	}
		
	@Override
	public List<Product> listAll() throws ModelException {

		DBHandler db = new DBHandler();

		List<Product> products = new ArrayList<Product>();
		// Declara uma instrução SQL
		String sqlQuery = "select p.id as ID, p.nome as Nome, p.quantidade as Quantidade, p.marca as Marca, c.id as company_id from product p inner join companies c on p.company_id = c.id";     

		db.createStatement();

		db.executeQuery(sqlQuery);

		while (db.next()) {
			Product p = createProduct(db);

			products.add(p);
		}

		return products;
	}
	
	@Override
	public Product findById(int id) throws ModelException {

		DBHandler db = new DBHandler();

		String sql = "SELECT * FROM product WHERE id = ?";

		db.prepareStatement(sql);

		db.setInt(1, id);
		db.executeQuery();

		Product p = null;

		while (db.next()) {
			p = createProduct(db);
			break;
		}

		return p;
	}
	
	private Product createProduct(DBHandler db) throws ModelException {
		Product p = new Product(db.getInt("id"));
		p.setNome(db.getString("nome"));
		p.setQuantidade(db.getString("quantidade"));
		p.setMarca(db.getString("marca"));

		CompanyDAO companyDAO = DAOFactory.createDAO(CompanyDAO.class);

		Company company = companyDAO.findById(db.getInt("company_id"));

		p.setCompany(company);

		return p;
	}
	
	}

