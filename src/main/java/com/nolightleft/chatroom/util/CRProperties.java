package com.nolightleft.chatroom.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <p>
 * Title: {@link CRProperties}
 * </p>
 * <b>Description:</b>
 * <p>
 * Insert Description here
 * </p>
 *
 * @author lzu
 */
public class CRProperties {
	
	private static Properties properties;
	
	private static CRProperties instance;
	
	public static CRProperties getInstance() {
		if (instance == null) {
			instance = new CRProperties();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public CRProperties() {
		properties = new Properties();
		
		try (InputStream input = new FileInputStream("./chatroom.properties")) {
			properties.load(input);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * @param pCharacterName
	 * @return
	 */
	public String getModel(String pCharacterName) {
		return properties.getProperty("model." + pCharacterName, "llama3");
	}
	
	public static void main(String[] args) {
        System.out.println(CRProperties.getInstance().getModel("xiahoulan"));
    }
}
