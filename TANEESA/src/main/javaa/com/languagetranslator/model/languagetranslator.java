package com.languagetranslator.model;

public class languagetranslator {
	private int id;  
    private String originalText;  
    private String translatedText;  
    private String sourceLang;  
    private String targetLang;  
    private String userEmail;
	public languagetranslator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public languagetranslator(int id, String originalText, String translatedText, String sourceLang, String targetLang,
			String userEmail) {
		super();
		this.id = id;
		this.originalText = originalText;
		this.translatedText = translatedText;
		this.sourceLang = sourceLang;
		this.targetLang = targetLang;
		this.userEmail = userEmail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOriginalText() {
		return originalText;
	}
	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}
	public String getTranslatedText() {
		return translatedText;
	}
	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}
	public String getSourceLang() {
		return sourceLang;
	}
	public void setSourceLang(String sourceLang) {
		this.sourceLang = sourceLang;
	}
	public String getTargetLang() {
		return targetLang;
	}
	public void setTargetLang(String targetLang) {
		this.targetLang = targetLang;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Override
	public String toString() {
		return "languagetranslator [id=" + id + ", originalText=" + originalText + ", translatedText=" + translatedText
				+ ", sourceLang=" + sourceLang + ", targetLang=" + targetLang + ", userEmail=" + userEmail + "]";
	}  

   
}
