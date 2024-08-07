package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Company;
import model.ModelException;
import model.Product;
import model.dao.CompanyDAO;
import model.dao.DAOFactory;
import model.dao.ProductDAO;



@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/product", "/product/form", "/product/insert", "/product/update", "/product/delete" })
public class ProductController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/CRUDManager/product/form": {
			loadCompanies(req);
			req.setAttribute("action", "insert");
			ControllerUtil.forward(req, resp, "/form-product.jsp");
			break;
		}
		case "/CRUDManager/product/update": {
			loadProduct(req);
			loadCompanies(req);
			req.setAttribute("action", "update");
			ControllerUtil.forward(req, resp, "/form-product.jsp");
			break;
		}
		default:
			listProduct(req);

			ControllerUtil.transferSessionMessagesToRequest(req);

			ControllerUtil.forward(req, resp, "/product.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getRequestURI();

		switch (action) {
		case "/CRUDManager/product/insert": {
			insertProduct(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/product");
			break;
		}
		case "/CRUDManager/product/update": {
			updateProduct(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/product");
			break;
		}
		case "/CRUDManager/product/delete": {
			deleteProduct(req);
			ControllerUtil.redirect(resp, req.getContextPath() + "/product");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}
	
	private void deleteProduct(HttpServletRequest req) {
		String productIdStr = req.getParameter("id");
		int productId = Integer.parseInt(productIdStr);

		String productNome = req.getParameter("entityName");

		ProductDAO dao = DAOFactory.createDAO(ProductDAO.class);

		try {
			if (dao.delete(new Product(productId))) {
				ControllerUtil.sucessMessage(req, "Produto '" + productNome + "' excluído com sucesso.");
			} else {
				ControllerUtil.errorMessage(req, "Produto '" + productNome + "' não pode ser excluído.");
			}
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}
	
	private void insertProduct(HttpServletRequest req) {

		Product product = createProduct(req, 0);

		ProductDAO dao = DAOFactory.createDAO(ProductDAO.class);

		try {
			if (dao.save(product))
				ControllerUtil.sucessMessage(req, "Produto " + product.getNome() + " salvo com sucesso.");
			else
				ControllerUtil.errorMessage(req, "Vendedor " + product.getNome() + " não pode ser salvo.");
		} catch (ModelException e) {
			e.printStackTrace(); // log
			ControllerUtil.errorMessage(req, e.getMessage());
		}
	}

	private void updateProduct(HttpServletRequest req) {

		String productIdStr = req.getParameter("product_id");
		int productId = Integer.parseInt(productIdStr);

		Product product = createProduct(req, productId);

		ProductDAO dao = DAOFactory.createDAO(ProductDAO.class);

		try {
			if (dao.update(product))
				ControllerUtil.sucessMessage(req, "Produto " + product.getNome() + " alterado com sucesso.");
			else
				ControllerUtil.errorMessage(req, "Produto " + product.getNome() + " não pode ser alterado.");
		} catch (ModelException e) {
			e.printStackTrace(); // log
			ControllerUtil.errorMessage(req, e.getMessage());
		}

	}
	
	
	private void loadProduct(HttpServletRequest req) {
		String productIdStr = req.getParameter("productId");
		int productId = Integer.parseInt(productIdStr);

		ProductDAO dao = DAOFactory.createDAO(ProductDAO.class);

		Product product = new Product(0);

		try {
			product = dao.findById(productId);
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar produto para edição.");
		}

		req.setAttribute("productToEdit", product);
	}
	
	
	private void loadCompanies(HttpServletRequest req) {
		CompanyDAO dao = DAOFactory.createDAO(CompanyDAO.class);
		List<Company> companies = new ArrayList<>();
		try {
			companies = dao.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar as empresas.");
		}
		req.setAttribute("companies", companies);
	}

	
	private void listProduct(HttpServletRequest req) {

		ProductDAO dao = DAOFactory.createDAO(ProductDAO.class);

		List<Product> products = new ArrayList<>();

		try {
			products = dao.listAll();
		} catch (ModelException e) {
			ControllerUtil.errorMessage(req, "Erro ao carregar dados dos produtos.");
		}

		req.setAttribute("products", products);
	}

	private Product createProduct(HttpServletRequest req, int productId) {

		String productNome = req.getParameter("product_nome");
		String productQuantidade = req.getParameter("product_quantidade");
		String productMarca = req.getParameter("product_marca");
		String productCompany = req.getParameter("product_company");
		int productCompanyId = Integer.parseInt(productCompany);

		Product product;
		if (productId == 0) {
			product = new Product();
		} else {
			product = new Product(productId);
		}
		product.setNome(productNome);
		product.setQuantidade(productQuantidade);
		product.setMarca(productMarca);
		product.setCompany(new Company(productCompanyId));

		return product;
	}
	
	
	
	
	
	
	
}




