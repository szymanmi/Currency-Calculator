package model;

import org.junit.Test;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static org.junit.Assert.assertNotNull;

public class WebClient {

	private int totalWaluty;
	private NodeList listOfWaluty;
	private String[][] stringWaluty = new String[4][];

	public WebClient() throws IOException, ParserConfigurationException, SAXException {

		String result = downloadData();
		Parser parser = new ParserXML(result);
		totalWaluty = parser.getTotalWaluty();


		stringWaluty[0] = parser.parseNazwaWaluty();
		stringWaluty[1] = parser.parseKodWaluty();
		stringWaluty[2] = parser.parseKursWaluty();
		stringWaluty[3] = parser.parsePrzelicznikWaluty();
	}

	public String downloadData() throws MalformedURLException {
		URL url = new URL("http://www.nbp.pl/kursy/xml/lasta.xml");
		InputStream stream = null;
		try {
			stream = url.openStream();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Nie udało się połączyć. Aplikacja zostanie zamknięta. Sprawdź połączenie z internetem");
			System.exit(0);
		}
		Scanner s = new Scanner(stream).useDelimiter("\\A");
		String result = s.hasNext() ? s.next() : "";
		return result;
	}

	public String[][] getStringWaluty() {
		return stringWaluty;
	}

	public int getTotalWaluty() {
		return totalWaluty;
	}

	@Test
	public void checkDownload() throws ParserConfigurationException, SAXException, IOException {
		WebClient webClient = new WebClient();
		String[][] stringWaluty = webClient.getStringWaluty();
		assertNotNull(stringWaluty[0][0]);
	}


}