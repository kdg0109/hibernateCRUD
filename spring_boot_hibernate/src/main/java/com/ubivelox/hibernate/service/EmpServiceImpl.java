package com.ubivelox.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubivelox.hibernate.model.Emp;
import com.ubivelox.hibernate.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService
{
    @Autowired
    private EmpRepository empRepository;





    @Override
    public Emp getEmpByEname(final String empEname)
    {
        Emp obj = this.empRepository.findById(empEname)
                                    .get();
        return obj;
    }





    @Override
    public List<Emp> getAllEmps()
    {
        List<Emp> list = new ArrayList<>();
        this.empRepository.findAll()
                          .forEach(e -> list.add(e));
        return list;
    }





    @Override
    public synchronized boolean addEmp(final Emp emp)
    {
        List<Emp> list = this.empRepository.findByEnameAndJobAndPhone(emp.getEname(), emp.getJob(), emp.getPhone());
        if ( list.size() > 0 )
        {
            return false;
        }
        else
        {
            this.empRepository.save(emp);
            return true;
        }
    }





    @Override
    public void updateEmp(final Emp emp)
    {
        this.empRepository.save(emp);
    }





    @Override
    public void deleteEmp(final String empEname)
    {
        this.empRepository.delete(getEmpByEname(empEname));
    }
}
