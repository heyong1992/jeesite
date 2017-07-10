/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testop.entity;


import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 单表生成Entity
 * @author ThinkGem
 * @version 2017-06-22
 */
public class TestOp extends DataEntity<TestOp> {
	
	private static final long serialVersionUID = 1L;
	
	public TestOp() {
		super();
	}

	public TestOp(String id){
		super(id);
	}

}