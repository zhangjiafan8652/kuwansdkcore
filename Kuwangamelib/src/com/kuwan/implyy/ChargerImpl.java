package com.kuwan.implyy;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import com.kuwan.sdk.bean.Order;
import com.kuwan.sdk.bean.User;
import com.kuwan.sdk.callback.KgameSdkPaymentCallback;
import com.kuwan.sdk.main.KgameSdk;
import com.kuwan.callback.YYWPayCallBack;
import com.kuwan.domain.YYWOrder;
import com.kuwan.domain.YYWUser;
import com.kuwan.main.YYWMain;
import com.kuwan.proxy.YYWCharger;


public class ChargerImpl implements YYWCharger {

    @Override
    public void charge(Activity paramActivity, YYWOrder order,
            YYWPayCallBack callback) {
    	
    	
    }

    @Override
    public void pay(final Activity paramActivity, final YYWOrder order, YYWPayCallBack callback) {


    	new Handler(Looper.getMainLooper()).post(new Runnable() {

            @Override
            public void run() {

				    	Order order2 = new Order();

				        order2.orderId = order.orderId;
				        order2.goods = order.goods;
				        order2.money = order.money;
				        order2.ext = order.ext;

				        KgameSdk.payment(paramActivity, order2, false,new KgameSdkPaymentCallback() {

				            /**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							@Override
				            public void onCancel() {
				                if (YYWMain.mPayCallBack != null) {
				                    YYWMain.mPayCallBack.onPayCancel("cancel", "");
				                }
				            }

				            @Override
				            public void onError(int arg0) {
				                if (YYWMain.mPayCallBack != null) {
				                    YYWMain.mPayCallBack.onPayFailed("failed", "");
				                }
				            }

				            @Override
				            public void onSuccess(User user, Order order, int arg2) {
				                if (YYWMain.mPayCallBack != null) {
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

				                    YYWOrder yywOrder = new YYWOrder();

				                    yywOrder.orderId = order.orderId;
				                    yywOrder.ext = order.ext;
				                    yywOrder.gameId = order.gameId;
				                    yywOrder.goods = order.goods;
				                    yywOrder.id = order.id;
				                    yywOrder.mentId = order.mentId;
				                    yywOrder.money = order.money;
				                    yywOrder.paytype = order.paytype;
				                    yywOrder.serverId = order.serverId;
				                    yywOrder.status = order.status;
				                    yywOrder.time = order.time;
				                    yywOrder.transNum = order.transNum;

				                    YYWMain.mPayCallBack.onPaySuccess(yywUser, yywOrder, "success");
				                }
				            }

				        });

            }

    	});

    }

}
