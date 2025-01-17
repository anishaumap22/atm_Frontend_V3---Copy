    package com.atm.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {
	@Id
    @Column(nullable = false)
    private String tranId;

    @Column(nullable = false)
    private int atmId;

    @Column(nullable = false)
    private int customerId;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String tranType;

    @Column(nullable = false)
    private String tranStatus;

    @Column(nullable = false)
    private String upiStatus;

    @Column(nullable = false)
    private LocalDateTime insertedOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

//    public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public int getAtmId() {
		return atmId;
	}

	public void setAtmId(int atmId) {
		this.atmId = atmId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getTranStatus() {
		return tranStatus;
	}

	public void setTranStatus(String tranStatus) {
		this.tranStatus = tranStatus;
	}

	public String getUpiStatus() {
		return upiStatus;
	}

	public void setUpiStatus(String upiStatus) {
		this.upiStatus = upiStatus;
	}

	public LocalDateTime getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(LocalDateTime insertedOn) {
		this.insertedOn = insertedOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, atmId, customerId, insertedOn, tranId, tranStatus, tranType, updatedOn, upiStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(atmId, other.atmId) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(insertedOn, other.insertedOn) && Objects.equals(tranId, other.tranId)
				&& Objects.equals(tranStatus, other.tranStatus) && Objects.equals(tranType, other.tranType)
				&& Objects.equals(updatedOn, other.updatedOn) && Objects.equals(upiStatus, other.upiStatus);
	}

	@Override
	public String toString() {
		return "Transaction1 [tranId=" + tranId + ", atmId=" + atmId + ", customerId=" + customerId + ", amount="
				+ amount + ", tranType=" + tranType + ", tranStatus=" + tranStatus + ", upiStatus=" + upiStatus
				+ ", insertedOn=" + insertedOn + ", updatedOn=" + updatedOn + "]";
	}

	public Transaction(String tranId, int atmId, int customerId, double amount, String tranType,
			String tranStatus, String upiStatus, LocalDateTime insertedOn, LocalDateTime updatedOn) {
		super();
		this.tranId = tranId;
		this.atmId = atmId;
		this.customerId = customerId;
		this.amount = amount;
		this.tranType = tranType;
		this.tranStatus = tranStatus;
		this.upiStatus = upiStatus;
		this.insertedOn = insertedOn;
		this.updatedOn = updatedOn;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setDate(LocalDateTime now) {
		// TODO Auto-generated method stub
		insertedOn = now;
	}

	
	

    // Getters and Setters
}


    
