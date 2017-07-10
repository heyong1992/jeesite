/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.student.entity.TClass;

/**
 * 单表生成DAO接口
 * @author ThinkGem
 * @version 2017-06-29
 */
@MyBatisDao
public interface TClassDao extends CrudDao<TClass> {
	
}