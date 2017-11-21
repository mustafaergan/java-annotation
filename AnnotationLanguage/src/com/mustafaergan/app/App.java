package com.mustafaergan.app;

import java.util.Locale;

import com.mustafaergan.modal.MyType;
import com.mustafaergan.util.LanguageUtil;

public class App {
	
	private static void convertLanguage() {
		MyType myType = new MyType("111","hello");
		LanguageUtil.findAndChangeWithAnnotation(myType, new Locale("tr"));
		System.out.println(myType.getLanguageValue());
	}
	
	
	public static void main(String[] args) {
		convertLanguage();
	}

}
