package com.jiafancreatezipfile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Cmd {
	private static BufferedReader br;

	public static void execCommand(String arstringCommand) {
		try {
			Process p = Runtime.getRuntime().exec(arstringCommand,null,null);
			 //取得命令结果的输出流
            //输出流
            InputStream fis=p.getInputStream();
            //错误流
            InputStream ferrs=p.getErrorStream();
            //用一个读输出流类去读
            InputStreamReader isr=new InputStreamReader(fis);
            InputStreamReader errsr=new InputStreamReader(ferrs);
            //用缓冲器读行
            BufferedReader br=new BufferedReader(isr);
            BufferedReader errbr=new BufferedReader(errsr);
            String line=null;
            String lineerr = null;
            //直到读完为止
            while((line=br.readLine())!=null) {
            //有可能发生阻塞的问题
                    System.out.println("return input Str:" + line);
            }
            while((lineerr=errbr.readLine())!=null){
            //有可能发生阻塞的问题
                    System.out.println("return err Str:" + lineerr);
            }
            int exitVal = p.waitFor();
            System.out.println("exitVal:" + exitVal);


			p.waitFor();
			
			//p.destroy();
			System.out.println("我执行完了");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void apktooljieya(String apkname) {

		String sdkpath = Myconstant.sdkworkspace + apkname + "\\bin\\";
		String cmd2 = "cmd /c  " + Myconstant.apktoolpath + " d" + " -f "
				+ sdkpath + apkname + ".apk" + " -o " + Myconstant.apktoolpath
				+ "\\" + apkname;
		System.out.println(cmd2);
		execCommand(cmd2);
	}

	/**
	 * 解压对应路径下的apk包
	 * @param path  apk路径
	 */
	public static void apktooljieya1(String path,String apkname) {
		
		String sdkpath = path ;
		String cmd2 = "cmd /c  " + Myconstant.apktoolpath + " d" + " -f "
				+ sdkpath + apkname + ".apk" + " -o " + Myconstant.apktoolpath
				+ "\\" + apkname;
		System.out.println(cmd2);
		execCommand(cmd2);
	}

	public static void startApkroot() {
		String cmd2 = "cmd /c start " + Myconstant.apktoolpath + "\\";
		execCommand(cmd2);
	}
}
