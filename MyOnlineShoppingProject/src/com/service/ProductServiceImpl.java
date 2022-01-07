package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Product;
import com.bean.ProductBillGeneration;
import com.bean.User;
import com.persistence.ProductDao;
import com.persistence.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();
	@Override
	public boolean SignUp(User user) throws ClassNotFoundException, SQLException {
		int rows=productDao.SignUp(user);
		if(rows>0)
			return true;
		else
			return false;		
	}

	@Override
	public boolean SignIn(User user) throws ClassNotFoundException, SQLException {
		int us=productDao.SignIn(user);
		 if(us>0)
		return true;
		 else
		return false;
	}

	@Override
	public List<Product> showAllProducts() throws ClassNotFoundException, SQLException {
	
		return productDao.getAllProducts();
	}

	@Override
	public Product showThisProduct(int productId) throws ClassNotFoundException, SQLException {
		
		return productDao.getThisProduct(productId);
	}

	@Override
	public ProductBillGeneration generateBill(int productId) throws ClassNotFoundException, SQLException {
		Product product = productDao.getThisProduct(productId);
		ProductBillGeneration productBillGeneration = null;
		if(product!=null) {
			double gst = product.getPrice()*0.18;
			double cgst = product.getPrice()*0.9;
			double sgst = product.getPrice()*0.9;
			double totalPrice = product.getPrice()+gst+cgst+sgst;
			productBillGeneration = new ProductBillGeneration(gst, cgst, sgst, totalPrice);
		}
		
		return productBillGeneration;
	}

}
