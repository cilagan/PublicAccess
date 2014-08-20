package gov.research.publicaccess.util;

import java.util.ArrayList;
import java.util.List;

import gov.research.publicaccess.model.PublicationMetadata;

public class MockDataUtil {
	
	public static int RECORD_LIST_SIZE = 20;

	public static PublicationMetadata getPublicationMetadataMock(){
		PublicationMetadata pm = new PublicationMetadata();
		
		pm.setTitle("Entanglement’s Benefit Survives an Entanglement-Breaking Channel");
		pm.setCreator("Zhang, Zheshen (ORCID:0000000000000005); Tengner, Maria; Zhong, Tian; Wong, Franco N. C.; Shapiro, Jeffrey H.");
		pm.setSubject(null);
		pm.setDescription("Not Available");
		pm.setPublisher("American Physical Society");
		pm.setPublisherAvailability(false);
		pm.setPublisherResearch("None");
		pm.setPublisherSponsor("None");
		pm.setPublisherCountry("US");
		pm.setDate(null);
		pm.setLanguage("English");
		pm.setType("Journal Article");
		pm.setTypeQualifier(null);
		pm.setRelation("Journal Name: Physical Review Letters Journal Volume: 111 Journal Issue: 1");
		pm.setCoverage(null);
		pm.setFormat("Medium: X");
		pm.setIdentifier("OSTI ID: 502");
		pm.setIdentifierReport("None");
		pm.setIdentifierNSFAwardId("1234567");
		pm.setIdentifierOther("Journal ID: ISSN 0031-9007");
		pm.setDoi("1321657987");
		pm.setRights(false);
		pm.setDateEntry(null);
		pm.setOstiId("502");
		pm.setPeerReviewFlag(true);
		pm.setNsfFunded(true);
		
		return pm;
	}
	
	public static List<PublicationMetadata> getPublicationMetadataList(){
		
		List<PublicationMetadata> pubMDList = new ArrayList<PublicationMetadata>();
		
		for(int i=0; i<RECORD_LIST_SIZE; i++){
			pubMDList.add(getPublicationMetadataMock());
		}
		
		return pubMDList;
	}
	
}
