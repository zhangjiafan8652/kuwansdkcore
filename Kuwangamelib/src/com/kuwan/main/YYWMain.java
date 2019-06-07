package com.kuwan.main;

import com.kuwan.callback.YYWAnimCallBack;
import com.kuwan.callback.YYWExitCallback;
import com.kuwan.callback.YYWPayCallBack;
import com.kuwan.callback.YYWUserCallBack;
import com.kuwan.callback.YYWUserManagerCallBack;
import com.kuwan.domain.YYWOrder;
import com.kuwan.domain.YYWRole;
import com.kuwan.domain.YYWUser;

public class YYWMain {

    public static YYWAnimCallBack mAnimCallBack;

    public static YYWUserCallBack mUserCallBack;

    public static YYWUserManagerCallBack mUserManagerCallBack;

    public static YYWPayCallBack mPayCallBack;

    public static YYWExitCallback mExitCallback;

    public static YYWUser mUser;

    public static YYWOrder mOrder;

    public static YYWRole mRole;

    private static final YYWMain mInstance = new YYWMain();

	/**
	 * @param args
	 */
	public static YYWMain getInstance() {
		// TODO Auto-generated method stub
		return mInstance;
	}

}
