package com.jiafancreatezipfile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class ceshi1 {

	//tmp\ApkIDE\Work\com.wdsf.yyw
	//public static String packagename="com.yl.zsbb.vivo";
	public static String packagename="com.tencent.tmgp.wszjx";
	public static String filepath="E:\\ApkIDE\\Work\\"+packagename;
	//E:\ApkIDE\Work\com.tfzg.yyw
	private static Process p = null;
	static double x=0.85;//分成所得
	static double zall=13439757.1;//自付费
	//static double qall=0;//渠道
	static double tong=0.994;//通道费
	static double qfen=0.55;//渠道分成所得
	static double all=15030640.1;//总付费
	static double g=12503300.91;//广告费
	//com.yl.smxn.vivo
	public static void main(String[] args) {
	
		double k=((all-zall)*x*0.55)+(zall*x*tong);
		double y=k-g;
		//checkfileu(filepath);
		BigDecimal bdall = new BigDecimal(all);
		BigDecimal bdk = new BigDecimal(k);
		BigDecimal bdg = new BigDecimal(g);
		BigDecimal bdy = new BigDecimal(y);
		 System.out.println("总充值："+bdall.toPlainString());
        System.out.println("利润："+bdk.toPlainString());
        System.out.println("广告费："+bdg);
        System.out.println("盈利："+bdy);
       
	}
	

	public static void checkfilenochange(String path){
		//System.out.println("+++++++++"+path);
		File file = new File(path);
		if (file.isDirectory()) {
			//file.list()
			File[] listFiles = file.listFiles();
			for (int i = 0; i < listFiles.length; i++) {
				File file2 = new File(listFiles[i].getAbsolutePath());
				
				if (file2.getAbsolutePath().toString().contains("Alipay")) {
					System.out.println(listFiles[i].getAbsolutePath());
				}
				if (file2.getAbsolutePath().toString().contains("alipay")) {
					System.out.println(listFiles[i].getAbsolutePath());
					
				}
				if (file2.getAbsolutePath().toString().contains("weixin")) {
					System.out.println(listFiles[i].getAbsolutePath());
				}
				if (file2.getAbsolutePath().toString().contains("Weixin")) {
					System.out.println(listFiles[i].getAbsolutePath());
				}
				if (file2.getAbsolutePath().toString().contains("WX")) {
					//System.out.println(listFiles[i].getAbsolutePath());
				}
				if (file2.getAbsolutePath().toString().contains("Wechat")) {
					System.out.println(listFiles[i].getAbsolutePath());
				}
				if (file2.getAbsolutePath().toString().contains("wechat")) {
					System.out.println(listFiles[i].getAbsolutePath());
					
					
				}
				//System.out.println(file2.getAbsolutePath());
				if (file2.isDirectory()) {
					//System.out.println(file2.getAbsolutePath());
					checkfilenochange(listFiles[i].getAbsolutePath());
				}else {
					
					if ((listFiles[i].getAbsolutePath().replace(packagename, "temp")).contains("vivo")) {
						//System.out.println("vivo的文件："+listFiles[i].getAbsolutePath());
					}else{
						
						String read = Filetextutils.read(listFiles[i].getAbsolutePath());
					if (read.toString().contains("Alipay")) {
						
							
						System.out.println("Alipay"+listFiles[i].getAbsolutePath());
					
						
					}
					if (read.toString().contains("alipay")) {
						
						
							System.out.println("alipay"+listFiles[i].getAbsolutePath());
						
						
					}
					if (read.toString().contains("weixin")) {
						
							System.out.println("weixin"+listFiles[i].getAbsolutePath());
						
							
						
					}
					if (read.toString().contains("Weixin")) {
						
							
							System.out.println("Weixin"+listFiles[i].getAbsolutePath());
						
						
					}
					if (read.toString().contains("WX")) {
						
						
					//	System.out.println("WX"+listFiles[i].getAbsolutePath());
				
						//System.out.println(listFiles[i].getAbsolutePath());
					}
					if (read.toString().contains("wechat")) {
						
						
						System.out.println("wechat"+listFiles[i].getAbsolutePath());
				
						System.out.println(listFiles[i].getAbsolutePath());
					}
					//tg_hxmayi_select_pay_wechat
					if (read.toString().contains("Wechat")) {
						
					
						System.out.println("Wechat"+listFiles[i].getAbsolutePath());
				
						
						}
					if (read.toString().contains("loadUrl")) {
						
						
						System.out.println("loadUrl："+listFiles[i].getAbsolutePath()+"+++++++++++++++++++++++++++++++++++++++++++++");
				
						
						}
					//android.intent.action.VIEW
					if (read.toString().contains("android.intent.action.VIEW")) {
						
						
						System.out.println("android.intent.action.VIEW"+listFiles[i].getAbsolutePath());
				
						
						}
					}
					
				}
				//
			}
			
		}else {
			System.out.println("不是文件");
		}
	}
	
	public static void checkfile(String path){
		//System.out.println("+++++++++"+path);
		File file = new File(path);
		if (file.isDirectory()) {
			//file.list()
			File[] listFiles = file.listFiles();
			for (int i = 0; i < listFiles.length; i++) {
				File file2 = new File(listFiles[i].getAbsolutePath());
				
			
				//System.out.println(file2.getAbsolutePath());
				if (file2.isDirectory()) {
					//System.out.println(file2.getAbsolutePath());
					checkfile(listFiles[i].getAbsolutePath());
				}else {
					String temppath=listFiles[i].getAbsolutePath();
					//AndroidManifest
					if ((temppath.replace(packagename, "temp")).contains("vivo")||(temppath.contains("assets"))||(temppath.contains("cocos2dx"))||(temppath.contains("AndroidManifest"))) {
						//System.out.println("vivo的文件："+listFiles[i].getAbsolutePath());
					}else{
						
						String read = Filetextutils.read(listFiles[i].getAbsolutePath());
						if (read.toString().contains("YSDK_USER_WX")) {
							System.out.println("++++++++++:"+listFiles[i].getAbsolutePath());
						}
					if (read.toString().contains("Alipay")) {
						
							read=read.replace("Alipay", "temp");
							Filetextutils.write(listFiles[i].getAbsolutePath(), false, read);
							System.out.println("Alipay"+listFiles[i].getAbsolutePath());
					
							String tempname=listFiles[i].getAbsolutePath();
							tempname=tempname.replace("Alipay", "temp");
							listFiles[i].renameTo(new File(tempname));
					}
					if (read.toString().contains("alipay")) {
						
							read=read.replace("alipay", "temp");
							Filetextutils.write(listFiles[i].getAbsolutePath(), false, read);
							System.out.println("alipay"+listFiles[i].getAbsolutePath());
						
							String tempname=listFiles[i].getAbsolutePath();
							tempname=tempname.replace("alipay", "temp");
							listFiles[i].renameTo(new File(tempname));
						System.out.println("alipay"+listFiles[i].getAbsolutePath());
					}
					if (read.toString().contains("weixin")) {
						
							read=read.replace("weixin", "temp");
							Filetextutils.write(listFiles[i].getAbsolutePath(), false, read);
							System.out.println("weixin"+listFiles[i].getAbsolutePath());
						
							
						System.out.println("weixin"+listFiles[i].getAbsolutePath());
					}
					if (read.toString().contains("Weixin")) {
						
							read=read.replace("Weixin", "temp");
							Filetextutils.write(listFiles[i].getAbsolutePath(), false, read);
							System.out.println("Weixin"+listFiles[i].getAbsolutePath());
						
						System.out.println("Weixin"+listFiles[i].getAbsolutePath());
					}
					if (read.toString().contains("WX")) {
						
						
				
						//System.out.println("WX"+listFiles[i].getAbsolutePath());
					}
					if (read.toString().contains("wechat")) {
						
						read=read.replace("wechat", "temp");
						Filetextutils.write(listFiles[i].getAbsolutePath(), false, read);
						System.out.println("wechat"+listFiles[i].getAbsolutePath());
				
						System.out.println(listFiles[i].getAbsolutePath());
					}
					//tg_hxmayi_select_pay_wechat
					if (read.toString().contains("Wechat")) {
						
						read=read.replace("Wechat", "temp");
						Filetextutils.write(listFiles[i].getAbsolutePath(), false, read);
						System.out.println("Wechat"+listFiles[i].getAbsolutePath());
				
						System.out.println(listFiles[i].getAbsolutePath());
						}
					
                   if (read.toString().contains("android.intent.action.VIEW")) {
                		read=read.replace("android.intent.action.VIEW", "temp");
						Filetextutils.write(listFiles[i].getAbsolutePath(), false, read);
						System.out.println("android.intent.action.VIEW"+listFiles[i].getAbsolutePath());
						
						//System.out.println("android.intent.action.VIEW"+listFiles[i].getAbsolutePath());
				
						
						}
				
					}
					
				}
				//
			}
			
		}else {
			System.out.println("不是文件");
		}
	}
	public static void checkfileu(String path){
		//System.out.println("+++++++++"+path);
		File file = new File(path);
		if (file.isDirectory()) {
			//file.list()
			File[] listFiles = file.listFiles();
			for (int i = 0; i < listFiles.length; i++) {
				File file2 = new File(listFiles[i].getAbsolutePath());
				
			
				//System.out.println(file2.getAbsolutePath());
				if (file2.isDirectory()) {
					//System.out.println(file2.getAbsolutePath());
					checkfileu(listFiles[i].getAbsolutePath());
				}else {
					String temppath=listFiles[i].getAbsolutePath();
					//AndroidManifest
					if ((temppath.replace(packagename, "temp")).contains("vivo")||(temppath.contains("assets"))||(temppath.contains("cocos2dx"))||(temppath.contains("AndroidManifest"))) {
						//System.out.println("vivo的文件："+listFiles[i].getAbsolutePath());
					}else{
						
						String read = Filetextutils.read(listFiles[i].getAbsolutePath());
						if (read.toString().contains("YSDK_USER_WX")) {
							//System.out.println("YSDK_USER_WX++++++++++:"+listFiles[i].getAbsolutePath());
						}
						if (read.toString().contains("code:")&&read.toString().contains("YSDK_USER_WX")) {
							System.out.println("code++++++++++:"+listFiles[i].getAbsolutePath());
						}
					
				
					}
					
				}
				//
			}
			
		}else {
			System.out.println("不是文件");
		}
	}
}
