package com.fissionlabs.keethu.dao;

import com.fissionlabs.keethu.model.Student;

public interface StudentDao {
	public void save(Student stu);
	public boolean search(String name,String password);
public void update(String password, String name);
public void delete(String password, String name);

}
