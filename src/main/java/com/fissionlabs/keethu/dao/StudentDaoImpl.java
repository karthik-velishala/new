package com.fissionlabs.keethu.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fissionlabs.keethu.model.Student;


@Repository
public class StudentDaoImpl implements StudentDao {
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

@Override
	public void save(Student stu)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(stu);
		transaction.commit();
	}

@Override
	public boolean search(String name,String password)
	{
		Session session = this.sessionFactory.openSession();
		
		Transaction transaction=session.beginTransaction();
		Query query=(Query) session.createQuery("from Student where name=:n1 and password=:p1");
		 query.setParameter("n1",name );
		    query.setParameter("p1", password);
		    List<Student> list= ((org.hibernate.Query) query).list();  
		     Iterator<Student> itr=list.iterator();
		     boolean status = false;
			if(itr.hasNext())
		    	 status=true;
			return status;
	}


@Override
public void update(String password,String name) {

	Session session = this.sessionFactory.getCurrentSession();
	Transaction transaction=session.beginTransaction();
	Query query=(Query) session.createQuery("Update Student set password=:p1 where name=:n1");
	 query.setParameter("n1",name);
	    query.setParameter("p1", password);
	    query.executeUpdate();
transaction.commit();	
	
}


@Override
public void delete(String password, String name) {
	Session session = this.sessionFactory.getCurrentSession();
	Transaction transaction=session.beginTransaction();
	Query query=(Query) session.createQuery("Delete from  Student where password=:p1 and name=:n1");
	 query.setParameter("n1",name);
	    query.setParameter("p1", password);
	    query.executeUpdate();
transaction.commit();	
	
	
	
}

}
