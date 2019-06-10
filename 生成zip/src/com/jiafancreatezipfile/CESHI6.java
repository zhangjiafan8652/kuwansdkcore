package com.jiafancreatezipfile;

import java.io.File;
import java.util.UUID;

public class CESHI6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(UUID.randomUUID().toString().length());
		String pat="D:\\kuwanworkspace\\Sdkoppowangyou";
		//File file = new File("D:\\kuwanworkspace\\Kuwangamelib");
		bianli(pat);
	/*	String[] list = file.list();
		File[] listFiles = file.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			System.out.println(listFiles[i].getAbsolutePath());
			
			String read = Filetextutils.read(listFiles[i].getAbsolutePath());
			String temread=read.replace("'/", "os.pathsep+\'");
			String temread1=temread.replace("/", "\'   + os.pathsep + \'");
			Filetextutils.write(listFiles[i].getAbsolutePath(), false, temread1);
		}*/
	}
	
	public static void bianli(String path){
		
	    File file = new File(path);
		
		
		File[] listFiles = file.listFiles();
		
		for (int i = 0; i < listFiles.length; i++) {
			System.out.println(listFiles[i].getAbsolutePath());
			if (listFiles[i].isDirectory()) {
				if (listFiles[i].getName().equals("yayawan")) {
					listFiles[i].renameTo(new File(path+file.separator+"kuwan"));
					bianli(path);
					return;
				}else if(listFiles[i].getName().equals("kkgame")){
					System.out.println(listFiles[i].getAbsolutePath());
					listFiles[i].renameTo(new File(path+file.separator+"kuwan"));
					
					System.out.println("当前path："+listFiles[i].getAbsolutePath()+"重命名为："+path+file.separator+"kuwan");
					System.out.println("准备重新遍历path："+path);
					bianli(path);
					return;
				}else {
					bianli(path+file.separator+listFiles[i].getName());
				}
			}else {
				if (listFiles[i].getName().contains(".jar")) {
					
				}else {
					String read = Filetextutils.read(listFiles[i].getAbsolutePath());
					String temread=read.replace("yayawan", "kuwan");
					String temread1=temread.replace("kkgame", "kuwan");
					Filetextutils.write(listFiles[i].getAbsolutePath(), false, temread1);
				}
				
			}
			
		}
		
		
	}
	

}
