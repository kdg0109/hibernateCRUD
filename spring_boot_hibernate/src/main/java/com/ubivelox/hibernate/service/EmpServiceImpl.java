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
    public List<Emp> getAllEmps()
    {
        List<Emp> list = new ArrayList<>();
        this.empRepository.findAll()
                          .forEach(e -> list.add(e));
        return list;
    }
}
