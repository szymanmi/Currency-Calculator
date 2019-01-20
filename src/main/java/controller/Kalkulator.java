package controller;

import model.CurrencyCollection;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public class Kalkulator {
	private CurrencyCollection kolekcja = new CurrencyCollection();

	public Kalkulator() throws ParserConfigurationException, SAXException, ParseException, IOException {


	}

	public double przelicz(String w1, String w2, double val) {
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

}