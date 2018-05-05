package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * StringProcess.java
 *
 * Version 1.0
 *
 * Date: Jan 20, 2015
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * Jan 20, 2015        	DaiLV2          Create
 */

public class StringProcess {
	
	/**
	 * Ham tra ve gioi tinh: 1=Nam, 0=Nu
	 * @param val
	 * @return String
	 */
	public static String gioiTinh(String val) {
		if("0".equals(val)){
			return "Nu";
		}
		return "Nam";
	}
	
	/**
	 * Ham in ra mot xau, null in ra xau rong
	 * @param s
	 * @return String
	 */
	public static String getVaildString(String s) {
		if(s==null) return "";
		return s;
	}
	
	/**
	 * Ham kiem tra xau rong hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaild(String s){
		if(s==null || s.length()==0) return true;
		return false;
	}
	
	/**
	 * Ham kiem tra xem xau co bao gom chi chu so hay khong
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaildNumber(String s){
		if(notVaild(s)) return true;
		String regex = "[0-9]+"; 
		if(s.matches(regex)) return false;
		return true;
	}
	
	// check mail
		public static boolean checkMail(String mail) {
			Pattern pattern = Pattern.compile(
					"([a-zA-Z0-9])+(\\.)?([a-zA-Z0-9])*@([a-zA-Z0-9])+(\\.)+(\\.)?([a-zA-Z0-9])*");
			Matcher match = pattern.matcher(mail);
			return match.find();
		}

		/*public static boolean checkPhone(String phone) {
			Pattern pattern = Pattern.compile("^0\\d+");
			Matcher match = pattern.matcher(phone);
			return match.find();
		}*/
		public static boolean checkMaMay(String maMay){
			if(maMay.substring(0, 1).equals("M")){
				return true;
			}
			/*Matcher match = Pattern.compile("/^M\\d+$/").matcher(maMay);
			return match.find();*/
			return false;
		}
}

