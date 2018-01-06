package com.synex.pool.beans;

import java.util.concurrent.atomic.AtomicInteger;

public class Cab {

	private String plateNo;
	private AtomicInteger capacity;
	private final int maxCapacity;
	private String location;

	public Cab(String plateNo, String location, int maxCapacity) {
		super();
		this.plateNo = plateNo;
		this.capacity = new AtomicInteger(0);
		this.location = location;
		this.maxCapacity = maxCapacity;
	}

	@Override
	public String toString() {
		return "Cab [plateNo=" + plateNo + ", capacity=" + capacity + ", maxCapacity=" + maxCapacity + ", location="
				+ location + "]";
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public AtomicInteger getCapacity() {
		return capacity;
	}

	public void setCapacity(AtomicInteger capacity) {

		if (capacity.intValue() <= this.maxCapacity) {
			this.capacity = capacity;
		} else {
			System.out.println("capacity exceeds!!!");
		}
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

}
