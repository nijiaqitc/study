package com.njq.study.model;

public class XiaoMing extends Children{

	@Override
	public String getName() {
		return "小明";
	}

	@Override
	public String getSex() {
		return "男";
	}

	public void go() {
		System.out.println(getName()+" run ");
	}
	
}
