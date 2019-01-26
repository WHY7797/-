package com.dao;

import java.util.ArrayList;
import java.util.List;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.UserInfo;
import com.util.HIBUtil;

public class UserDao {

	public static List<UserInfo> queryu() {
		Session s=null;
		List<UserInfo> ulist=new ArrayList<UserInfo>();
		try{
			s=HIBUtil.getSession();
			System.out.println("dsdsd");
			ulist=s.createQuery("from UserInfo").list();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			HIBUtil.close(s);
		}
		return ulist;
	}

	public boolean update(Object obj) {
		Session s=null;
		Transaction tx=null;
		try{
			s=HIBUtil.getSession();
			tx=s.beginTransaction();
			s.update(obj);
			tx.commit();
			return true;
		}
	catch(Exception e ){}
	finally{
		HIBUtil.close(s);
	}
		return false;
	
	
}

	public UserInfo updateu(int id) {
		Session s=null;
		UserInfo u=null;
		try{
			s=HIBUtil.getSession();
			u=(UserInfo)s.createQuery("from UserInfo where id=?").setParameter(0, id).uniqueResult();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			HIBUtil.close(s);
		}
		return u;
	}	}
