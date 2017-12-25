package test;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.Document;

public class Main {
	
	private final static String PATH = "C:\\Users\\alex\\test.xml";
	
	public static void main(String args[]){
		
		//Входной файл, содержащий XML документ
		File input = new File(PATH);
		
		//SAX парсер
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			TestSAXHandler handler = new TestSAXHandler();
			parser.parse(input, handler);
			System.out.println("SAX parser result:\n" + handler.getResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//DOM парсер
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();			
			Document doc = dBuilder.parse(input);
			doc.getDocumentElement().normalize();
			DomParser domParser = new DomParser();
			System.out.println("DOM parser result:\n" + domParser.parse(doc));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}