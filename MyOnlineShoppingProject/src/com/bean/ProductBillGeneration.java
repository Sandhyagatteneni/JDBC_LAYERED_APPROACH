package com.bean;

public class ProductBillGeneration {
	double gst;
	double cgst;
	double sgst;
	double totalPrice;
	
	public ProductBillGeneration() {
		
	}

	public ProductBillGeneration(double gst, double cgst, double sgst, double totalPrice) {
		super();
		this.gst = gst;
		this.cgst = cgst;
		this.sgst = sgst;
		this.totalPrice = totalPrice;
	}

	public double getGst() {
		return gst;
	}

	public void setGst(double gst) {
		this.gst = gst;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ProductBillGeneration [gst=" + gst + ", cgst=" + cgst + ", sgst=" + sgst + ", totalPrice=" + totalPrice
				+ "]";
	}
	
	
}
