package com.yyg.ServiceInterf;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

//事务全注解(这个实现类交由事务管理器管理)
@Transactional
public class serviceImp implements ServiceM {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(object);
	}

	@Override
	public Integer delete(Query query) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Object selectLoad(Class className,Integer id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().load(className, id);
	}

	@Override
	public List<Object> selectLoad(String hql) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(object);
	}

	@Override
	public Integer save(Object object) {
		// TODO Auto-generated method stub
		return (Integer) sessionFactory.getCurrentSession().save(object);
	}

	@Override
	public Object selectGet(Class className, Integer id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(className, id);
	}

	@Override
	public List<Object> selectGet(String hql) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public List<Object> selectGet(String hql, String placeholder) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, placeholder);
		return query.list();
	}

	@Override
	public List<Object> selectGet(String hql, String placeholder1,
			String placeholder2) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, placeholder1);
		query.setString(1, placeholder2);
		return query.list();
	}

	@Override
	public List<Object> selectOrder(String hql,int firstResult,int maxResult) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	
	
	
}
