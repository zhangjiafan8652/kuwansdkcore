package com.yayawan.impl;

import android.app.Activity;
import android.widget.Toast;

import com.yayawan.callback.YYWExitCallback;
import com.yayawan.callback.YYWUserManagerCallBack;
import com.yayawan.proxy.YYWUserManager;
import com.yayawan.sdk.bean.User;
import com.yayawan.sdk.callback.KgameSdkCallback;
import com.yayawan.sdkmain.DgameSdk;
import com.yayawan.utils.DeviceUtil;

public class UserManagerImpl implements YYWUserManager {

	@Override
	public void manager(Activity paramActivity) {

		Toast.makeText(paramActivity, "个人中心", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void login(Activity paramActivity, String paramString,
			Object paramObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logout(Activity paramActivity, String paramString,
			Object paramObject) {
		

	}

	@Override
	public void setUserListener(Activity paramActivity,
			YYWUserManagerCallBack paramXMUserListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit(final Activity paramActivity, final YYWExitCallback callback) {
		// TODO Auto-generated method stub
		// Toast.makeText(paramActivity, "退出游戏", Toast.LENGTH_SHORT).show();
		if (DeviceUtil.getGameInfo(paramActivity, "addexit").equals("yes")) {
			paramActivity.runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					DgameSdk.Exitgame(paramActivity, new KgameSdkCallback() {
						
						public void onSuccess() {
							// TODO Auto-generated method stub
							//exitCallBack.onExit();
						
							//paramActivity.finish();
						}

						@Override
						public void onCancel() {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onError(int arg0) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onLogout() {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onSuccess(User arg0, int arg1) {
							// TODO Auto-generated method stub
							//Yayalog.loger("进来了添加退出框的退出");
							callback.onExit();
						}

					
					});
				}
			});
			
		}else {
			
			//Toast.makeText(paramActivity, "退出游戏", Toast.LENGTH_SHORT).show();
			//Yayalog.loger("进来了不添加退出框的退出");
			callback.onExit();
			//paramActivity.finish();
		}
	}

	@Override
	public void setRoleData(Activity arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setData(Activity arg0, String arg1, String arg2, String arg3,
			String arg4, String arg5, String arg6, String arg7) {
		// TODO Auto-generated method stub
		
	}

}