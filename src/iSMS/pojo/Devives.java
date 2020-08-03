package iSMS.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Devives implements Serializable{
	
	private float dollarCost;
	private float eurocost=656;
	private float usdLivreSterling;
	private float usdnaira;
	private float usdyuan;
	private float usdeuro;
	private float usdxof;
	private float usdcad;
	private float usdzar; 
	private float usdaed;
	private float marge_devise;

	
	public Devives(){
		
	}
	
	
	
	public float getMarge_devise() {
		return marge_devise;
	}



	public void setMarge_devise(float marge_devise) {
		this.marge_devise = marge_devise;
	}



	public float getDollarCost() {
		return dollarCost;
	}
	public void setDollarCost(float dollarCost) {
		this.dollarCost = dollarCost;
	}
	public float getEurocost() {
		return eurocost;
	}
	public void setEurocost(float eurocost) {
		this.eurocost = eurocost;
	}
	public float getUsdLivreSterling() {
		return usdLivreSterling;
	}
	public void setUsdLivreSterling(float usdLivreSterling) {
		this.usdLivreSterling = usdLivreSterling;
	}
	public float getUsdnaira() {
		return usdnaira;
	}
	public void setUsdnaira(float usdnaira) {
		this.usdnaira = usdnaira;
	}
	public float getUsdyuan() {
		return usdyuan;
	}
	public void setUsdyuan(float usdyuan) {
		this.usdyuan = usdyuan;
	}
	public float getUsdeuro() {
		return usdeuro;
	}
	public void setUsdeuro(float usdeuro) {
		this.usdeuro = usdeuro;
	}
	public float getUsdxof() {
		return usdxof;
	}
	public void setUsdxof(float usdxof) {
		this.usdxof = usdxof;
	}

	public float getUsdcad() {
		return usdcad;
	}

	public void setUsdcad(float usdcad) {
		this.usdcad = usdcad;
	}

	public float getUsdzar() {
		return usdzar;
	}

	public void setUsdzar(float usdzar) {
		this.usdzar = usdzar;
	} 

	public float getUsdaed() {
		return usdaed;
	}

	public void setUsdaed(float usdaed) {
		this.usdaed = usdaed;
	} 
	
	
	
	
	

}
