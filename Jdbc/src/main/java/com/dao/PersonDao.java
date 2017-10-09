package com.dao;

import java.util.List;

import com.entities.Person;

public interface PersonDao {

	void createPersonTable();

	void insert(Person person);

	Person selectById(int id);

	List<Person> selectAll();

	void delete(int id);

	void update(Person person,int id);

}
