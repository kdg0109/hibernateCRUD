package com.ubivelox.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ubivelox.hibernate.model.Emp;
import com.ubivelox.hibernate.service.EmpService;

import exception.UbiveloxException;

@Controller
public class EmpController
{
    @Autowired
    private EmpService empService;





    public List<Emp> getAllEmps() throws UbiveloxException
    {
        List<Emp> list = this.empService.getAllEmps();

        return list;
    }





    public Emp addEmp(final Emp empOrg) throws UbiveloxException
    {
        Emp emp = this.empService.addEmp(empOrg);

        return emp;
    }





    public Emp updateEmp(final Emp empOrg) throws UbiveloxException
    {
        Emp emp = this.empService.updateEmp(empOrg);
        return emp;
    }





    public void deleteEmp(final String ename) throws UbiveloxException
    {
        this.empService.deleteEmp(ename);
    }
}
