package com.ceshi.demo;

import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.kuwan.callback.YYWAnimCallBack;
import com.kuwan.callback.YYWExitCallback;
import com.kuwan.callback.YYWPayCallBack;
import com.kuwan.callback.YYWUserCallBack;
import com.kuwan.domain.YYWOrder;
import com.kuwan.domain.YYWUser;
import com.kuwan.main.Kuwangame;
import com.tencent.tmgp.yjxysml.R;

/**
 * 
 * 
 * 1.sdk初始化方法。在主activity oncreate 最开始处调用
 * 
 * 
 * Kuwangame.getInstance().initSdk(mActivity);
 * 
 * 2.复写生命周期方法,里面调用
 * Kuwangame.getInstance().onCreate(this);
 * Kuwangame.getInstance().onRestart(this); Kuwangame.getInstance().onResume(this);
 * Kuwangame.getInstance().onPause(this); Kuwangame.getInstance().onStop(this);
 * Kuwangame.getInstance().onDestroy(this);
 * Kuwangame.getInstance().onActivityResult(this, requestCode, resultCode, data);
 * Kuwangame.getInstance().onNewIntent(intent);
 * Kuwangame.getInstance().onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults)；
 * 

 * 
 * 3.登录接口. Kuwangame.getInstance().login(this, new YYWUserCallBack()} 如下面的例子:
 * 注意:登录有三个回调..第一个成功,第二个取消...注意第三个是登出..登出则是用户点击了sdk中的切换账号按钮,游戏应该注销账户 回到游戏的登录页面..
 * 
 * 4.设置角色数据Kuwangame.getInstance().setData(paramActivity, roleId, roleName, roleLevel, zoneId, zoneName, roleCTime, ext);
				// 参数介绍 角色id 角色name 等级 区服id 区服名字 角色创建时间 附加信息
 * 
 * 5.支付接口 Kuwangame.getInstance().pay(this, order, new YYWPayCallBack()) 看例子:
 * 
 * 6.退出接口 Kuwangame.getInstance().exit(this, new YYWExitCallback() )
 * 
 * 
 * 
 * 7.游戏内注销按钮...(可选)应用场景,游戏内有注销账号的按钮..点击按钮后游戏自己退出游戏，在退出之前调用这个接口（这个接口无任何现象，
 * 仅仅是将sdk内账号清空） Kuwangame.getInstance().logout(GameActivity.this);
 * 
 * 
 * 8.复制拷贝androidmanifest文件配置
 * 
 * @author zjf
 * 
 */
public class GameActivity extends Activity {

	public Button animview, loginview, payview, exitview,logoutview;

