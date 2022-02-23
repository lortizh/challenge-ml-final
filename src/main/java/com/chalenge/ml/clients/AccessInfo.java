package com.chalenge.ml.clients;

public class AccessInfo {
	public String country;
    public String viewability;
    public boolean embeddable;
    public boolean publicDomain;
    public String textToSpeechPermission;
    public Epub epub;
    public Pdf pdf;
    public String webReaderLink;
    public String accessViewStatus;
    public boolean quoteSharingAllowed;
    
    public AccessInfo() {
		// TODO Auto-generated constructor stub
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getViewability() {
		return viewability;
	}

	public void setViewability(String viewability) {
		this.viewability = viewability;
	}

	public boolean isEmbeddable() {
		return embeddable;
	}

	public void setEmbeddable(boolean embeddable) {
		this.embeddable = embeddable;
	}

	public boolean isPublicDomain() {
		return publicDomain;
	}

	public void setPublicDomain(boolean publicDomain) {
		this.publicDomain = publicDomain;
	}

	public String getTextToSpeechPermission() {
		return textToSpeechPermission;
	}

	public void setTextToSpeechPermission(String textToSpeechPermission) {
		this.textToSpeechPermission = textToSpeechPermission;
	}

	public Epub getEpub() {
		return epub;
	}

	public void setEpub(Epub epub) {
		this.epub = epub;
	}

	public Pdf getPdf() {
		return pdf;
	}

	public void setPdf(Pdf pdf) {
		this.pdf = pdf;
	}

	public String getWebReaderLink() {
		return webReaderLink;
	}

	public void setWebReaderLink(String webReaderLink) {
		this.webReaderLink = webReaderLink;
	}

	public String getAccessViewStatus() {
		return accessViewStatus;
	}

	public void setAccessViewStatus(String accessViewStatus) {
		this.accessViewStatus = accessViewStatus;
	}

	public boolean isQuoteSharingAllowed() {
		return quoteSharingAllowed;
	}

	public void setQuoteSharingAllowed(boolean quoteSharingAllowed) {
		this.quoteSharingAllowed = quoteSharingAllowed;
	}
    
    
}
