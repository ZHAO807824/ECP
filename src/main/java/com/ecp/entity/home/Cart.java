package com.ecp.entity.home;

import java.io.Serializable;

public class Cart implements Serializable {

	private static final long serialVersionUID = -2502610743065669247L;

	private Integer id;
	private Integer buyerId;
	private Integer goodId;
	private Integer number;
	
	public Cart() {
	}

	public Cart(Integer id, Integer buyerId, Integer goodId, Integer number) {
		this.id = id;
		this.buyerId = buyerId;
		this.goodId = goodId;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", buyerId=" + buyerId + ", goodId=" + goodId + ", number=" + number + "]";
	}

}
