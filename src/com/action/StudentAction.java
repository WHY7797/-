package com.action;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.beans.Student;
import com.beans.Teacher;
import com.beans.Ts;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.util.HIBUtil;

public class StudentAction extends ActionSupport{
	private String name;
	private String password;
	private int select;
	private int tid;
	private int sid;
	public String login(){ 
		if(select==1){
			Student stu=HIBUtil.select(name, password);
			int sid=stu.getSid();
			ActionContext.getContext().getSession().put("sid", sid);
			if(stu!=null){
				ActionContext.getContext().put("msg", "登陆成功");
				return "successStu";
			}else{
				return "error";
			}
		}else if(select==2){
			Teacher tea=HIBUtil.selectTea(name, password);
			int tid=tea.getTid();
			ActionContext.getContext().getSession().put("tid", tid);
			if(tea!=null){
				ActionContext.getContext().put("msg", "登陆成功");
				return "successTea";
			}else{
				return "error";
			}
		}
		
		return "error";	
	}
	
	public String query1(){
		
		List<Teacher> teaList=HIBUtil.selectAll();
		ActionContext.getContext().put("teaList", teaList);
		
		return "teaAll";
		
	}
	public String query2(){
		List<Student> stuList=HIBUtil.selectAll1();
		ActionContext.getContext().put("stuList", stuList);
		
		return "stuAll";
		
	}
	public String shen(){
		
		if(HIBUtil.updateStatus(1,sid,tid)){
			ActionContext.getContext().put("msg", "等待申请结果");
			return this.query1();
		}
		return null;
		
		
	}
	
public String yes(){
	System.out.println(sid);
	System.out.println(tid);
		if(HIBUtil.updateStatus(2,sid,tid)){
			ActionContext.getContext().put("msg", "同意申请");
			return this.query2();
		}
		return null;
		
		
	}
	
public String no(){
	
	if(HIBUtil.updateStatus(3,sid,tid)){
		ActionContext.getContext().put("msg", "不同意申请");
		return this.query2();
	}
	return null;
	
	
}






















































	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSelect(int select) {
		this.select = select;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
}
