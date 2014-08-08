package com.redhat.demo.heisedemo.HeiseDemoBatchStarter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.codec.binary.Base64;
import org.switchyard.component.bean.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


@Service(SingleContractRequestStarter.class)
public class SingleContractRequestStarterBean implements
		SingleContractRequestStarter {

	@Override
	public void startProcess(HouseHoldContractRequest request)  {
		
		System.out.println(" ..........  foo 1...............");
		System.out.println(request);
		System.out.println(request.getPerson().getNachname());
		System.out.println(" ..........  foo 1...............");
		
		/*
		String body = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><command-request><deployment-id>com.redhat.demo:HeiseDemo:1.4</deployment-id>" + 
		"<ver>1</ver><start-process processId=\"HeiseDemo.Hausrat\"><parameter><item key=\"personendaten\">" +
		"<value xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"personendaten\">" +
		"<adresse1>Strasse</adresse1>" +
		"<bic>bic</bic>" +
		"<email>p@p.de</email>" +
		"<geburtsdatum>2014-07-29T17:24:19.201-04:00</geburtsdatum>" +
		"<iban>iban</iban>" +
		"<nachname>Steiner</nachname>" +
		"<ort>Hamburg</ort>" +
		"<plz>21244</plz>" +
		"<rolle>admin</rolle>" +
		"<telefon>tel</telefon>" +
		"<vorname>Patrick</vorname>" +
		"</value>" +
		"</item>" +
		"<item key=\"versichertesObjekt\">" +
		"<value xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"versichertesObjekt\">" +
		"<adresse1>strasse</adresse1>" +
		"<haustyp>efh</haustyp>" +
		"<ort>Hamburg</ort>" +
		"<plz>21244</plz>" +
		"<vertragsbeginn>2014-07-29T17:24:19.201-04:00</vertragsbeginn>" +
		"<wohnflaeche>200</wohnflaeche>" +
		"</value>" +
		"</item>" +
		"<item key=\"vertrag\">" +
		"<value xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"vertrag\">" +
		"<amount>0.0</amount>" +
		"<rabatt>0</rabatt>" +
		"<type>Premium</type>" +
		"<vertriebskanal>0</vertriebskanal>" +
		"</value>" +
		"</item></parameter></start-process></command-request>";
		*/
		
		String USERNAME = "psteiner";
		String PASSWORD = "change12_me";
		String DEPLOYMENT_ID = "com.redhat.demo:HeiseDemo:1.4";
		String PROCESS_ID = "HeiseDemo.Hausrat";
		String BC_URL = "http://localhost:49161/business-central";
		
		String POST_BODY = "<command-request><deployment-id /><ver>1</ver>" +
				"<start-process processId=\"\"><parameter /></start-process>" +
				"</command-request>";
				
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse(new ByteArrayInputStream(POST_BODY.getBytes()));
			XPath xpath = XPathFactory.newInstance().newXPath();
			
			((Element)xpath.evaluate("//deployment-id", doc, XPathConstants.NODE)).setTextContent(DEPLOYMENT_ID);
			((Element)xpath.evaluate("//start-process", doc, XPathConstants.NODE)).setAttribute("processId", PROCESS_ID);
			
			Marshaller m = JAXBContext.newInstance(Personendaten.class, Vertrag.class, VersichertesObjekt.class).createMarshaller();		
			Element parameter = (Element) xpath.evaluate("//parameter", doc, XPathConstants.NODE);
			
			Element item = (Element) parameter.appendChild(doc.createElement("item"));
			item.setAttribute("key","personendaten");
			m.marshal(new JAXBElement<Object>(new QName("value"),Object.class,request.getPerson()), item);
			
			item = (Element) parameter.appendChild(doc.createElement("item"));
			item.setAttribute("key","versichertesObjekt");
			m.marshal(new JAXBElement<Object>(new QName("value"),Object.class,request.getObject()), item);
					
			item = (Element) parameter.appendChild(doc.createElement("item"));
			item.setAttribute("key","vertrag");
			m.marshal(new JAXBElement<Object>(new QName("value"),Object.class,request.getContract()), item);
			
			HttpURLConnection urlc = (HttpURLConnection) new URL(BC_URL + "/rest/runtime/" + DEPLOYMENT_ID + "/execute").openConnection();
			urlc.setRequestMethod("POST");
			urlc.setDoOutput(true);
			urlc.setRequestProperty("Authorization", "Basic " + Base64.encodeBase64String((USERNAME + ":" + PASSWORD).getBytes()).trim());
			urlc.setRequestProperty("Content-Type","application/xml");
			
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(urlc.getOutputStream()));
			urlc.getOutputStream().flush();
			urlc.getOutputStream().close();
			
			System.out.println(urlc.getResponseCode() + " " + urlc.getResponseMessage());
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	

}
