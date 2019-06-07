package com.jiafancreatezipfile;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainthread {

	private static Uishow uishow;

	public static void main(String[] args) {
		
		uishow = new Uishow();
		uishow.but_fanbianyi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println(uishow.tx_sdkworkspace.getText());
				Myconstant.apktoolpath=uishow.tx_japktoolpath.getText();
				Myconstant.sdkpath=uishow.tx_sdkpath.getText();
				Myconstant.sdkworkspace=uishow.tx_sdkworkspace.getText();
				//System.out.println(Myconstant.sdkworkspace);
				Cmd.apktooljieya(Myconstant.sdkpath);
				System.out.println("第二步");
				Mainthread2.createZip(uishow.jLabel4);
				System.out.println("第三步");
				Cmd.startApkroot();
			}
		});
		uishow.but_tozip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Mainthread2.createZip(uishow.jLabel4);
			}
		});
		
		uishow.but_root.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Cmd.startApkroot();
			}
		});
		
	
	}
	
	public void reumengXML(String xmlpath){
		
		
	}
}
