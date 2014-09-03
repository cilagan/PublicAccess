package gov.research.publicaccess.util;

import gov.research.publicaccess.constants.Keys;
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
		Map<String, PublicationMetadata> pubMapAwardId = getPublicationsByAwardId("0621443");
		System.out.println(pubMapAwardId.toString());
		Long timestamp = new Long("1190556610000");
		Map<String, PublicationMetadata> pubMapTimeStamp = getPublicationsByLastBatchTimeStamp(timestamp);
		System.out.println(pubMapTimeStamp.toString());
	}
	
	public static Map<String, PublicationMetadata> getPublicationsByAwardId(String awardId){
		
		String URL = Keys.DOE_PAGES_BASE_URL 
				+ Keys.PARAM_IND
				+ Keys.AWARDID_PARAM
				+ awardId
				+ Keys.PARAM_SEPERATOR 
				+ Keys.ROWS_PARAM
				+ Keys.MAX_ROWS;
		
		return getPublications(URL);
	}
	
	public static Map<String, PublicationMetadata> getPublicationsByLastBatchTimeStamp(long timestamp){
		
		String URL = Keys.DOE_PAGES_BASE_URL 
				+ Keys.PARAM_IND
				+ Keys.TIMESTAMP_PARAM
				+ timestamp
				+ Keys.PARAM_SEPERATOR 
				+ Keys.ROWS_PARAM
				+ Keys.MAX_ROWS;
		
		return getPublications(URL);
	}

	private static Map<String, PublicationMetadata> getPublications(String URL){
		Map<String, PublicationMetadata> pubMetaDataMap = new HashMap<String, PublicationMetadata>();
		
		System.out.println("*****");			
		System.out.println(URL);
		System.out.println("*****");
		
		try {
	    	URL url = new URL(URL);
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
	    	  		if(checkIfStartRecord(event)){
	    	  			pub = new PublicationMetadata();
	    	  		}
	    	  		//map field type
	    	  		fieldType = FieldType.getFieldType(event.asStartElement().getName().getLocalPart());
	    	  		break;
	    	  	case XMLStreamConstants.CHARACTERS:
	    	  			//map data - pass data, fieldtype, publication object
	    	  		mapData(event, pub, fieldType);
	    	  		break;
	    	  	case XMLStreamConstants.END_ELEMENT:
	    	  		if(checkIfEndRecord(event)){
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
		case DOI:
			pubMetadata.setDoi(content);
			break;
		case CREATOR:
			pubMetadata.setCreator(content);
			break;
		case TITLE:
			pubMetadata.setTitle(content);
			break;
		case RELATION:
			pubMetadata.setRelation(content);
			break;
		case PUB_SPONSOR:
			pubMetadata.setPublisherSponsor(content);
			break;
		case AWARD_ID:
			pubMetadata.setIdentifierNSFAwardId(content);;
			break;			
		case DESCRIPTION:
			pubMetadata.setDescription(content);
			break;
		case PEER_REVIEW_FLAG:
			pubMetadata.setPeerReviewFlag(parseFlag(content.toString()));
			break;
		case NSF_FUNDED_FLAG:
			pubMetadata.setNsfFunded(parseFlag(content.toString()));
			break;	
		case NOT_DEFINED:
			break;
		default:
			break;
		}
	}
	
	private static String parseFlag(String content){
		return "Y".equals(content) ? "Yes": "No";
	}
	
	private static boolean checkIfStartRecord(XMLEvent event){
		return FieldType.RECORD.getField().equals(event.asStartElement().getName().getLocalPart());
	}
	private static boolean checkIfEndRecord(XMLEvent event){
		return FieldType.RECORD.getField().equals(event.asEndElement().getName().getLocalPart());
	}
}
