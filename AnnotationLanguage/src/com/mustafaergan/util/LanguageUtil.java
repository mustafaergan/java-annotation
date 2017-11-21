package com.mustafaergan.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

import com.mustafaergan.annotation.Language;

public class LanguageUtil {
	
	
    public static <T> List<T> findAndChangeWithAnnotation(List<T> tList, Locale locale){
    	ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        for (T listValue : tList) {
            Field[] fields = listValue.getClass().getDeclaredFields();
            for (Field field : fields) {
                Annotation annotation = field.getAnnotation(Language.class);
                if (annotation instanceof Language) {
                    try {
                        String resource = ((Language) annotation).localeValue();
                        Method metSet = listValue.getClass().getDeclaredMethod(("set" + StringUtils.capitalize(field.getName())), String.class);
                        Method metGet = listValue.getClass().getDeclaredMethod(("get" + StringUtils.capitalize(resource)));
                        String value = (String)metGet.invoke(listValue);
                        value = bundle.getString(value);
                        metSet.invoke(listValue, value);
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        System.out.println("fail");
                    }
                }
            }
        }
        return tList;
    }
    
    public static <T> T findAndChangeWithAnnotation(T value, Locale locale){
    		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
            Field[] fields = value.getClass().getDeclaredFields();
            for (Field field : fields) {
                Annotation annotation = field.getAnnotation(Language.class);
                if (annotation instanceof Language) {
                    try {
                        String resource = ((Language) annotation).localeValue();
                        Method metSet = value.getClass().getDeclaredMethod(("set" + StringUtils.capitalize(field.getName())), String.class);
                        Method metGet = value.getClass().getDeclaredMethod(("get" + StringUtils.capitalize(resource)));
                        String val = (String)metGet.invoke(value);
                        val = bundle.getString(val);
                        metSet.invoke(value, val);
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        System.out.println("fail");
                    }
                }
            }
        return value;
    }


}
