package com.kuwan.proxy;

import com.kuwan.impl.ActivityStubImpl;
import com.kuwan.impl.AnimationImpl;
import com.kuwan.impl.ChargerImpl;
import com.kuwan.impl.LoginImpl;
import com.kuwan.impl.UserManagerImpl;



public class GameProxy extends CommonGameProxy {

    private static GameProxy proxy;

    private GameProxy(YYWLoginer login, YYWActivityStub stub, YYWUserManager userManager, YYWCharger charger) {
        super(login, stub, userManager, charger);
    }

    public static CommonGameProxy getInstent() {

        if (proxy == null) {
            proxy = new GameProxy(new LoginImpl(), new ActivityStubImpl(), new UserManagerImpl(), new ChargerImpl());
            proxy.setAnimation(new AnimationImpl());
        }

        return proxy;
    }

}
