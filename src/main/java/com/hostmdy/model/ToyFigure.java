package com.hostmdy.model;

public class ToyFigure {

	private int id;
	private String name;
	private int spareParts;
	private boolean stand;
	private int price;
	
	public ToyFigure() {
		
	}


	public ToyFigure(String name, int spareParts, boolean stand, int price) {
		super();
		this.name = name;
		this.spareParts = spareParts;
		this.stand = stand;
		this.price = price;
	}



	public ToyFigure(int id, String name, int spareParts, boolean stand, int price) {
		super();
		this.id = id;
		this.name = name;
		this.spareParts = spareParts;
		this.stand = stand;
		this.price = price;
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


	@Override
	public String toString() {
		return "ToyFigure [id=" + id + ", name=" + name + ", spareParts=" + spareParts + ", stand=" + stand + ", price="
				+ price + "]";
	}



	
	
	
}
