package com.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bean.Product;
import com.bean.User;
import com.helper.OracleConnection;
import com.service.ProductService;

public class ProductDaoImpl implements ProductDao {
	int count=0;
	@Override
	public int SignUp(User user) throws ClassNotFoundException, SQLException {
		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER(USERNAME, PASSWORD) VALUES (?, ?)");
		preparedStatement.setString(1, user.getUserName());
		preparedStatement.setString(2, user.getPassWord());
		int rows = preparedStatement.executeUpdate();
		return rows;
	}

	@Override
	public int SignIn(User user) throws ClassNotFoundException, SQLException {
		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT USERNAME, PASSWORD FROM USERS WHERE USERNAME = ? AND PASSWORD = ?");
		preparedStatement.setString(1, user.getUserName());
		preparedStatement.setString(2, user.getPassWord());
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			String username = resultSet.getString("USERNAME");
			System.out.println("\nWELCOME "+ username+"\n");
			count++;
		}
		if(count>0) 
			return 1;
		else
		return -1;
	}

	@Override
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		List<Product> productList = new ArrayList<Product>();

		Connection connection = OracleConnection.getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT");
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			int id = resultSet.getInt("ID");
			String code = resultSet.getString("CODE");
			String name = resultSet.getString("NAME");
			String description = resultSet.getString("DESCRIPTION");
			double price = resultSet.getDouble("PRICE");
			
			Product product=new Product(id, code, name, description, price);
			productList.add(product);
		}

		connection.close();

		return productList;
	}

	@Override
	public Product getThisProduct(int productId) throws ClassNotFoundException, SQLException {
		Product product = null;
		Connection connection = OracleConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE ID = ?");
		preparedStatement.setInt(1, productId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			int pId = resultSet.getInt("ID");
			String pCode = resultSet.getString("CODE");
			String pName = resultSet.getString("NAME");
			String pDescription = resultSet.getString("DESCRIPTION");
			double pPrice = resultSet.getDouble("PRICE");
			
			product = new Product(pId, pCode, pName, pDescription, pPrice);
		}
		connection.close();
		
		return product;
	}

}
