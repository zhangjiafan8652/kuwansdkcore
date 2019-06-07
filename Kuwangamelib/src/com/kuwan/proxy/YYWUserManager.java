package com.kuwan.proxy;

import com.kuwan.callback.YYWExitCallback;
import com.kuwan.callback.YYWUserManagerCallBack;

import android.app.Activity;

public interface YYWUserManager {

    public abstract void manager(Activity paramActivity);

    public abstract void login(Activity paramActivity, String paramString,  Object paramObject);

    public abstract void logout(Activity paramActivity, String paramString,  Object paramObject);

    public abstract void exit(Activity paramActivity, YYWExitCallback callback);

    public abstract void setUserListener(Activity paramActivity,  YYWUserManagerCallBack paramXMUserListener);

    public abstract void setRoleData(Activity paramActivity);
    public abstract void setData(Activity paramActivity, String roleId, String roleName,
			String roleLevel, String zoneId, String zoneName, String roleCTime,
			String ext);
}
