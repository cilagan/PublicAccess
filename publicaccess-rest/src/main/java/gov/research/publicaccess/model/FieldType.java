package gov.research.publicaccess.model;

public enum FieldType {

	TITLE("title"),
	DESCRIPTION("description"),
	DOI("doi"),
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
		
		if(TITLE.getField().equals(field)){
			fieldType = FieldType.TITLE;
		} else if(DESCRIPTION.getField().equals(field)){
			fieldType = FieldType.DESCRIPTION;
		} else if(DOI.getField().equals(field)){
			fieldType = FieldType.DOI;
		} else {
			fieldType = FieldType.NOT_DEFINED;
		}
		
		return fieldType;
	}
}
