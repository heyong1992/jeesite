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
import com.thinkgem.jeesite.modules.student.entity.EHey;
import com.thinkgem.jeesite.modules.student.service.EHeyService;

/**
 * 单表生成Controller
 * @author ThinkGem
 * @version 2017-07-03
 */
@Controller
@RequestMapping(value = "${adminPath}/student/eHey")
public class EHeyController extends BaseController {

	@Autowired
	private EHeyService eHeyService;
	
	@ModelAttribute
	public EHey get(@RequestParam(required=false) String id) {
		EHey entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = eHeyService.get(id);
		}
		if (entity == null){
			entity = new EHey();
		}
		return entity;
	}
	
	//@RequiresPermissions("student:eHey:view")
	@RequestMapping(value = {"list", ""})
	public String list(EHey eHey, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<EHey> page = eHeyService.findPage(new Page<EHey>(request, response), eHey); 
		model.addAttribute("page", page);
		return "modules/student/eHeyList";
	}

	//@RequiresPermissions("student:eHey:view")
	@RequestMapping(value = "form")
	public String form(EHey eHey, Model model) {
		model.addAttribute("eHey", eHey);
		return "modules/student/eHeyForm";
	}

	//@RequiresPermissions("student:eHey:edit")
	@RequestMapping(value = "save")
	public String save(EHey eHey, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, eHey)){
			return form(eHey, model);
		}
		eHeyService.save(eHey);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/student/eHey/?repage";
	}
	
	//@RequiresPermissions("student:eHey:edit")
	@RequestMapping(value = "delete")
	public String delete(EHey eHey, RedirectAttributes redirectAttributes) {
		eHeyService.delete(eHey);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/student/eHey/?repage";
	}

}