package model;

public class Currency {
	private String name;
	private String code;
	private double exchangeRate;
	private double converter;

	public Currency(String name, String code, double exchangeRate, double converter) {
		this.name = name;
		this.code = code;
		this.exchangeRate = exchangeRate;
		this.converter = converter;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getConverter() {
		return converter;
	}

	public void setConverter(double converter) {
		this.converter = converter;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}

