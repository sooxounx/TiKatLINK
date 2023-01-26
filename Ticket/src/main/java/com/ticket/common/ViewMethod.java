package com.ticket.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public class ViewMethod {

	public static void setAttribute(Model model, String url, String msg) {
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		return;
	}
	public static void setAttribute(HttpServletRequest request, String url, String msg) {
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		return;
	}
	
}
