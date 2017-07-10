/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.testop.entity.TestOp;
import com.thinkgem.jeesite.modules.testop.service.TestOpService;

/**
 * 单表生成Controller
 * @author ThinkGem
 * @version 2017-06-22
 */
@Controller
@RequestMapping(value = "${adminPath}/testop/testOp")
public class TestOpController extends BaseController {

	@Autowired
	private TestOpService testOpService;
	
	@ModelAttribute
	public TestOp get(@RequestParam(required=false) String id) {
		TestOp entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = testOpService.get(id);
		}
		if (entity == null){
			entity = new TestOp();
		}
		return entity;
	}
	
	@RequiresPermissions("testop:testOp:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestOp testOp, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TestOp> page = testOpService.findPage(new Page<TestOp>(request, response), testOp); 
		model.addAttribute("page", page);
		return "modules/testop/testOpList";
	}

	@RequiresPermissions("testop:testOp:view")
	@RequestMapping(value = "form")
	public String form(TestOp testOp, Model model) {
		model.addAttribute("testOp", testOp);
		return "modules/testop/testOpForm";
	}

	@RequiresPermissions("testop:testOp:edit")
	@RequestMapping(value = "save")
	public String save(TestOp testOp, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, testOp)){
			return form(testOp, model);
		}
		testOpService.save(testOp);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/testop/testOp/?repage";
	}
	
	@RequiresPermissions("testop:testOp:edit")
	@RequestMapping(value = "delete")
	public String delete(TestOp testOp, RedirectAttributes redirectAttributes) {
		testOpService.delete(testOp);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/testop/testOp/?repage";
	}

}