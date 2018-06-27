package com.ubivelox.hibernate.repository;

import org.springframework.data.repository.CrudRepository;

import com.ubivelox.hibernate.model.Emp;

public interface EmpRepository extends CrudRepository<Emp, Long>
{
}
