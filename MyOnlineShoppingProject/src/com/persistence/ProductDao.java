package com.persistence;

import java.sql.SQLException;
import java.util.List;

import com.bean.User;
import com.bean.*;

public interface ProductDao {
	
	public int SignUp(User user) throws ClassNotFoundException, SQLException;
	public int SignIn(User user) throws ClassNotFoundException, SQLException;
	List<Product> getAllProducts() throws ClassNotFoundException, SQLException;
	public Product getThisProduct(int productId) throws ClassNotFoundException, SQLException;
	
}
