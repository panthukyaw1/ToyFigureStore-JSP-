package com.hostmdy.model;

import java.sql.Date;

public class ToyFigure {

	private int id;
	private String name;
	private int spareParts;
	private boolean stand;
	private int price;
	private int quantity;
	private Date stockin;
	private String img;
	
	public ToyFigure() {
		
	}





	public ToyFigure(String name, int spareParts, boolean stand, int price, int quantity, Date stockin, String img) {
		super();
		this.name = name;
		this.spareParts = spareParts;
		this.stand = stand;
		this.price = price;
		this.quantity = quantity;
		this.stockin = stockin;
		this.img = img;
	}





	public ToyFigure(int id, String name, int spareParts, boolean stand, int price, int quantity, Date stockin,
			String img) {
		super();
		this.id = id;
		this.name = name;
		this.spareParts = spareParts;
		this.stand = stand;
		this.price = price;
		this.quantity = quantity;
		this.stockin = stockin;
		this.img = img;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpareParts() {
		return spareParts;
	}

	public void setSpareParts(int spareParts) {
		this.spareParts = spareParts;
	}

	public boolean getStand() {
		return stand;
	}

	public void setStand(boolean stand) {
		this.stand = stand;
	}
	
	

	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Date getStockin() {
		return stockin;
	}


	public void setStockin(Date stockin) {
		this.stockin = stockin;
	}



	@Override
	public String toString() {
		return "ToyFigure [id=" + id + ", name=" + name + ", spareParts=" + spareParts + ", stand=" + stand + ", price="
				+ price + ", quantity=" + quantity + ", stockin=" + stockin + ", img=" + img + "]";
	}


	
}
