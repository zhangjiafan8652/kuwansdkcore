package com.kuwan.callback;

import com.kuwan.domain.YYWUser;



public interface YYWUserManagerCallBack {

    public abstract void onLoginSuccess(YYWUser paramUser, Object paramObject);

    public abstract void onLoginFailed(String paramString, Object paramObject);

    public abstract void onLogout(Object paramObject);
}
