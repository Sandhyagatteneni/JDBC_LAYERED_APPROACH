package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Product;
import com.bean.ProductBillGeneration;
import com.bean.User;

public interface ProductService {
	public boolean SignUp(User user) throws ClassNotFoundException, SQLException;
	//public int SignIn(User user) throws ClassNotFoundException, SQLException;
	public boolean SignIn(User user) throws ClassNotFoundException, SQLException;
	List<Product> showAllProducts() throws ClassNotFoundException, SQLException;
	public Product showThisProduct(int productId) throws ClassNotFoundException, SQLException;
	public ProductBillGeneration generateBill(int productId) throws ClassNotFoundException, SQLException;
}
