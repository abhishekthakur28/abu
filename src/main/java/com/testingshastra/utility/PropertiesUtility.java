package com.testingshastra.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	// public static String getLocator(String key) {

	// public static String getLocator(String filepath,String key) {
	public static String getProperty(String filepath, String key) {// isko ese bhi likh skte h

		FileInputStream fis = null;
		try {
			// fis = new FileInputStream(
			// "D:\\Start
			// selenium\\saklaniTechno\\src\\main\\resources\\properties\\Locators.properties");
			fis = new FileInputStream(filepath);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ese bhi likh skate h
		return prop.getProperty(key);

		// or ese bhi likh skte h
		/*
		 * String value = prop.getProperty("username"); return value;
		 */
	}
	public static String getLocator( String key) {// isko ese bhi likh skte h

		FileInputStream fis = null;
		try {
			// fis = new FileInputStream(
			// "D:\\Start
			// selenium\\saklaniTechno\\src\\main\\resources\\properties\\Locators.properties");
			fis = new FileInputStream("D:\\Start selenium\\saklaniTechno\\src\\main\\resources\\properties\\Locators.properties");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ese bhi likh skate h
		return prop.getProperty(key);

		// or ese bhi likh skte h
		/*
		 * String value = prop.getProperty("username"); return value;
		 */
	}

}
