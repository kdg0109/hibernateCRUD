package com.ubivelox.hibernate.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ubivelox.hibernate.model.Emp;

public interface EmpRepository extends CrudRepository<Emp, String>
{
    List<Emp> findByEnameAndJobAndPhone(String ename, String job, String phone);
}
