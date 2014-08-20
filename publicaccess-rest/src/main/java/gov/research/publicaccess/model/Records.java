package gov.research.publicaccess.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "records", namespace="http://www.w3.org/1999/02/22-rdf-syntax-ns#")
public class Records {

	protected List<PublicationMetadata> records;
	
	public List<PublicationMetadata> getRecords() {
		return records == null ? new ArrayList<PublicationMetadata>() : records;
	}

	public void setRecords(List<PublicationMetadata> records) {
		this.records = records;
	}
	
}
