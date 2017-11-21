package com.mustafaergan.modal;

import com.mustafaergan.annotation.Language;

public class MyType {
	String id;
	String name;
	@Language(localeValue="name")
	String languageValue;
	
	public MyType() {
		// TODO Auto-generated constructor stub
	}
	
	public MyType(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLanguageValue(String languageValue) {
		this.languageValue = languageValue;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLanguageValue() {
		return languageValue;
	}

}
