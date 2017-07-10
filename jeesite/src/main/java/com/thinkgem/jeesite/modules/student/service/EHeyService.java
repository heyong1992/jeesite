/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.EHey;
import com.thinkgem.jeesite.modules.student.dao.EHeyDao;

/**
 * 单表生成Service
 * @author ThinkGem
 * @version 2017-07-03
 */
@Service
@Transactional(readOnly = true)
public class EHeyService extends CrudService<EHeyDao, EHey> {

	public EHey get(String id) {
		return super.get(id);
	}
	
	public List<EHey> findList(EHey eHey) {
		return super.findList(eHey);
	}
	
	public Page<EHey> findPage(Page<EHey> page, EHey eHey) {
		return super.findPage(page, eHey);
	}
	
	@Transactional(readOnly = false)
	public void save(EHey eHey) {
		super.save(eHey);
	}
	
	@Transactional(readOnly = false)
	public void delete(EHey eHey) {
		super.delete(eHey);
	}
	
}