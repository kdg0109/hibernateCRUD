package com.ubivelox.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ubivelox.hibernate.model.Emp;
import com.ubivelox.hibernate.service.EmpService;

@Controller
@RequestMapping("jsp")
public class EmpController
{
    @Autowired
    private EmpService empService;





    @GetMapping("emps")
    public ResponseEntity<List<Emp>> getAllEmps()
    {
        List<Emp> list = this.empService.getAllEmps();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
