package com.action;

import java.util.List;

import sun.print.resources.serviceui;

import com.beans.UserInfo;
import com.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	public String queryu() {
		
		List<UserInfo> ulist = UserDao.queryu();
		ActionContext.getContext().put("ulist", ulist);
		for (UserInfo u : ulist) {
			System.out.println(u.getId());
		}
		return "success";

	}

	private int id;
	private String uname;

	public String update() {
		UserDao userDao = new UserDao();
		UserInfo userInfo=(UserInfo)ActionContext.getContext().getSession().get("u");
		userInfo.setUname(uname);
		if (userDao.update(userInfo)) {
			ActionContext.getContext().put("msg", "修改成功");
			return "success";
		} else {
			ActionContext.getContext().put("msg", "修改失败");
			return "error";
		}

	}
	public String updateu() {
		UserDao userDao = new UserDao();
		UserInfo u=userDao.updateu(id);
		
		if (u!=null) {
			ActionContext.getContext().getSession().put("u", u);
			return "usec";
		} else {
			return "error";
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}
