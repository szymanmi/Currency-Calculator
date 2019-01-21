package view;

import controller.Kalkulator;
import model.Currency;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public class Wyswietlacz extends JFrame {
	private Kalkulator kalkulator = new Kalkulator();

	private JComboBox<String> currency1;
	private JComboBox<String> currency2;
	private JLabel info1;
	private JLabel info2;
	private JLabel info3;
	private JTextField inputField;
	private JButton przeliczButton;
	private JLabel resultLbl;

	private JLabel info4;
	private JComboBox<String> currencyall;
	private JButton showAll;
	private JList<String> listAll;
	private JScrollPane scrollAll;

	public Wyswietlacz() throws ParserConfigurationException, SAXException, ParseException, IOException {
		super("Kalkulator Walut");
		setSize(400, 300);
		setLookAndFeel();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		String[] listOfCodes = kalkulator.getCodesList();


		JPanel mainPanel = new JPanel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		mainPanel.setLayout(flowLayout);
		/////////////////////////////////////////////////////////////////////////////////////////
		JPanel firstPanel = new JPanel();
		GridLayout layout1 = new GridLayout(8, 1);
		firstPanel.setLayout(layout1);
		currency1 = new JComboBox<>(listOfCodes);
		currency2 = new JComboBox<>(listOfCodes);
		info1 = new JLabel("Wybierz walute bazowa:");
		info2 = new JLabel("Wybierz druga walute:");
		info3 = new JLabel("Podaj wartosc:");
		inputField = new JTextField(15);
		przeliczButton = new JButton("Przelicz");
		przeliczButton.addActionListener(e -> calculate2());
		resultLbl = new JLabel("");

		firstPanel.add(info1);
		firstPanel.add(currency1);
		firstPanel.add(info2);
		firstPanel.add(currency2);
		firstPanel.add(info3);
		firstPanel.add(inputField);
		firstPanel.add(przeliczButton);
		firstPanel.add(resultLbl);
		mainPanel.add(firstPanel);

		/////////////////////////////////////////////////////////////////////////////////////////

		JPanel secondPanel = new JPanel();

		secondPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		info4 = new JLabel("Wybierz walute:");
		currencyall = new JComboBox<>(listOfCodes);
		showAll = new JButton("Pokaz wszystkie");
		showAll.addActionListener(e -> showAllCurrencies());
		listAll = new JList<>();
		showAllCurrencies();
		scrollAll = new JScrollPane(listAll);
		listAll.setVisibleRowCount(7);
		scrollAll.setPreferredSize(new Dimension(100, 140));
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		secondPanel.add(info4, c);
		c.gridy = 1;
		secondPanel.add(currencyall, c);
		c.gridy = 2;
		secondPanel.add(showAll, c);
		c.gridy = 3;
		c.weighty = 7;
		secondPanel.add(scrollAll, c);

		mainPanel.add(secondPanel);
		add(mainPanel);

		setVisible(true);


	}

	public void calculate2() {

		String code1 = (String) currency1.getSelectedItem();
		String code2 = (String) currency2.getSelectedItem();

		if (StringUtils.isNumeric(inputField.getText())) {
			double value = Double.parseDouble(inputField.getText());
			String result = String.valueOf(kalkulator.przelicz(code1, code2, value));
			resultLbl.setText(result);
		} else
			JOptionPane.showMessageDialog(null, "Wprowadź poprawną liczbę całkowitą");

	}


	public void showAllCurrencies() {
		String code = (String) currencyall.getSelectedItem();
		DefaultListModel<String> listOfCurrencies = kalkulator.getListOfAllCurrencies(code);
		listAll.setModel(listOfCurrencies);


	}

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			System.err.println("Nie potrafię wczytać systemowego wyglądu: " + e);
		}
	}

}


