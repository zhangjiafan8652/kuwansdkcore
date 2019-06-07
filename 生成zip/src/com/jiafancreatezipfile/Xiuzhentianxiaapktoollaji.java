package com.jiafancreatezipfile;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Xiuzhentianxiaapktoollaji {

	
	public static String packagename="com.qyjd.yyw";
	public static String filepath="E:\\ApkIDE\\Work\\"+packagename;
	
	public static String ceshifile="E:\\ApkIDE\\Work\\com.yiniu.mhxx.yyw\\res\\values\\colors.xml";
	public static String ceshifilepath="E:\\ApkIDE\\Work\\com.yiniu.mhxx.yyw\\AndroidManifest.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ceshi();
		//replaseAndroidfest();
	}
	
	
	public static void ceshi2(){
		
		String str = Filetextutils.read(ceshifilepath);
		//System.out.println(str);
		String androidfeststr=Filetextutils.read(filepath+"\\AndroidManifest.xml");
		String launchactivitypatternstr = "(<intent-filter[\\s\\S]*lenovoid.MAIN[\\s\\S]*</intent-filter>)[\\s\\S]*(<intent-filter[\\s\\S]*action.MAIN[\\s\\S]*category.LAUNCHER[\\s\\S]*filter>)";
		//System.out.println("匹配str："+launchactivitypatternstr);
		 Pattern launchactivitypattern = Pattern.compile(launchactivitypatternstr);
		 Matcher launchactivitymatcher = launchactivitypattern.matcher(androidfeststr);
		 while (launchactivitymatcher.find()) {
	            System.out.println("launchactivitymatcher:"+launchactivitymatcher.group(2));
	           // mainactivitymatcher.group();
	            //androidfeststr=androidfeststr.replace(launchactivitymatcher.group(), "");
	        }
	}
	
	static String  mainstr="<activity android:configChanges=\"keyboardHidden|navigation|orientation|screenLayout|screenSize|touchscreen\" android:icon=\"@drawable/app_icon\" android:launchMode=\"singleTask\" android:name=\"com.xiongdi.qyj3d.activity.UnityMainActivity\" android:screenOrientation=\"landscape\"><intent-filter><action android:name=\"android.intent.action.MAIN\"/><category android:name=\"android.intent.category.LAUNCHER\"/></intent-filter></activity>";
	
	public static void replaseAndroidfest(){
		
		String androidfeststr=Filetextutils.read(filepath+"\\AndroidManifest.xml");
		String launchactivitypatternstr = "(<intent-filter[\\s\\S]*lenovoid.MAIN[\\s\\S]*</intent-filter>)[\\s\\S]*(<intent-filter[\\s\\S]*action.MAIN[\\s\\S]*category.LAUNCHER[\\s\\S]*filter>)";
		
		 Pattern launchactivitypattern = Pattern.compile(launchactivitypatternstr);
		 Matcher launchactivitymatcher = launchactivitypattern.matcher(androidfeststr);
		 while (launchactivitymatcher.find()) {
	            System.out.println("launchactivitymatcher:"+launchactivitymatcher.group(2));
	           // mainactivitymatcher.group();
	            androidfeststr=androidfeststr.replace(launchactivitymatcher.group(2), "");
	        }
		 
	
		String mainactivitypatternstr = "(<activity .*app_icon.*com.xiongdi.qyj3d.activity.UnityMainActivity.*/>)";

		 Pattern mainactivitypattern = Pattern.compile(mainactivitypatternstr);
		 Matcher mainactivitymatcher = mainactivitypattern.matcher(androidfeststr);
		 while (mainactivitymatcher.find()) {
	            System.out.println("mainactivitymatcher:"+mainactivitymatcher.group());
	           // mainactivitymatcher.group();
	            androidfeststr=androidfeststr.replace(mainactivitymatcher.group(), mainstr);
	        }
		 Filetextutils.write(filepath+"\\AndroidManifest.xml", false, androidfeststr);
	}
	  //练习1：匹配QQ号(长度为5-10位，纯数字组成，且不能以0开头)
	     public static boolean isQQ(String qq) {
	        //定义匹配规则：
	         String regex = "[1-9][0-9]{4,9}";
	         
	        //判断是否符合规则
	        boolean b = qq.matches(regex);
	         
	        return b;
	     }	
	public static void ceshi(){
		File file = new File(filepath+File.separator+"res");
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (int i = 0; i < listFiles.length; i++) {
				File file2 = new File(listFiles[i].getAbsolutePath());
				if (file2.isDirectory()) {
					File[] listFiles2 = 	file2.listFiles();
					for (int j = 0; j < listFiles2.length; j++) {
						if (listFiles2[j].getAbsolutePath().contains("xml")) {
							String str = Filetextutils.read(listFiles2[j].getAbsolutePath());
							String pattern = "(.*<.* type=\".*\" name=\"APKTOOL.*>)"; 
							Pattern pattern1 = Pattern.compile(pattern);
						    Matcher matcher = pattern1.matcher(str);
					        while (matcher.find()) {
					          //  System.out.println(matcher.group());
					            str=str.replace(matcher.group(), "");
					              }
					        System.out.println("出去空白行");
					       str= deleteCRLFOnce(str);
					       str= str.replace("\r\n", "");
					       System.out.println(str);
				            Filetextutils.write(listFiles2[j].getAbsolutePath(), false, str);
				            
						}else {
							
						}
						
				       
						
						//System.out.println(listFiles2[j].getAbsolutePath());
					}
				}
				
			}
		}
	}

	
	
	/*** 
     * delete CRLF; delete empty line ;delete blank lines 
     *  
     * @param input 
     * @return 
     */  
    private static String deleteCRLFOnce(String input) {  
        //if (ValueWidget.isHasValue(input)) {
   
    	String text1= input.replaceAll("[&nbsp;]+","");//将多个空格替换成掉
    	String text2=input.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "   ");//去掉空行
    
       return  text2;
            // } else {  
         //   return null;  
      //  }  
    }  
}
