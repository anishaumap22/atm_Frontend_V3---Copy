 package com.atm.entities;

import java.util.Objects;

import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;

public class Withdraw {
	private String cardNo;
	private double money;
	private int cardPin;
	
	
	//Parameterized constructor
	public Withdraw(String cardNo, double money, int cardPin) {
		super();
		this.cardNo = cardNo;
		this.money = money;
		this.cardPin = cardPin;
	}
	
	//default constructor
	public Withdraw() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Getter setter
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getCardPin() {
		return cardPin;
	}
	public void setCardPin(int cardPin) {
		this.cardPin = cardPin;
	}
	
	//eguals & hashcode
	@Override
	public int hashCode() {
		return Objects.hash(cardNo, cardPin, money);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Withdraw other = (Withdraw) obj;
		return Objects.equals(cardNo, other.cardNo) && cardPin == other.cardPin
				&& Double.doubleToLongBits(money) == Double.doubleToLongBits(other.money);
	}

	@Override
	public String toString() {
		return "Withdraw [cardNo=" + cardNo + ", money=" + money + ", cardPin=" + cardPin + "]";
	}	
	
}
