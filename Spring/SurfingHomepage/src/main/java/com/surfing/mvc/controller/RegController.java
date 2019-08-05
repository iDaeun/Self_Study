package com.surfing.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.surfing.mvc.domain.MemberInfo;
import com.surfing.mvc.service.RegService;

@Controller
public class RegController {
	
	@Autowired
	private RegService regService;
	
	// 회원가입 폼 요청
	@RequestMapping(value = "/reg/regForm")
	public String getRegForm() {
		
		// reForm.jsp로 이동
		return "reg/regForm";
	}
	
	// 회원가입 처리
	@RequestMapping(value = "/reg/regProcess", method = RequestMethod.POST )
	public String regProcess(MemberInfo memberInfo, 
							HttpServletRequest request,
							Model model) {
		
		int rCnt = regService.reg(memberInfo, request);
		model.addAttribute("rCnt",rCnt);
		model.addAttribute("memberInfo",memberInfo);
		
		//regProcess.jsp로 이동
		return "reg/regProcess";
	}
	
}