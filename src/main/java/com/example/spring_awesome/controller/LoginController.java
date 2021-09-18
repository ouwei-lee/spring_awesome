package com.example.spring_awesome.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @date: 2021/9/14 16:40
 */
@Slf4j
@RestController
public class LoginController {

	@PostMapping("/login")
	public void login(@RequestParam(value = "account") String account,
					  @RequestParam(value = "password") String password) {

		Subject userSubject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(account, password);
		log.info("token:{}",token);
		userSubject.login(token);
	}

	@GetMapping("/login")
	public void login() {
		throw new RuntimeException("未登录");
	}

	@GetMapping("/auth")
	public String auth() {
		return "已成功登录";
	}

	@GetMapping("/role")
	@RequiresRoles("vip")
	public String role() {
		return "测试Vip角色";
	}

	@GetMapping("/permission")
	@RequiresPermissions(value = {"add", "update"}, logical = Logical.AND)
	public String permission() {
		return "测试Add和Update权限";
	}

}
