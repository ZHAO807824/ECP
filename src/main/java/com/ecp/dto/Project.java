package com.ecp.dto;

import java.io.Serializable;

import com.ecp.entity.home.Cart;

/**
 * 封装购物车
 * 
 * @User zhao
 *
 */
public class Project extends Cart implements Serializable {

	private static final long serialVersionUID = -408142496555998783L;

	public Project() {
	}

	public Project(Cart cart) {
		super(cart.getId(), cart.getBuyerId(), cart.getGoodId(), cart.getNumber());
	}

	public Project(Integer id, Integer buyerId, Integer goodId, Integer number) {
		super(id, buyerId, goodId, number);
	}

	private String name;

	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
