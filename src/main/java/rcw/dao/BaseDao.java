package rcw.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import rcw.utils.CollectionParam;

public class BaseDao {
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List queryByHql(String hql,List<Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.size() > 0) {
			setParams(query, params);
		}
		
		return query.list();
	}
	
	public List queryPageByHql(String hql,List<Object> params,int pageNo,int maxResult) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.size() > 0) {
			setParams(query, params);
		}
		query.setFirstResult((pageNo - 1) * maxResult);
		query.setMaxResults(maxResult);
		return query.list();
	}
	
	public Serializable save(Object bean) {
		Session session = sessionFactory.getCurrentSession();
		return session.save(bean);
	}
	
	public void update(Object bean) {
		Session session = sessionFactory.getCurrentSession();
		session.update(bean);
	}
	
	public void saveOrUpdate(Object bean) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(bean);
	}
	
	public void delete(Object bean) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(bean);
	}
	
	public void delete(Class clazz, Serializable id) {
		delete(get(clazz,id));
	}
	
	public Object get(Class clazz, Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(clazz, id);
	}
	
	public Object load(Class clazz, Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		return session.load(clazz, id);
	}
	
	public int queryCountByHql(String hql,List<Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.size() > 0) {
			setParams(query, params);
		}
		Object obj = query.uniqueResult();
		return ((Long)obj).intValue();
	}
	
	public List queryBySql(String sql,List<Object> params) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		if(params != null && params.size() > 0) {
			setParams(query, params);
		}
		return query.list();
	}
	
	public int executeUpdateByHql(String hql,List<Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		if(params != null && params.size() > 0) {
			setParams(query, params);
		}
		return query.executeUpdate();
	}
	
	public int executeUpdateBySql(String sql,List<Object> params) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery(sql);
		if(params != null && params.size() > 0) {
			setParams(query, params);
		}
		return query.executeUpdate();
	}
	
	private void setParams(Query query,List<Object> params) {
		int index = 0;
		for(Object param : params) {
			if(param instanceof CollectionParam) {
				CollectionParam cp = (CollectionParam) param;
				query.setParameterList(cp.getKey(), cp.getValue());
			}else if(param instanceof byte[]) {
				query.setBinary(index, (byte[])param);
				index++;
			}else {
				query.setString(index, param.toString());
				index++;
			}
		}
	}
}
