package com.booking.marraigehall.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int uid; //user id
	private int oid; // owner id
	private int hid; // hall id
	private String fd; //from date
	private String td; // to date
	private long days;
	private double amount;
	
	
	public Bookings() {
		super();
	}


	public Bookings(int uid, int oid, int hid, String from, String to, long days, double amount) {
		super();
		this.uid = uid;
		this.oid = oid;
		this.hid = hid;
		this.fd = from;
		this.td = to;
		this.days = days;
		this.amount = amount;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public int getHid() {
		return hid;
	}


	public void setHid(int hid) {
		this.hid = hid;
	}


	public String getFd() {
		return fd;
	}


	public void setFd(String from) {
		this.fd = from;
	}


	public String getTd() {
		return td;
	}


	public void setTd(String to) {
		this.td = to;
	}


	public long getDays() {
		return days;
	}


	public void setDays(long days) {
		this.days = days;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "Bookings [uid=" + uid + ", oid=" + oid + ", hid=" + hid + ", from=" + fd + ", to=" + td + ", days="
				+ days + ", amount=" + amount + "]";
	}
	
	
	
}
