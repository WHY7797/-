package com.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.Student;
import com.beans.Teacher;
import com.beans.Ts;

public class HIBUtil {
	private static SessionFactory sessionFactory;
	
	static{
		try{
			System.out.println(1111);
			//创建读取配置文件的对象
			Configuration cfx=new Configuration();
			System.out.println(1111);
			//读取配置文件
			cfx.configure();  //会默认读取hibernate主配置文件,括号中也可以写上名字
			System.out.println(1111);
			//创建session工厂
			sessionFactory=cfx.buildSessionFactory();
			System.out.println(1111);
		}catch(Exception e){
			System.out.println("===========");
			e.printStackTrace();
		}
		
	}
	
	//得到session
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	//得到工厂
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	//关闭资源
	public static void close(Session s){
		if(s!=null){
			s.close();
		}
	}
	

	//标准的修改方法
	public static boolean update(Object obj){
		Session s=null;
		Transaction tx=null;
		try{
			s=HIBUtil.getSession();
			tx=s.beginTransaction();
			s.update(obj); //返回值为当前数据库id
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HIBUtil.close(s);
		}
		return true;
	}
	//标准的查询方法
	public static Student select(String name,String password){
		Session s=null;
		Transaction tx=null;
		Student stu=null;
		try{
			s=HIBUtil.getSession();
			String hql="from Student where sname=? and password=?";
			Query q=s.createQuery(hql);
			q.setString(0, name);
			q.setString(1, password);
			stu=(Student)q.uniqueResult();	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HIBUtil.close(s);
		}
		return stu;
	}
	
	public static Teacher selectTea(String name,String password){
		Session s=null;
		
		Teacher tea=null;
		try{
			s=HIBUtil.getSession();
			String hql="select t from Teacher t where t.tname=? and t.tpassword=?";
			Query q=s.createQuery(hql);
			q.setParameter(0, name);
			q.setParameter(1, password);
			tea=(Teacher)q.uniqueResult();	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HIBUtil.close(s);
		}
		return tea;
	}
	
	public static List<Teacher> selectAll(){
		Session s=null;
		List<Teacher> teaList=null;
		try{
			s=HIBUtil.getSession();
			String hql="from Teacher ";
			Query q=s.createQuery(hql);
			
			teaList=q.list();	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HIBUtil.close(s);
		}
		return teaList;
	}
	public static List<Student> selectAll1(){
		Session s=null;
		List<Student> stuList=null;
		try{
			s=HIBUtil.getSession();
			String hql="from Student";
			Query q=s.createQuery(hql);
			stuList=q.list();	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HIBUtil.close(s);
		}
		return stuList;
	}
	public static int selectStatus(int sid,int tid){
		Session s=null;
		
		int status=0;
		try{
			s=HIBUtil.getSession();
			String hql="select t.status from Ts t where t.sid=? and t.tid=?";
			Query q=s.createQuery(hql);
			q.setParameter(0, sid);
			q.setParameter(1, tid);
			status=(int)q.uniqueResult();	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HIBUtil.close(s);
		}
		return status;
	}
	

	
	public static boolean updateStatus(int status,int sid,int tid){
		
		Session s=null;
		Transaction tx=null;
		try{
			s=HIBUtil.getSession();
			tx=s.beginTransaction();
			String hql="update Ts t set t.status=? where t.sid=? and t.tid=?";
			
			Query q=s.createQuery(hql);
			q.setParameter(0, status);
			q.setParameter(1, sid);
			q.setParameter(2, tid);
			int ret=q.executeUpdate();
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HIBUtil.close(s);
		}
		return true;
	}
	public static int add(Object obj){
		Session s=null;
		Transaction tx=null;
		Serializable i=null;
		try{
			s=HIBUtil.getSession();
			tx=s.beginTransaction();
			i=s.save(obj);  //返回值为当前数据库id
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			HIBUtil.close(s);
		}
		return (Integer)i;
	}
	public static Object get(Class <?> clazz, Serializable id ){
		Session s=null;
		try {
			s=HIBUtil.getSession();
			Object obj =s.get(clazz, id);
			return obj;
			
		}finally{
			HIBUtil.close(s);
		}	
	}
	
}