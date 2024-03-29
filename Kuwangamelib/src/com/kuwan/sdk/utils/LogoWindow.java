package com.kuwan.sdk.utils;

import java.lang.reflect.Field;

import javax.crypto.spec.IvParameterSpec;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.opengl.Visibility;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import com.kuwan.sdk.login.Help_dissmiss_dialog;
import com.kuwan.sdk.login.SmallHelpActivity;
import com.kuwan.sdk.main.KgameSdk;
import com.kuwan.sdk.utils.ShakeListener.OnShakeListener;
import com.kuwan.sdk.xml.DisplayUtils;
import com.kuwan.sdk.xml.GetAssetsutils;
import com.kuwan.utils.DeviceUtil;
import com.kuwan.utils.Yayalog;


/**
 * 
 * @author zjf
 * 
 */
public class LogoWindow {

	private static WindowManager wm;
	private static WindowManager.LayoutParams params;
	Context con;
	public boolean isadd = false;

	static Activity mactivity;
	private static int screenHeigh;
	private static int up_x;
	private static int event_getRawY;
	private static int event_getY;

	private static LogoWindow mLogowindow;

	public static LogoWindow getInstants(Activity mactivity) {
		if (mLogowindow == null) {
			Yayalog.loger("重新new了mlogowindow");

			mLogowindow = new LogoWindow(mactivity);

		} else {
			Yayalog.loger("mlo不为空");
		}
		// mLogowindow.mactivity
		return mLogowindow;

	}

	private LogoWindow(Activity co) {

		mactivity = co;

		createView();

	}

	public static Handler mhandler = new Handler() {
		@Override
		public void dispatchMessage(Message msg) {
			// TODO Auto-generated method stub
			super.dispatchMessage(msg);
			switch (msg.what) {
			case 1:
				if (myviewicon != null && params.x == 0) {
					//半透明隐藏图标
					myviewicon.setImageBitmap(GetAssetsutils
							.getImageFromAssetsFile("yaya1_acountmanagericon.png",
									mactivity));
				}
			case 2:
//				Log.i("tag","up_x ="+up_x);
//				Log.i("tag","SmallHelpActivity.isclose ="+SmallHelpActivity.isclose);
//				if(up_x < phonePoint.x/2 || SmallHelpActivity.isclose == 1){
					//半透明隐藏图标
					myviewicon.setImageBitmap(GetAssetsutils
							.getImageFromAssetsFile("yaya1_acountmanagericontouming.png",
									mactivity));
//				}else{
//					//半透明隐藏图标
//					myviewicon.setImageBitmap(GetAssetsutils
//							.getImageFromAssetsFile("yaya1_acountmanagericontoumingright.png",
//									mactivity));
//				}
			case 521:
				// createView();
				Yayalog.loger("我在接到了消息：hasWindowFocus"
						+ mactivity.hasWindowFocus() + "hasview:" + hasview);
				if (mactivity.hasWindowFocus() && !hasview) {
					addView();
					Yayalog.loger("mactivity.hasWindowFocus()+添加了view");
				} else {
					Yayalog.loger("我在发消息");
					if (hasview) {

					} else {
						mhandler.sendEmptyMessageDelayed(521, 500);
					}

				}

				break;

			default:
				break;
			}
		}
	};
	private boolean ishelpshow = false;

	private ShakeListener shakeListener;
	private static ImageView myviewiconmanager;
	private static ImageView myviewicon;
	private static RelativeLayout myview;
	
	public static Point phonePoint;

