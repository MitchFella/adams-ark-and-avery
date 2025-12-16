package org.adamsArkAndAvery.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "LogoutBean")
@SessionScoped
public class LogoutBean {
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		System.out.println("Logout Successfully!");
		return "/register.xhtml?faces-redirect=true";
	}
}
