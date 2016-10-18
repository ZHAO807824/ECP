package com.ecp.entity.home;

import java.io.Serializable;

public class Cart implements Serializable {

	private static final long serialVersionUID = -2502610743065669247L;

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", name=" + name + "]";
	}

}
