/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.web;

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
import com.thinkgem.jeesite.modules.student.entity.TClass;
import com.thinkgem.jeesite.modules.student.service.TClassService;

/**
 * 单表生成Controller
 * @author ThinkGem
 * @version 2017-06-29
 */
@Controller
@RequestMapping(value = "${adminPath}/student/tClass")
public class TClassController extends BaseController {

	@Autowired
	private TClassService tClassService;
	
	@ModelAttribute
	public TClass get(@RequestParam(required=false) String id) {
		TClass entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tClassService.get(id);
		}
		if (entity == null){
			entity = new TClass();
		}
		return entity;
	}
	
	//@RequiresPermissions("student:tClass:view")
	@RequestMapping(value = {"list", ""})
	public String list(TClass tClass, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TClass> page = tClassService.findPage(new Page<TClass>(request, response), tClass); 
		model.addAttribute("page", page);
		return "modules/student/tClassList";
	}

	//@RequiresPermissions("student:tClass:view")
	@RequestMapping(value = "form")
	public String form(TClass tClass, Model model) {
		model.addAttribute("tClass", tClass);
		return "modules/student/tClassForm";
	}

	//@RequiresPermissions("student:tClass:edit")
	@RequestMapping(value = "save")
	public String save(TClass tClass, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tClass)){
			return form(tClass, model);
		}
		tClassService.save(tClass);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/student/tClass/?repage";
	}
	
	//@RequiresPermissions("student:tClass:edit")
	@RequestMapping(value = "delete")
	public String delete(TClass tClass, RedirectAttributes redirectAttributes) {
		tClassService.delete(tClass);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/student/tClass/?repage";
	}

}