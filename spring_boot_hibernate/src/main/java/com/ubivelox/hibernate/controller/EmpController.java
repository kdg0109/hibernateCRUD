package com.ubivelox.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ubivelox.hibernate.model.Emp;
import com.ubivelox.hibernate.service.EmpService;

@Controller
public class EmpController
{
    @Autowired
    private EmpService empService;





    public List<Emp> getAllEmps()
    {
        List<Emp> list = this.empService.getAllEmps();
        return list;
    }





    public boolean addEmp(final Emp emp)
    {
        boolean check = this.empService.addEmp(emp);

        return check;
    }





    public Emp updateEmp(final Emp emp)
    {
        this.empService.updateEmp(emp);
        return emp;
    }





    public void deleteArticle(final String ename)
    {
        this.empService.deleteEmp(ename);
    }
}
