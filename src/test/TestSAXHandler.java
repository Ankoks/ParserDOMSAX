package test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestSAXHandler extends DefaultHandler {
	
	private StringBuffer result;
	
	public TestSAXHandler(){
		result = new StringBuffer();
	}

	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		
		//имя тега
		result.append("Element name = '"+ qName+"'\n");
		
		//атрибуты тега
		for (int i = 0; i < atts.getLength(); i++){
			result.append("Attribute name = '" +
			  atts.getQName(i) + "'; Attribute value = '" + atts.getValue(i)+"'\n");
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String value = "";
		
		//содержимое тега
		for (int i = start; i < length; i++){
			value += ch[i];
		}
		
		if (value.length() != 0)
		result.append("Element content = '" + value.trim() + "'\n");
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		
		//закрытие тега
		result.append("Element closed, name = '" + qName + "'\n");
	}
	
	public String getResult(){
		return result.toString();
	}
}