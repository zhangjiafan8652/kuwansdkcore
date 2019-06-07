package com.jiafancreatezipfile;

import java.util.ArrayList;

import com.spreada.utils.chinese.ZHConverter;

public class Ceshi5 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
	
	    ZHConverter converter2 = ZHConverter.getInstance(ZHConverter.TRADITIONAL);  
      
        
        String read = Filetextutils.read("E:\\lingshiwenjian\\Localizable.strings");
        
        String[] temmainstringarray = read.split(";");
        
        ArrayList<String> mainstringarray = new ArrayList<String>();  
        
        for (int i = 0; i < temmainstringarray.length; i++) {
        	System.out.println(temmainstringarray[i].split("=")[0].trim());
        	mainstringarray.add(temmainstringarray[i].split("=")[0].trim());
        	
		}
       // System.out.println(read);
       
        
        ////////////////////////////////////////////////////////////////////////
        String traditionalStr2 = converter2.convert(read);  
        
        String[] temmainfantistringarray = traditionalStr2.split(";");
        
        ArrayList<String> mainfantistringarray = new ArrayList<String>();  
        
        for (int i = 0; i < temmainstringarray.length; i++) {
        	System.out.println(temmainfantistringarray[i].split("=")[0].trim());
        	mainfantistringarray.add(temmainfantistringarray[i].split("=")[0].trim());
        	
		}
        String nowfiletext="//create by jiafan \n\r";
        for (int i = 0; i < temmainfantistringarray.length; i++) {
        	nowfiletext=nowfiletext+""+mainstringarray.get(i)+" = "+mainfantistringarray.get(i)+"; \r\n";
		}
        
        System.out.println(nowfiletext);
        Filetextutils.write("E:\\lingshiwenjian\\Localizable.stringstem", false, nowfiletext);
        
	}

}
