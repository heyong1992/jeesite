/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testop.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.testop.entity.TestOp;

/**
 * 单表生成DAO接口
 * @author ThinkGem
 * @version 2017-06-22
 */
@MyBatisDao
public interface TestOpDao extends CrudDao<TestOp> {
	
}