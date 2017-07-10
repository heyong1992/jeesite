/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.testop.entity.TestOp;
import com.thinkgem.jeesite.modules.testop.dao.TestOpDao;

/**
 * 单表生成Service
 * @author ThinkGem
 * @version 2017-06-22
 */
@Service
@Transactional(readOnly = true)
public class TestOpService extends CrudService<TestOpDao, TestOp> {

	public TestOp get(String id) {
		return super.get(id);
	}
	
	public List<TestOp> findList(TestOp testOp) {
		return super.findList(testOp);
	}
	
	public Page<TestOp> findPage(Page<TestOp> page, TestOp testOp) {
		return super.findPage(page, testOp);
	}
	
	@Transactional(readOnly = false)
	public void save(TestOp testOp) {
		super.save(testOp);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestOp testOp) {
		super.delete(testOp);
	}
	
}