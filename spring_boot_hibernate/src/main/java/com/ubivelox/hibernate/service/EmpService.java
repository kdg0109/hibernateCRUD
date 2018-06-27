package com.ubivelox.hibernate.service;

import java.util.List;

import com.ubivelox.hibernate.model.Emp;

public interface EmpService
{
    public List<Emp> getAllEmps();





    Emp getEmpByEname(String empEname);





    boolean addEmp(Emp emp);





    void updateEmp(Emp emp);





    void deleteEmp(String ename);
}
