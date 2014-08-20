package gov.research.publicaccess.util;

import gov.research.publicaccess.model.FieldType;
import gov.research.publicaccess.model.PublicationMetadata;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class DoePagesUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, PublicationMetadata> pubMap = getPublications("1234567");
		System.out.println(pubMap.toString());
	}

	public static Map<String, PublicationMetadata> getPublications(String awardId){
		Map<String, PublicationMetadata> pubMetaDataMap = new HashMap<String, PublicationMetadata>();
		
		try {
	    	URL url = new URL("http://www.osti.gov/scitech/scitechxml?Title=energy");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			  if (conn.getResponseCode() != 200) {
			    throw new IOException(conn.getResponseMessage());
			  }
	      // First, create a new XMLInputFactory
	      XMLInputFactory inputFactory = XMLInputFactory.newInstance();
	      // Setup a new eventReader
	      InputStream in = conn.getInputStream();
	      XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
	      // read the XML document
	      PublicationMetadata pub = null;
	      XMLEvent event;
	      
	      FieldType fieldType = null;
	      
	      while(true){
	    	  event = eventReader.nextEvent();
	    	  int eventType = event.getEventType();
	    	  
	    	  switch(eventType){
	    	  	case XMLStreamConstants.START_ELEMENT:
	    	  		System.out.println("Start Element: " + event.asStartElement().getName().getLocalPart());
	    	  		if("record".equals(event.asStartElement().getName().getLocalPart())){
	    	  			pub = new PublicationMetadata();
	    	  		}
	    	  		//map field type
	    	  		fieldType = FieldType.getFieldType(event.asStartElement().getName().getLocalPart());
	    	  		System.out.println("FieldType: " +  fieldType.toString());
	    	  		break;
	    	  	case XMLStreamConstants.CHARACTERS:
	    	  		System.out.println("Content: " + event.asCharacters().getData());
	    	  			//map data - pass data, fieldtype, publication object
	    	  		mapData(event, pub, fieldType);
	    	  		break;
	    	  	case XMLStreamConstants.END_ELEMENT:
	    	  		System.out.println("End Element: " + event.asEndElement().getName().getLocalPart());
	    	  		if("record".equals(event.asEndElement().getName().getLocalPart())){
	    	  			if(pub.getDoi() != null){ // check why some doi are null
	    	  				pubMetaDataMap.put(pub.getDoi(), pub);
	    	  			}	
	    	  		}
	    	  		fieldType = null;
	    	  		break;
	    	  }
	    	  
	    	  if (!eventReader.hasNext()){
	    		  break;
	    	  }
	      } 
	    } catch (XMLStreamException e) {
	      e.printStackTrace();
	    } catch (Exception e) {
		      e.printStackTrace();
	    }
		
		return pubMetaDataMap;
	}
	
	private static void mapData(XMLEvent event, PublicationMetadata pubMetadata, FieldType fieldType){
		String content = event.asCharacters().getData();
		
		switch(fieldType){
		case TITLE:
			pubMetadata.setTitle(content);
			break;
		case DESCRIPTION:
			pubMetadata.setDescription(content);
			break;
		case DOI:
			pubMetadata.setDoi(content);
			break;
		case NOT_DEFINED:
			break;
		}
	}
}
