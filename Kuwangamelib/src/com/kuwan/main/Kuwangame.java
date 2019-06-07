package com.kuwan.main;

import com.kuwan.proxy.CommonGameProxy;





public class Kuwangame {

	private static final CommonGameProxy mInstance = new CommonGameProxy();

	/**
	 * @param args
	 */
	public static CommonGameProxy getInstance() {
		// TODO Auto-generated method stub
		
		return mInstance;
	}

}
