package com.kuwan.proxy;

import com.kuwan.callback.YYWPayCallBack;
import com.kuwan.domain.YYWOrder;

import android.app.Activity;

public interface YYWCharger {

    public abstract void charge(Activity paramActivity, YYWOrder order,
            YYWPayCallBack callback);

    public abstract void pay(Activity paramActivity, YYWOrder order,
            YYWPayCallBack callback);
}
