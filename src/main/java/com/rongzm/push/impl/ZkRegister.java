package com.rongzm.push.impl;

public abstract class ZkRegister {
	private String name;
	private int weight;

	public ZkRegister(String name) {
		this(name, 0);
	}

	public ZkRegister(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
