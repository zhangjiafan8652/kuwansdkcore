package com.ceshi.demo;

import com.yayawan.callback.YYWAnimCallBack;
import com.yayawan.main.YaYaWan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/** 
 * 1.闪屏动画,在游戏启动时的第一个页面出现..只要保证游戏画面出来前调用即可 YaYaWan.getInstance().anim(this, new
* YYWAnimCallBack(){})
* 注意:闪屏回调有三种情况..不管闪屏失败还是成功.都应该进入游戏画面..也就是说,不管闪屏失败还是成功.游戏继续进行
* */
public class SplashActivity extends Activity{

	
	public static Activity macitivity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		macitivity=this;
		
		YaYaWan.getInstance().launchActivityOnCreate(this);
		
		
		YaYaWan.getInstance().anim(this, new YYWAnimCallBack() {
			
			@Override
			public void onAnimSuccess(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(macitivity,GameActivity.class);
				macitivity.startActivity(intent);
				finish();
			}
			
			@Override
			public void onAnimFailed(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimCancel(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);	
		YaYaWan.getInstance().launchActivityonOnNewIntent(intent);
		
	}
}
