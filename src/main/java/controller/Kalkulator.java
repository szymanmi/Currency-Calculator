package controller;

import model.CurrencyCollection;
import model.WebClient;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Kalkulator {
	private CurrencyCollection kolekcja = new CurrencyCollection();

	public Kalkulator() throws ParserConfigurationException, SAXException, ParseException, IOException {


	}

	public double przelicz(String w1, String w2, double val) {
		System.out.println(kolekcja.searchForWaluta(w1).getExchangeRate());
		System.out.println(kolekcja.searchForWaluta(w2).getExchangeRate());

		return val * kolekcja.searchForWaluta(w1).getExchangeRate() / kolekcja.searchForWaluta(w2).getExchangeRate();
	}


	public CurrencyCollection getAll() {
		return kolekcja;
	}

	public String[] getCodesList(){
		String[] list = new String[kolekcja.getTotalWaluty()];
		for(int i = 0; i < kolekcja.getTotalWaluty(); i++)
			list[i] = kolekcja.getAll().get(i).getCode();

		return list;
	}

	public DefaultListModel<String> getListOfAllCurrencies(String code){
		String[] list = new String[kolekcja.getTotalWaluty()];
		DefaultListModel<String> model = new DefaultListModel<>();
		DecimalFormat df = new DecimalFormat("####.##");
		for (int i = 0; i < kolekcja.getTotalWaluty(); i++) {
			model.addElement(kolekcja.getAll().get(i).getCode() + " " + df.format(kolekcja.searchForWaluta(code).getExchangeRate() / kolekcja.getAll().get(i).getExchangeRate()));
		}
		return model;
	}

	@Test
	public void checkconverting() throws ParserConfigurationException, SAXException, IOException, ParseException {
		Kalkulator k = new Kalkulator();
		assertEquals(100, k.przelicz("PLN", "PLN", 100), 0);
	}

	@Test
	public void checkGetingAllCurrencies() throws ParserConfigurationException, SAXException, ParseException, IOException {
		Kalkulator k = new Kalkulator();
		assertNotNull(k.getListOfAllCurrencies("USD"));

	}

	@Test
	public void checkGettingCodesList() throws ParserConfigurationException, SAXException, ParseException, IOException {
		Kalkulator k = new Kalkulator();
		assertNotNull(k.getCodesList());
	}
}