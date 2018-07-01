package com.ubivelox.hibernate.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;

import com.ubivelox.hibernate.model.Emp;

public interface EmpRepository extends CrudRepository<Emp, String>
{
    <S extends Emp> List<S> findAll(Example<S> example);





    <S extends Emp> List<S> findAllByOrderByJobAsc();
}
