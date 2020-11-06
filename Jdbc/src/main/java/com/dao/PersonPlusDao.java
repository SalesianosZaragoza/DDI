package com.dao;

import com.entities.Person;

public interface PersonPlusDao {

	Person selectByLastName(String lastname);

}
