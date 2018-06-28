package com.ubivelox.hibernate.service;

import java.util.List;

import com.ubivelox.hibernate.model.Emp;

import exception.UbiveloxException;

public interface EmpService
{
    List<Emp> getAllEmps() throws UbiveloxException;





    Emp addEmp(Emp emp) throws UbiveloxException;





    Emp updateEmp(Emp emp) throws UbiveloxException;





    void deleteEmp(String ename) throws UbiveloxException;
}
