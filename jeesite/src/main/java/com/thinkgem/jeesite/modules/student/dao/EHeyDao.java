/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.student.entity.EHey;

/**
 * 单表生成DAO接口
 * @author ThinkGem
 * @version 2017-07-03
 */
@MyBatisDao
public interface EHeyDao extends CrudDao<EHey> {
	
}