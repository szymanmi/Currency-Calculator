import model.WebClient;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;

public class JunitTests {


	public void checkDownload() throws ParserConfigurationException, SAXException, IOException {
		WebClient webClient = new WebClient();
		String[][] stringWaluty = webClient.getStringWaluty();
		assertNotNull(stringWaluty[0][0]);

	}
}
