package com.presentation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.bean.Product;
import com.bean.ProductBillGeneration;
import com.bean.User;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class ProductPresentationImpl implements ProductPresentation {
	ProductService productService = new ProductServiceImpl();
	Scanner sc = new Scanner(System.in);
	int productId;
	@Override
	public void showMenu() {
		System.out.println("\n1.SignIn/SignUp");
		System.out.println("2.Show Products");
		System.out.println("3.Buy Products");
		System.out.println("4.Generate Bill\n");
	}

	@Override
	public void performMenu(int choice) {
		switch(choice) {
		case 1: 
			System.out.println("\n1.SignIn\n2.SignUp");
			System.out.println("Enter your choice : ");
			int choice1 = sc.nextInt();
			if(choice1 == 1) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter User Name : ");
				String userName = sc.next();
				System.out.println("Enter Password : ");
				String passWord = sc.next();
				User user = new User(userName, passWord);
				try {
					if(productService.SignIn(user)) {
						System.out.println("User Login Successful");
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(choice1 == 2) {
					System.out.println("Enter Your Name : ");
					String username = sc.next();
					System.out.println("Enter Your Password : ");
					String password = sc.next();
					User user = new User(username, password);
					try {
						if(productService.SignUp(user)) 
							System.out.println("User Registered Successfully");
							
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						System.out.println("Something Went Wrong");
					}
				}
			this.showMenu();
			System.out.println("Enter your choice : ");
			int choice2 = sc.nextInt();
			this.performMenu(choice2);
			break;
		case 2:
			try {
			List<Product> productList = productService.showAllProducts();
			for(Product product: productList) {
				System.out.println(product);
			}
		} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Something Went Wrong");
			}
			this.showMenu();
			System.out.println("Enter your choice : ");
			int choice3 = sc.nextInt();
			this.performMenu(choice3);
			break;
		case 3:
			try {
				System.out.println("Enter Product ID to select");
				productId =sc.nextInt();
				Product product = productService.showThisProduct(productId);
				if(product!=null)
					System.out.println(product);
				else
					System.out.println("Employee with id "+productId+" does not exist");
			}
			catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			this.showMenu();
			System.out.println("Enter your choice : ");
			int choice4 = sc.nextInt();
			this.performMenu(choice4);
			break;
		case 4 :
			try {
			System.out.println("Bill Generation Successful");
			ProductBillGeneration productBillGeneration = productService.generateBill(productId);
			if(productBillGeneration != null)
				System.out.println(productBillGeneration);
			else
				System.out.println("The Product "+productId+" is not available");
			} 
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Something Went Wrong");
			}
			this.showMenu();
			System.out.println("Enter your choice : ");
			int choice5 = sc.nextInt();
			this.performMenu(choice5);
			break;
		default : System.out.println("Invalid choice. Choose the available options");
		this.showMenu();
		System.out.println("Enter your choice : ");
		int choice6 = sc.nextInt();
		this.performMenu(choice6);
		}
		
	}


}
