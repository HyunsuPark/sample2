package com.ioc;

public class appFactory {
	// 역시 사용자의 요청에 따라 원하는 Interface를 반환하는 것을 목적으로 만들었다.
	private myInter inter;

	public void setInter(myInter n) { // 인자로 MyInter를 구현한 모든 n을 받는다.
		inter = n;
	}

	public String getHello() {
		return inter.hello();
	}
}
