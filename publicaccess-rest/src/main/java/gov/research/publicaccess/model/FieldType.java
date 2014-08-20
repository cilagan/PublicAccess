package gov.research.publicaccess.model;

public enum FieldType {

	DOI("doi"),
	CREATOR("creator"),
	TITLE("title"),
	RELATION("relation"),
	PUB_SPONSOR("publisherSponsor"),
	AWARD_ID("identifierAwardId"),
	DESCRIPTION("description"),
	PEER_REVIEW_FLAG("peerReviewFlag"),
	NSF_FUNDED_FLAG("nsfFunded"),
	RECORD("record"),
	NOT_DEFINED("");
	
	private String field;
	
	private FieldType(String field){
		this.field = field;
	}
	
	public String getField(){
		return field;
	}
	
	public static FieldType getFieldType(String field){
		
		FieldType fieldType = null;
		
		if(DOI.getField().equals(field)){
			fieldType = FieldType.DOI;
		} else if(CREATOR.getField().equals(field)){
			fieldType = FieldType.CREATOR;
		} else if(TITLE.getField().equals(field)){
			fieldType = FieldType.TITLE;
		} else if(RELATION.getField().equals(field)){
			fieldType = FieldType.RELATION;
		} else if(PUB_SPONSOR.getField().equals(field)){
			fieldType = FieldType.PUB_SPONSOR;
		} else if(AWARD_ID.getField().equals(field)){
			fieldType = FieldType.AWARD_ID;
		} else if(DESCRIPTION.getField().equals(field)){
			fieldType = FieldType.DESCRIPTION;
		} else if(PEER_REVIEW_FLAG.getField().equals(field)){
			fieldType = FieldType.PEER_REVIEW_FLAG;
		} else if(NSF_FUNDED_FLAG.getField().equals(field)){
			fieldType = FieldType.NSF_FUNDED_FLAG;
		} else if(RECORD.getField().equals(field)){
				fieldType = FieldType.RECORD;	
		} else {
			fieldType = FieldType.NOT_DEFINED;
		}
		
		return fieldType;
	}
}
