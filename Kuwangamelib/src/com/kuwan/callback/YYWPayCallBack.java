package com.kuwan.callback;

import com.kuwan.domain.YYWOrder;
import com.kuwan.domain.YYWUser;





public interface YYWPayCallBack {
    public abstract void onPaySuccess(YYWUser paramUser, YYWOrder paramOrder,
            Object paramObject);

    public abstract void onPayFailed(String paramString, Object paramObject);

    public abstract void onPayCancel(String paramString, Object paramObject);

}
