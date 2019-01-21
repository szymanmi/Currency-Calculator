package view;

import controller.Kalkulator;
import model.Currency;
import model.Spr;
import model.SprTxt;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Wyswietlacz extends JFrame {
	private Kalkulator kalkulator = new Kalkulator();

	public Wyswietlacz() throws ParserConfigurationException, SAXException, ParseException, IOException {
		super("Simple Paint");
		setSize(500, 300);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		String[] listOfCodes = kalkulator.getCodesList();


		JPanel mainPanel = new JPanel();
		//mainPanel.setLayout(layout);

		/////////////////////////////////////////////////////////////////////////////////////////
		JPanel firstPanel = new JPanel();
		GridLayout layout = new GridLayout(5, 1);
		firstPanel.setLayout(layout);
		JComboBox<String> currency1 = new JComboBox<>(listOfCodes);
		JComboBox<String> currency2 = new JComboBox<>(listOfCodes);
		JLabel info1 = new JLabel("Wybierz walute bazowa:");
		JLabel info2 = new JLabel("Wybierz druga walute:");
		JLabel info3 = new JLabel("Podaj wartosc:");
		JTextField inputValue = new JTextField(15);
		firstPanel.add(info1);
		firstPanel.add(currency1);
		firstPanel.add(info2);
		firstPanel.add(currency2);
		firstPanel.add(info3);
		firstPanel.add(inputValue);
		mainPanel.add(firstPanel);

		/////////////////////////////////////////////////////////////////////////////////////////


		mainPanel.add(inputValue);


		JButton przeliczButton = new JButton("Przelicz");
		mainPanel.add(przeliczButton);


		JLabel result = new JLabel("fakewynik");
		mainPanel.add(result);


		JComboBox<String> currencyall = new JComboBox<>(listOfCodes);
		mainPanel.add(currencyall);


		JButton showAll = new JButton("Pokaz wszystkie");
		mainPanel.add(showAll);


		JList<String> listAll = new JList<>(listOfCodes);
		JScrollPane scrollAll = new JScrollPane(listAll);
		mainPanel.add(scrollAll);
		add(mainPanel);

		setVisible(true);


	}

	public void calculate() {
		String kod1, kod2;
		Scanner scanner = new Scanner(System.in);
		Spr sprawdzacz = new SprTxt();
		do {
			System.out.println("podaj kod pierwszej waluty");
			kod1 = scanner.next();
		} while (!sprawdzacz.sprawdz(kalkulator.getAll(), kod1));

		do {
			System.out.println("podaj kod drugiej waluty");
			kod2 = scanner.next();
		} while (!sprawdzacz.sprawdz(kalkulator.getAll(), kod2));

		System.out.println("Podaj wartosc");
		int val = scanner.nextInt();

		System.out.println(kalkulator.przelicz(kod1, kod2, val));
	}

	public void showAll() {
		for (Currency w : kalkulator.getAll().getAll()) {
			System.out.println(w.getName());
			System.out.println(w.getCode());
			System.out.println();
		}
	}

}


