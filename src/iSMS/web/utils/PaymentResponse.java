package iSMS.web.utils;

import java.io.Serializable;

public class PaymentResponse implements Serializable{
	private Integer paymentId;
	private Integer paymentCode;
	private String paymentMessage;
	private String marchand;
	
	
	
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public Integer getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(Integer paymentCode) {
		this.paymentCode = paymentCode;
	}
	public String getPaymentMessage() {
		return paymentMessage;
	}
	public void setPaymentMessage(String paymentMessage) {
		this.paymentMessage = paymentMessage;
	}
	public String getMarchand() {
		return marchand;
	}
	public void setMarchand(String marchand) {
		this.marchand = marchand;
	}
	
	
}
