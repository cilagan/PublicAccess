package gov.research.publicaccess.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "record", namespace="http://www.w3.org/1999/02/22-rdf-syntax-ns#")
public class PublicationMetadata {
	
	
	protected String title;
	protected String creator;
	protected String subject;
	protected String description;
	protected String publisher;
	protected Boolean publisherAvailability;
	protected String publisherResearch;
	protected String publisherSponsor;
	protected String publisherCountry;
	protected Date date;
	protected String language;
	protected String type;
	protected String typeQualifier;
	protected String relation;
	protected String coverage;
	protected String format;
	protected String identifier;
	protected String identifierReport;
	protected String identifierNSFAwardId;
	protected String identifierOther;
	protected String doi;
	protected Boolean rights;
	protected Date dateEntry;
	protected String ostiId;
	protected Boolean peerReviewFlag;
	protected Boolean nsfFunded;
	
	/* Getter and Setter Pairs */
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Boolean getPublisherAvailability() {
		return publisherAvailability;
	}
	public void setPublisherAvailability(Boolean publisherAvailability) {
		this.publisherAvailability = publisherAvailability;
	}
	public String getPublisherResearch() {
		return publisherResearch;
	}
	public void setPublisherResearch(String publisherResearch) {
		this.publisherResearch = publisherResearch;
	}
	public String getPublisherSponsor() {
		return publisherSponsor;
	}
	public void setPublisherSponsor(String publisherSponsor) {
		this.publisherSponsor = publisherSponsor;
	}
	public String getPublisherCountry() {
		return publisherCountry;
	}
	public void setPublisherCountry(String publisherCountry) {
		this.publisherCountry = publisherCountry;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypeQualifier() {
		return typeQualifier;
	}
	public void setTypeQualifier(String typeQualifier) {
		this.typeQualifier = typeQualifier;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getCoverage() {
		return coverage;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getIdentifierReport() {
		return identifierReport;
	}
	public void setIdentifierReport(String identifierReport) {
		this.identifierReport = identifierReport;
	}
	public String getIdentifierNSFAwardId() {
		return identifierNSFAwardId;
	}
	public void setIdentifierNSFAwardId(String identifierNSFAwardId) {
		this.identifierNSFAwardId = identifierNSFAwardId;
	}
	public String getIdentifierOther() {
		return identifierOther;
	}
	public void setIdentifierOther(String identifierOther) {
		this.identifierOther = identifierOther;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public Boolean getRights() {
		return rights;
	}
	public void setRights(Boolean rights) {
		this.rights = rights;
	}
	public Date getDateEntry() {
		return dateEntry;
	}
	public void setDateEntry(Date dateEntry) {
		this.dateEntry = dateEntry;
	}
	public String getOstiId() {
		return ostiId;
	}
	public void setOstiId(String ostiId) {
		this.ostiId = ostiId;
	}
	public Boolean getPeerReviewFlag() {
		return peerReviewFlag;
	}
	public void setPeerReviewFlag(Boolean peerReviewFlag) {
		this.peerReviewFlag = peerReviewFlag;
	}
	public Boolean getNsfFunded() {
		return nsfFunded;
	}
	public void setNsfFunded(Boolean nsfFunded) {
		this.nsfFunded = nsfFunded;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PublicationMetadata [title=");
		builder.append(title);
		builder.append(", creator=");
		builder.append(creator);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", description=");
		builder.append(description);
		builder.append(", publisher=");
		builder.append(publisher);
		builder.append(", publisherAvailability=");
		builder.append(publisherAvailability);
		builder.append(", publisherResearch=");
		builder.append(publisherResearch);
		builder.append(", publisherSponsor=");
		builder.append(publisherSponsor);
		builder.append(", publisherCountry=");
		builder.append(publisherCountry);
		builder.append(", date=");
		builder.append(date);
		builder.append(", language=");
		builder.append(language);
		builder.append(", type=");
		builder.append(type);
		builder.append(", typeQualifier=");
		builder.append(typeQualifier);
		builder.append(", relation=");
		builder.append(relation);
		builder.append(", coverage=");
		builder.append(coverage);
		builder.append(", format=");
		builder.append(format);
		builder.append(", identifier=");
		builder.append(identifier);
		builder.append(", identifierReport=");
		builder.append(identifierReport);
		builder.append(", identifierNSFAwardId=");
		builder.append(identifierNSFAwardId);
		builder.append(", identifierOther=");
		builder.append(identifierOther);
		builder.append(", doi=");
		builder.append(doi);
		builder.append(", rights=");
		builder.append(rights);
		builder.append(", dateEntry=");
		builder.append(dateEntry);
		builder.append(", ostiId=");
		builder.append(ostiId);
		builder.append(", peerReviewFlag=");
		builder.append(peerReviewFlag);
		builder.append(", nsfFunded=");
		builder.append(nsfFunded);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
