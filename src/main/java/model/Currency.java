package model;

public class Currency {
	private String name;
	private String code;
	private double converter;
	private double exchangeRate;


	public Currency(String name, String code, double converter, double exchangeRate) {
		this.name = name;
		this.code = code;
		this.converter = converter;
		this.exchangeRate = exchangeRate;
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

