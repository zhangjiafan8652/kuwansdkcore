package com.jiafancreatezipfile;

import java.io.File;

public class ninepngreset {

	
	public static String packagename="com.rxzb.yyw";
	public static String filepath="F:\\0azhangjiafan\\tmp\\ApkIDE\\Work\\"+packagename;
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(filepath+File.separator+"res");
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (int i = 0; i < listFiles.length; i++) {
				File file2 = new File(listFiles[i].getAbsolutePath());
				if (file2.isDirectory()) {
					File[] listFiles2 = 	file2.listFiles();
					for (int j = 0; j < listFiles2.length; j++) {
						String filePath = listFiles2[j].getAbsolutePath();
						if (filePath.contains(".9.")) {
							System.out.println(filePath);
							String filename=listFiles2[j].getName();
							
							listFiles2[j].renameTo(new File(listFiles2[j].getAbsolutePath().replace(".9.png", ".png")));
						}
					}
				}
				
			}
		}
	}

}