	private void createView() {

		Yayalog.loger("兔子oncreate");
		DisplayMetrics dm = new DisplayMetrics();

		mactivity.getWindowManager().getDefaultDisplay().getMetrics(dm);

		phonePoint = getHeightAndWidth(mactivity);
		
		screenHeigh = dm.heightPixels;
		wm = ((WindowManager) mactivity.getSystemService("window"));
		if (myview == null) {

			 myview = new RelativeLayout(mactivity);
			 LayoutParams layoutParams = new LinearLayout.LayoutParams(-2,
						machSize(100));
			 layoutParams.setMargins(0, 0, 0, 0);
			 myview.setLayoutParams(layoutParams);
			
			myviewicon = new ImageView(mactivity);
			// 创建时设置view的正常参数
			// myview.setX(-machSize(0));
			// myview.setRotation(0);
			// myview.setAlpha(225);
			
			//小助手icon
			
			myviewicon.setLayoutParams(new RelativeLayout.LayoutParams(-2,
					machSize(100)));

			myviewicon.setImageBitmap(GetAssetsutils.getImageFromAssetsFile(
					"yaya1_acountmanagericon.png", mactivity));
			
			//开局就隐藏
			new Handler().postDelayed(new Runnable() {
				
				@Override
				public void run() {
					myviewicon.setImageBitmap(GetAssetsutils.getImageFromAssetsFile(
							"yaya1_acountmanagericontouming.png", mactivity));
				}
			}, 1000);
			
			//整个小助手
			myviewiconmanager = new ImageView(mactivity);
			// 创建时设置view的正常参数
			// myview.setX(-machSize(0));
			// myview.setRotation(0);
			// myview.setAlpha(225);
			myviewiconmanager.setLayoutParams(new LinearLayout.LayoutParams(machSize(346),
					machSize(100)));

			myviewiconmanager.setImageBitmap(GetAssetsutils.getImageFromAssetsFile(
					"yaya1_acountmanager.png", mactivity));
			
			//myview.addView(myviewiconmanager);
			myview.addView(myviewicon);
			
			
			myview.setOnTouchListener(new OnTouchListener() {

				float x;
				float y;

				private float mTouchX;
				private float mTouchY;

				private float mTempX;
				private float mTempY;
				private float mdownTempX;
				private float mdownTempY;
				private long ontouchtime;

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					// TODO Auto-generated method stub
					x = event.getRawX();
					y = event.getRawY(); // statusBarHeight是系统状态栏的高度

					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN: // 捕获手指触摸按下动作
						// 获取相对View的坐标，即以此View左上角为原点
						mTouchX = event.getX();
						mTouchY = event.getY();

						mdownTempX = event.getRawX();
						mdownTempY = event.getRawY();

						ontouchtime = System.currentTimeMillis();
						

						myviewicon.setImageBitmap(GetAssetsutils
								.getImageFromAssetsFile("yaya1_acountmanagericon.png",
										mactivity));
						break;

					case MotionEvent.ACTION_MOVE: // 捕获手指触摸移动动作

						updateViewPosition();

						int distance_x = (int) event.getRawX()
								- (int) mdownTempX;
						int distance_y = (int) event.getRawY()
								- (int) mdownTempY;

						
						if (Math.abs(distance_x) > 40
								&& Math.abs(distance_y) > 40) {

							if (!ishelpshow) {

//								new Help_dissmiss_dialog(mactivity).dialogShow();

								ishelpshow = true;

							}
							

							// YayaWan.stop(mActivity);
							// return false;
						}
						break;

					case MotionEvent.ACTION_UP: // 捕获手指触摸离开动作
						
						up_x = (int)event.getRawX();
						event_getRawY = (int)event.getRawY();
						event_getY = (int)event.getY();
						
						distance_x = (int) event.getRawX() - (int) mdownTempX;
						distance_y = (int) event.getRawY() - (int) mdownTempY;
						if (Math.abs(distance_x) <= 40
								&& Math.abs(distance_y) <= 40) {

							if ((System.currentTimeMillis() - ontouchtime) > 1500) {
//								 KgameSdk.stop(mactivity);
								// 这里关闭了永久隐藏
								
							} else {
								int tempx=(int) event.getX();
								Yayalog.loger("打开账户");
								onClick(1);
						
							}

							
						} else {
							if (event.getRawX() < phonePoint.x/2) {
								updateViewPosition1();
							}else{
								updateViewPosition2();
							}
							
						}
						ishelpshow = false;
						break;
					}
					return true;
				}

				private void updateViewPosition() {

					params.x = (int) (x - mTouchX);

					params.y = (int) (screenHeigh - y - mTouchY);

					wm.updateViewLayout(myview, params);

				}

				private void updateViewPosition1() {

					params.x = 0;

					params.y = (int) (screenHeigh - y - mTouchY);
					// myview.setX(-machSize(30));
					// myview.setRotation(50);
					// myview.setAlpha(100);
					Yayalog.loger("我要更新ui去隐藏了" +
							"");
					wm.updateViewLayout(myview, params);
					//myview.setBackgroundColor(Color.GRAY);
					//半透明隐藏图标
					new Handler().postDelayed(new Runnable() {
						
						@Override
						public void run() {
							myviewicon.setImageBitmap(GetAssetsutils
									.getImageFromAssetsFile("yaya1_acountmanagericontouming.png",
											mactivity));
						}
					}, 500);
					myviewiconmanager.setVisibility(View.GONE);
					// myview.startAnimation(alphaAnimation);

				}

				private void updateViewPosition2() {

					params.x = (int)phonePoint.x;

					params.y = (int) (screenHeigh - y - mTouchY);

					Yayalog.loger("我要更新ui去隐藏了" +
							"");
					wm.updateViewLayout(myview, params);
					//半透明隐藏图标
					new Handler().postDelayed(new Runnable() {
						
						@Override
						public void run() {
							myviewicon.setImageBitmap(GetAssetsutils
									.getImageFromAssetsFile("yaya1_acountmanagericontoumingright.png",
											mactivity));
						}
					}, 500);
					myviewiconmanager.setVisibility(View.GONE);

				}
			});

		}

		params = new WindowManager.LayoutParams();
		params.format = PixelFormat.RGBA_8888;
		params.type = 1000;
		params.flags = 40;
		// params.flags |= 262144;
		// params.flags |= 512;
		params.gravity = 83;
		params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
		params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
		params.alpha = (float) 1;

		params.x = 0;
		if (DeviceUtil.getGameInfo(mactivity, "kuwan_orientation").equals(
				"landscape")) {
			params.y = machSize(360);
		} else {
			params.y = machSize(600);
		}

		// 摇一摇监听..分别在oncreate和destory中开始监听和关闭监听
		shakeListener = new ShakeListener(mactivity);
		shakeListener.setOnShakeListener(new OnShakeListener() {

			@Override
			public void onShake() {
				// TODO Auto-generated method stub
				Yayalog.loger("再要");
				 KgameSdk.init(mactivity);
			}
		});

	}

	private Point getHeightAndWidth(Activity activity) {
			int width = activity.getWindowManager().getDefaultDisplay().getWidth();
			int height = activity.getWindowManager().getDefaultDisplay().getHeight();
			Point size = new Point(width,height);
			return size;
	}

	// 添加
	private static void addView() {

		wm.addView(myview, params);
		hasview = true;
	}

	private void onClick(int i) {
		// TODO Auto-generated method stub
		// if (id == ResourceUtil.getId(mContext, "iv_floating_icon")) {
		// YayaWan.stop(mactivity);
		// 打开选择窗口
		 KgameSdk.accountManager(mactivity,i);
	}

	public void start() {
		// 停止摇一摇监听
		Yayalog.loger("开始监听暂停");
		shakeListener.stop();
		// System.out.println("1");
		
		mhandler.sendEmptyMessageAtTime(521, 1500);

	}

	public static boolean hasview = false;

	public void Stop() {
		// 开始摇一摇监听
		shakeListener.start();
		Yayalog.loger("暂停监听开始");
		if (hasview) {

			Yayalog.loger("暂停监听开始mLogowindow = null");

			SmallHelpActivity.isclose =1;
			wm.removeView(myview);
			mLogowindow = null;
			hasview = false;

		}
	}

	/**
	 * 将720像素转成其他像素值
	 * 
	 * @param size
	 * @return
	 */
	private static int machSize(int size) {

		int dealWihtSize = DisplayUtils.dealWihtSize(size, mactivity);

		return dealWihtSize;
	}

	/**
	 * 获取某个view的x位置
	 * 
	 * @param view
	 * @return
	 */
	public int getViewX(View view) {
		int[] locations = new int[2];
		view.getLocationOnScreen(locations);
		int kx = locations[0];// 获取组件当前位置的横坐标
		return kx;
	}

	private int getStatusBarHeight(Activity macActivity) {
		Class<?> c = null;
		Object obj = null;
		Field field = null;
		int x = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			int dimensionPixelSize = macActivity.getResources()
					.getDimensionPixelSize(x);
			System.out.println("状态栏高度" + dimensionPixelSize);
			return dimensionPixelSize;
		} catch (Exception e1) {
			// Log.d(TAG, "get status bar height fail");
			// e1.printStackTrace();
			System.out.println("获取状态栏高度失败");
			return 75;
		}
	}
	
	
}
