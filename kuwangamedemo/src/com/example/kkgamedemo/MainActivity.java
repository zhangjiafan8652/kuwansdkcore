package com.example.kkgamedemo;

import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.kuwan.callback.YYWAnimCallBack;
import com.kuwan.callback.YYWExitCallback;
import com.kuwan.callback.YYWPayCallBack;
import com.kuwan.callback.YYWUserCallBack;
import com.kuwan.domain.YYWOrder;
import com.kuwan.domain.YYWUser;
import com.kuwan.main.Kuwangame;
import com.kuwan.sdk.other.JFnoticeUtils;





public class MainActivity extends Activity {

	private TextView tv_view;

	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		
		
		switch (ev.getAction()){
        case MotionEvent.ACTION_DOWN:
        	// 手指按下
            break;
        case MotionEvent.ACTION_MOVE:
            // 手指移动
            break;
        case MotionEvent.ACTION_UP:
            // 手指抬起
            break;
        case MotionEvent.ACTION_CANCEL:
            // 事件被拦截 
            break;
        case MotionEvent.ACTION_OUTSIDE:
            // 超出区域 
            break;
    }
		
		return super.dispatchTouchEvent(ev);
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("oncreate");

		Kuwangame.getInstance().initSdk(this);
		Kuwangame.getInstance().onCreate(this);

		final LinearLayout mLinearLayout = new LinearLayout(this);

		mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

		mLinearLayout.setOrientation(LinearLayout.VERTICAL);
		mLinearLayout.setPadding(10, 10, 10, 10);

