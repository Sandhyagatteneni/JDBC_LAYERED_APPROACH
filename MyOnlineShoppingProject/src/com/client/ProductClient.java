package com.client;

import java.util.Scanner;

import com.presentation.ProductPresentation;
import com.presentation.ProductPresentationImpl;

public class ProductClient {
	public static void main(String[] args) {
		ProductPresentation productPresentation = new ProductPresentationImpl();
		productPresentation.showMenu();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Choice");
		int choice = sc.nextInt();
		productPresentation.performMenu(choice);
	}


}
