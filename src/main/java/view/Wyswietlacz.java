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
		setSize(500, 500);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		String[] listOfCodes = kalkulator.getCodesList();


		JPanel mainPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		mainPanel.setLayout(flowLayout);
		/////////////////////////////////////////////////////////////////////////////////////////
		JPanel firstPanel = new JPanel();
		GridLayout layout1 = new GridLayout(8, 1);
		firstPanel.setLayout(layout1);
		JComboBox<String> currency1 = new JComboBox<>(listOfCodes);
		JComboBox<String> currency2 = new JComboBox<>(listOfCodes);
		JLabel info1 = new JLabel("Wybierz walute bazowa:");
		JLabel info2 = new JLabel("Wybierz druga walute:");
		JLabel info3 = new JLabel("Podaj wartosc:");
		JTextField inputValue = new JTextField(15);
		JButton przeliczButton = new JButton("Przelicz");
		JLabel result = new JLabel("fakewynik");

		firstPanel.add(info1);
		firstPanel.add(currency1);
		firstPanel.add(info2);
		firstPanel.add(currency2);
		firstPanel.add(info3);
		firstPanel.add(inputValue);
		firstPanel.add(przeliczButton);
		firstPanel.add(result);
		mainPanel.add(firstPanel);

		/////////////////////////////////////////////////////////////////////////////////////////

		JPanel secondPanel = new JPanel();

		secondPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JLabel info4 = new JLabel("Wybierz walute:");
		JComboBox<String> currencyall = new JComboBox<>(listOfCodes);
		JButton showAll = new JButton("Pokaz wszystkie");
		JList<String> listAll = new JList<>(listOfCodes);
		JScrollPane scrollAll = new JScrollPane(listAll);
		listAll.setVisibleRowCount(7);

		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		secondPanel.add(info4,c);
		c.gridy = 1;
		secondPanel.add(currencyall, c);
		c.gridy = 2;
		secondPanel.add(showAll, c);
		c.gridy = 3;
		c.weighty = 7;
		secondPanel.add(scrollAll,c);

		mainPanel.add(secondPanel);
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


