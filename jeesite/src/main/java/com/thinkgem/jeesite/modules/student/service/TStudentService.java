/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.TStudent;
import com.thinkgem.jeesite.modules.student.dao.TStudentDao;

/**
 * 单表生成Service
 * @author ThinkGem
 * @version 2017-07-03
 */
@Service
@Transactional(readOnly = true)
public class TStudentService extends CrudService<TStudentDao, TStudent> {

	public TStudent get(String id) {
		return super.get(id);
	}
	
	public List<TStudent> findList(TStudent tStudent) {
		return super.findList(tStudent);
	}
	
	public Page<TStudent> findPage(Page<TStudent> page, TStudent tStudent) {
		return super.findPage(page, tStudent);
	}
	
	@Transactional(readOnly = false)
	public void save(TStudent tStudent) {
		super.save(tStudent);
	}
	
	@Transactional(readOnly = false)
	public void delete(TStudent tStudent) {
		super.delete(tStudent);
	}
	
}