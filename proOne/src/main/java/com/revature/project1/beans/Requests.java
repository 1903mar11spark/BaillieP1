package com.revature.project1.beans;

import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;

public class Requests {
	
	private int requestId;
	private int employeeId;
	private int managedBy;
	private Date rqDate;
	private String rqType;
	private double rqAmt;
	private String status;
	private SerialBlob image;
	
	public Requests() {
		super();
		
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getManagedBy() {
		return managedBy;
	}

	public void setManagedBy(int managedBy) {
		this.managedBy = managedBy;
	}

	public Date getRqDate() {
		return rqDate;
	}

	public void setRqDate(Date rqDate) {
		this.rqDate = rqDate;
	}

	public String getRqType() {
		return rqType;
	}

	public void setRqType(String rqType) {
		this.rqType = rqType;
	}

	public double getRqAmt() {
		return rqAmt;
	}

	public void setRqAmt(double rqAmt) {
		this.rqAmt = rqAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Requests(int requestId, int employeeId, int managedBy, Date rqDate, String rqType, double rqAmt,
			String status) {
		super();
		this.requestId = requestId;
		this.employeeId = employeeId;
		this.managedBy = managedBy;
		this.rqDate = rqDate;
		this.rqType = rqType;
		this.rqAmt = rqAmt;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Requests [requestId=" + requestId + ", employeeId=" + employeeId + ", managedBy=" + managedBy
				+ ", rqDate=" + rqDate + ", rqType=" + rqType + ", rqAmt=" + rqAmt + ", status=" + status + "]";
	}

	public SerialBlob getImage() {
		return image;
	}

	public void setImage(SerialBlob image) {
		this.image = image;
	}
	
	

}