		Button animButton = new Button(this);
		animButton.setText("anim");
		animButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				anim(mLinearLayout);
				//	new StopManagerWarning_dialog(MainActivity.this).dialogShow();
			}
		});

		mLinearLayout.addView(animButton, new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		Button updateButton = new Button(this);
		updateButton.setText("update");
		updateButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				upDate();
			}

		});

		Button lgoinButton = new Button(this);
		lgoinButton.setText("login");
		lgoinButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				login(mLinearLayout);

			}
		});
		mLinearLayout.addView(lgoinButton, new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		Button payButton = new Button(this);
		payButton.setText("pay");
		payButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pay(mLinearLayout);

			}
		});
		mLinearLayout.addView(payButton, new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		Button extButton = new Button(this);
		extButton.setText("exit");
		extButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				exit(mLinearLayout);

			}
		});
		mLinearLayout.addView(extButton, new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		setContentView(mLinearLayout);

		Button versionButton = new Button(this);
		versionButton.setText("获取sdk版本号");
		versionButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				getversion(mLinearLayout);

			}

		});

		Button inintButton = new Button(this);
		inintButton.setText("无闪屏时的init接口");
		inintButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				initsdk(mLinearLayout);

			}

		});
		mLinearLayout.addView(versionButton, new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		Button logoutButton = new Button(this);
		logoutButton.setText("注销账号");
		logoutButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Logout();

			}

		});
		mLinearLayout.addView(logoutButton, new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		tv_view = new TextView(this);
		// logoutButton.setText("注销账号");
		mLinearLayout.addView(tv_view, new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		
		Button noticeButton = new Button(this);
		noticeButton.setText("测试公告");
		noticeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Ceshinotice();

			}

		

		});
		mLinearLayout.addView(noticeButton, new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		tv_view = new TextView(this);
		// logoutButton.setText("注销账号");
		mLinearLayout.addView(tv_view, new LinearLayout.LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		
		
		setContentView(mLinearLayout);
		
		//DgameSdk.addPaomadengView(this);

	}

	public void Demologin() {

	}

	/**
	 * 注销账号...使用场景,如果游戏内有注销账号的功能按钮,则点击按钮后,.调用此方法注销账号...
	 * 回调成功后在onlogout中进行回到登录页面的操作
	 */
	protected void Logout() {
		// TODO Auto-generated method stub
		Kuwangame.getInstance().logout(null, new YYWUserCallBack() {

			@Override
			public void onLoginSuccess(YYWUser paramUser, Object paramObject) {
				// TODO Auto-generated method stub
				System.out.println("登陆取消");
			}

			@Override
			public void onLoginFailed(String paramString, Object paramObject) {
				// TODO Auto-generated method stub
				System.out.println("登陆取消");
			}

			@Override
			public void onLogout(Object paramObject) {
				// TODO Auto-generated method stub
				System.out.println("切换账号");
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				System.out.println("登陆取消");
			}

		});
	}

	/**
	 * 更新接口
	 */
	public void upDate() {

	}

	public void anim(View v) {

	//	Kuwangame.getInstance().setData(this, "1", "张珈凡", "1", "1", "无敌真寂寞", "1", "0");

		Kuwangame.getInstance().anim(this, new YYWAnimCallBack() {

			@Override
			public void onAnimSuccess(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "播放动画回调", Toast.LENGTH_SHORT)
						.show();

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

	public void login(View v) {
		System.out.println("登录");
		Kuwangame.getInstance().login(this, new YYWUserCallBack() {

			@Override
			public void onLogout(Object arg0) {
				Toast.makeText(MainActivity.this, "退出", Toast.LENGTH_SHORT)
						.show();

			}

			@Override
			public void onLoginSuccess(YYWUser user, Object arg1) {
				// TODO Auto-generated method stub
				System.out.println("登录成功" + user);
				Toast.makeText(MainActivity.this, "登录成功" + user,
						Toast.LENGTH_SHORT).show();
				// textxinx=user.toString()+"/n/r";
				// tv_view.setText(textxinx);
				// 登录成功后设置角色数据
				Kuwangame.getInstance().setData(MainActivity.this, user.uid,
						user.userName, "11", "1", "无尽之海",
						System.currentTimeMillis() / 1000 + "", "1");
			}

			@Override
			public void onLoginFailed(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				System.out.println("失败");
				Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				System.out.println("取消");
				Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT)
						.show();

			}

		});
	}

	public void pay(View v) {

		YYWOrder order = new YYWOrder(UUID.randomUUID().toString(), "大罗鞭",
				100l, "");

		Kuwangame.getInstance().pay(this, order, new YYWPayCallBack() {
			@Override
			public void onPaySuccess(YYWUser arg0, YYWOrder arg1, Object arg2) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "充值成功回调", Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void onPayFailed(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				System.out.println("支付失败");
			}

			@Override
			public void onPayCancel(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				System.out.println("支付退出");
			}
		});
	}

	/**
	 * 获取sdk版本号
	 * 
	 * @param mLinearLayout
	 */
	private void getversion(LinearLayout mLinearLayout) {
		// TODO Auto-generated method stub

	}

	/**
	 * 退出接口
	 * 
	 * @param v
	 */
	public void exit(View v) {
		System.out.println("登录");

	  
		//finish();
		Kuwangame.getInstance().exit(this, new YYWExitCallback() {

			@Override
			public void onExit() {
				Toast.makeText(MainActivity.this, "退出回调", Toast.LENGTH_SHORT)
						.show();
			
			}
		});
		// Adtest.windowsad(this);
	}

	/**
	 * 无法接闪屏时的init接口
	 * 
	 * @param mLinearLayout
	 */
	private void initsdk(LinearLayout mLinearLayout) {
		// TODO Auto-generated method stub
		Kuwangame.getInstance().initSdk(this);
	}
	
	//测试公告
	private void Ceshinotice() {
		// TODO Auto-generated method stub
		// 获取公告
			new JFnoticeUtils().getNotice(this);
	//	com.yayawan.sdk.utils.MybitmapUtils.savePasswordtoBitmap("fjdlas", "kk1234325",this);
	}
	

	// 游戏中调出sdk小助手可选
	public void accountManage(View v) {
		Kuwangame.getInstance().manager(this);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		System.out.println("onrestart");
		Kuwangame.getInstance().onRestart(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		System.out.println("onresume");
		Kuwangame.getInstance().onResume(this);
		// Kuwangame.getInstance().onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		Kuwangame.getInstance().onPause(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		Kuwangame.getInstance().onStop(this);
	}

	@Override
	protected void onDestroy() {
		Kuwangame.getInstance().onDestroy(this);
		super.onDestroy();
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		System.out.println("onActivityResult");
		// Yayalog.loger("demoonActivityResult");
		Kuwangame.getInstance().onActivityResult(this, requestCode, resultCode,
				data);

	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		Kuwangame.getInstance().onNewIntent(intent);
	}

	public void onWindowFocusChanged(boolean hasFocus) {

	};

	
	
	
	public static String addtext="";

	 
	 public void destory(){
		 
	 }
	 
	 
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//Kuwangame.getInstance().onTouchEvent(event);
		return super.onTouchEvent(event);
	}
}
