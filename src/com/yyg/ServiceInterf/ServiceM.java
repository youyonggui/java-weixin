package com.yyg.ServiceInterf;

import java.util.List;

import org.hibernate.Query;

public interface ServiceM {
	//删除
	public void delete(Object object);
	//删除
	public Integer delete(Query query);
	//延迟加载
	public Object selectLoad(Class className,Integer id);
	//加载
	public Object selectGet(Class className,Integer id);
	//无占位符
	public List<Object> selectGet(String hql);
	//有一个占位符
	public List<Object> selectGet(String hql,String placeholder);
	//有两个占位符
	public List<Object> selectGet(String hql,String placeholder1,String placeholder2);
	//批量加载
	public List<Object> selectLoad(String hql);
	//更新
	public void update(Object object);
	//保存
	public Integer save(Object object);
	
	public List<Object> selectOrder(String hql,int firstResult,int maxResult);

}
