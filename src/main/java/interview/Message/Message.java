package interview.Message;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {
	@Id
	private String userId;
	private String currencyFrom;
	private String currencyTo;
	private double amountSell;
	private double amountBuy;
	private double rate;
	private String timePlaced;
	private String originatingCountry;
	
	public Message() { 
	}
	
	public Message(String userId, String currencyFrom, String currencyTo, double amountSell, double amountBuy, double rate, String timePlaced,
			String originatingCountry) {
		super();
		this.userId = userId;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.amountSell = amountSell;
		this.amountBuy = amountBuy;
		this.rate = rate;
		this.timePlaced = timePlaced;
		this.originatingCountry = originatingCountry;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCurrencyFrom() {
		return currencyFrom;
	}
	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}
	public String getCurrencyTo() {
		return currencyTo;
	}
	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}
	public double getAmountSell() {
		return amountSell;
	}
	public void setAmountSell(double amountSell) {
		this.amountSell = amountSell;
	}
	public double getAmountBuy() {
		return amountBuy;
	}
	public void setAmountBuy(double amountBuy) {
		this.amountBuy = amountBuy;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getTimePlaced() {
		return timePlaced;
	}
	public void setTimePlaced(String timePlaced) {
		this.timePlaced = timePlaced;
	}
	public String getOriginatingCountry() {
		return originatingCountry;
	}
	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}
	
	@Override
	public String toString(){
		return String.format("userId: "  + this.userId + "\n"
					+ "currencyFrom: " + this.currencyFrom + "\n"
					+ "currencyTo: " + this.currencyTo + "\n"
					+ "amountSell: " + this.amountSell + "\n"
					+ "amountBuy: " + this.amountBuy + "\n"
					+ "rate: " + this.rate + "\n"
					+ "timePlaced: " + this.timePlaced + "\n"
					+ "originatingCountry: " + this.originatingCountry);
	}
}