	public LinearLayout llbackground;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demomain);
		yaya_init();
		Kuwangame.getInstance().onCreate(this);
		
		initView();
		//anim();
		 loginView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		animview = (Button) findViewById(R.id.amin);
		loginview = (Button) findViewById(R.id.login);
		payview = (Button) findViewById(R.id.pay);
		exitview = (Button) findViewById(R.id.exit);
		llbackground = (LinearLayout) findViewById(R.id.background);
		logoutview= (Button) findViewById(R.id.logout);
		animview.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				anim();
			}
		});
		//animview.setVisibility(View.GONE);
		loginview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				login();
			}
		});

		payview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pay();
			}
		});
		exitview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				exit();
			}
		});
		
		logoutview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Kuwangame.getInstance().logout(GameActivity.this);
				loginView();
			}
		});

	}

	/**
	 * 开始游戏
	 */
	public void loginView() {

		llbackground.setBackgroundResource(R.drawable.gamelogin);
		animview.setVisibility(View.VISIBLE);
		loginview.setVisibility(View.VISIBLE);
		payview.setVisibility(View.GONE);
		exitview.setVisibility(View.GONE);
		logoutview.setVisibility(View.GONE);
	}

	/**
	 * 游戏画面
	 */
	public void gameView() {
		llbackground.setBackgroundResource(R.drawable.gameplay);

		animview.setVisibility(View.GONE);
		loginview.setVisibility(View.GONE);
		payview.setVisibility(View.VISIBLE);
		exitview.setVisibility(View.VISIBLE);
		logoutview.setVisibility(View.VISIBLE);
	}

	/**
	 * 闪屏
	 */
	public void anim() {
		System.out.println("闪屏");

		
		
		Kuwangame.getInstance().anim(this, new YYWAnimCallBack() {
		    @Override
		    public void onAnimSuccess(String arg0, Object arg1) {
		        System.out.println("播放动画成功");
		       
		    }
		    @Override
		    public void onAnimFailed(String arg0, Object arg1) {
		         System.out.println("播放动画失败");
		    }
		    @Override
		    public void onAnimCancel(String arg0, Object arg1) {
		         System.out.println("播放动画退出");
		    }
		    });

	
	}

	/**
	 * 登陆
	 */
	public void login() {
		System.out.println("登录");
		Kuwangame.getInstance().login(this, new YYWUserCallBack() {

			@Override
			public void onLogout(Object arg0) {
				Toast.makeText(GameActivity.this, "账号退出，回到登陆页面",
						Toast.LENGTH_SHORT).show();
				loginView();
			}

			@Override
			public void onLoginSuccess(YYWUser user, Object arg1) {
				// TODO Auto-generated method stub
				System.out.println("登录成功" + user);
				Toast.makeText(GameActivity.this, "登录成功" + user,
						Toast.LENGTH_SHORT).show();
				

				// 登录成功设置角色数据方法

				// Kuwangame.getInstance().setData(paramActivity, roleId,
				// roleName, roleLevel, zoneId, zoneName, roleCTime, ext);
				// 参数介绍 角色id 角色name 等级 区服id 区服名字 角色创建时间 附加信息
				// 角色创建时间为秒 距离1970年的秒数，其中java可以用这个方法获取 long
				// startPaintLogoTime=System.currentTimeMillis()/1000;
				Kuwangame.getInstance().setData(GameActivity.this, user.uid,
						user.userName, "11", "1", "无尽之海",
						"" + System.currentTimeMillis() / 1000, "1");
				// 进入到游戏中
				gameView();
			}

			@Override
			public void onLoginFailed(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				System.out.println("失败");
				Toast.makeText(GameActivity.this, "失败", Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				System.out.println("取消");
				Toast.makeText(GameActivity.this, "取消", Toast.LENGTH_SHORT)
						.show();

			}

		});
	}

	/**
	 * 支付
	 */
	public void pay() {

		YYWOrder order = new YYWOrder(UUID.randomUUID().toString(), "霜之哀伤", 50l,
				"");

		Kuwangame.getInstance().pay(this, order, new YYWPayCallBack() {
			@Override
			public void onPaySuccess(YYWUser arg0, YYWOrder arg1, Object arg2) {
				// TODO Auto-generated method stub
				Toast.makeText(GameActivity.this, "充值成功回调", Toast.LENGTH_SHORT)
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
		// YYWMain.mUserCallBack.onLogout(null);
		// Toast.makeText(this, YayaWan.getSdkversion(), 0).show();
	}

	/**
	 * 退出接口
	 */
	public void exit() {
		System.out.println("登录");
		Kuwangame.getInstance().exit(this, new YYWExitCallback() {

			@Override
			public void onExit() {
				Toast.makeText(GameActivity.this, "退出回调", Toast.LENGTH_SHORT)
						.show();
				finish();
			}
		});
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
		super.onDestroy();
		Kuwangame.getInstance().onDestroy(this);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Kuwangame.getInstance().onActivityResult(this, requestCode, resultCode,
				data);

	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		Kuwangame.getInstance().onNewIntent(intent);
	}

	public  void yaya_init() {
		 Kuwangame.getInstance().initSdk(GameActivity.this);
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if(keyCode == KeyEvent.KEYCODE_BACK){
			Kuwangame.getInstance().exit(GameActivity.this, new YYWExitCallback() {

				@Override
				public void onExit() {
					Toast.makeText(GameActivity.this, "退出回调", Toast.LENGTH_SHORT)
							.show();
					finish();
				}
			});
		}
		return super.onKeyDown(keyCode, event);
	}
}
