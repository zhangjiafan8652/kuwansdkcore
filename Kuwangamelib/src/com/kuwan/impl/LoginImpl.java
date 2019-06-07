package com.kuwan.impl;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import com.kuwan.sdk.bean.User;
import com.kuwan.sdk.callback.KgameSdkUserCallback;
import com.kuwan.sdk.main.KgameSdk;
import com.kuwan.utils.Handle;
import com.kuwan.utils.Yayalog;
import com.kuwan.callback.YYWUserCallBack;
import com.kuwan.domain.YYWUser;
import com.kuwan.main.YYWMain;
import com.kuwan.proxy.YYWLoginer;

public class LoginImpl implements YYWLoginer {

    @Override
    public void login(final Activity paramActivity, YYWUserCallBack userCallBack, String paramString) {

    	//下载文件
    	
    	new Handler(Looper.getMainLooper()).post(new Runnable() {

    		
    		
    		
            @Override
            public void run() {
            	

			        KgameSdk.login(paramActivity, new KgameSdkUserCallback() {

			            @Override
			            public void onSuccess(User user, int arg1) {
			                if (YYWMain.mUserCallBack != null) {
			                    YYWUser yywUser = new YYWUser();
			                    yywUser.uid = user.uid + "";
			                    yywUser.icon = user.icon;
			                    yywUser.body = user.body;
			                    yywUser.lasttime = user.lasttime;
			                    yywUser.money = user.money;
			                    yywUser.nick = user.nick;
			                    yywUser.password = user.password;
			                    yywUser.phoneActive = user.phoneActive;
			                    yywUser.success = user.success;
			                    yywUser.token = user.token;
			                    yywUser.userName = user.userName;
			                    YYWMain.mUser=yywUser;
			                    YYWMain.mUserCallBack.onLoginSuccess(yywUser, "success");
			                    Handle.login_handler(paramActivity, yywUser.uid,  yywUser.userName);
			                }
			            }

			            @Override
			            public void onLogout() {
			            	KgameSdk.stop(paramActivity);
			                if (YYWMain.mUserCallBack != null) {
			                    YYWMain.mUserCallBack.onLogout("logout");
			                }
			                
			                
			            }

			            @Override
			            public void onError(int arg0) {
			            	
			                if (YYWMain.mUserCallBack != null) {
			                    YYWMain.mUserCallBack.onLoginFailed("failed", "");
			                }
			            }

			            @Override
			            public void onCancel() {
			                // TODO Auto-generated method stub
			            	if (YYWMain.mUserCallBack != null) {
			                    YYWMain.mUserCallBack.onCancel();
			                }
			            }
			        });

            	}

    	});

    }

    @Override
    public void relogin(Activity paramActivity, YYWUserCallBack userCallBack,
            String paramString) {
    		Yayalog.loger("yaya代理sdk注销");
    		KgameSdk.logout(paramActivity);
    		
    		userCallBack.onLogout(null);
    		
    }

}
