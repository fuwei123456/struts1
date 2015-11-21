package com.laozhang.struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.laozhang.struts1.form.RegisterForm;

public class RegisterAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// to get form data
		RegisterForm rf = (RegisterForm) form;
		System.out.println(rf);
		request.setAttribute("result", rf);
		return mapping.findForward("success");
	}
}
