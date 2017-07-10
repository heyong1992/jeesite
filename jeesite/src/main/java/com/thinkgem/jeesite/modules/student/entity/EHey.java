/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 单表生成Entity
 * @author ThinkGem
 * @version 2017-07-03
 */
public class EHey extends DataEntity<EHey> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String age;		// age
	private String address;		// address
	
	public EHey() {
		super();
	}

	public EHey(String id){
		super(id);
	}

	@Length(min=0, max=60, message="name长度必须介于 0 和 60 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=20, message="age长度必须介于 0 和 20 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=60, message="address长度必须介于 0 和 60 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}