package com.testingshastra.utility;

public class App {
	public static String getAppUrl(String env11) {
		String baseDir = System.getProperty("user.dir");// current working directory
		// String filePath = "D:\\Start
		// selenium\\saklaniTechno\\src\\main\\resources\\properties\\app.properties";
		String filePath = baseDir + "\\src\\main\\resources\\properties\\app.properties";

		// System.out.println(baseDir);
	//	String env1 = System.getProperty("env");
		return PropertiesUtility.getProperty(filePath, env11 + ".url");
		// return PropertiesUtility.getProperty(filePath, env11 + ".url");
	}

	public static String getUsername(String username) {
		String baseDir = System.getProperty("user.dir");// current working directory
		String filePath = baseDir + "\\src\\main\\resources\\properties\\app.properties";
		return PropertiesUtility.getProperty(filePath, "qa" + ".username");
	}

	public static String getPassword(String password) {
		String baseDir = System.getProperty("user.dir");// current working directory
		String filePath = baseDir + "\\src\\main\\resources\\properties\\app.properties";
		return PropertiesUtility.getProperty(filePath, "qa" + ".password");
	}
}

/*
 * method bn chuki h ab mein method ka kaam kthm public static void
 * main(String[] args) {
 * 
 * 
 * //1st trika // System.out.println(getAppUrl(args[0])); //2 String
 * env=System.getProperty("env"); System.out.println(getAppUrl(env)); } }
 */
