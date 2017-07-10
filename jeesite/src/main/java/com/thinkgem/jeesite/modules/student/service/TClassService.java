/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.TClass;
import com.thinkgem.jeesite.modules.student.dao.TClassDao;

/**
 * 单表生成Service
 * @author ThinkGem
 * @version 2017-06-29
 */
@Service
@Transactional(readOnly = true)
public class TClassService extends CrudService<TClassDao, TClass> {

	public TClass get(String id) {
		return super.get(id);
	}
	
	public List<TClass> findList(TClass tClass) {
		return super.findList(tClass);
	}
	
	public Page<TClass> findPage(Page<TClass> page, TClass tClass) {
		return super.findPage(page, tClass);
	}
	
	@Transactional(readOnly = false)
	public void save(TClass tClass) {
		super.save(tClass);
	}
	
	@Transactional(readOnly = false)
	public void delete(TClass tClass) {
		super.delete(tClass);
	}
	
}