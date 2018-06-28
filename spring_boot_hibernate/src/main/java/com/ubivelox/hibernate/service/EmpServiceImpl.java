package com.ubivelox.hibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ubivelox.hibernate.model.Emp;
import com.ubivelox.hibernate.repository.EmpRepository;

import exception.UbiveloxException;

@Service
public class EmpServiceImpl implements EmpService
{
    @Autowired
    private EmpRepository empRepository;





    @Override
    public List<Emp> getAllEmps() throws UbiveloxException
    {
        try
        {
            return (List<Emp>) this.empRepository.findAll();
        }
        catch ( Exception e )
        {
            throw new UbiveloxException("select all error");
        }
    }





    @Override
    public Emp addEmp(final Emp empOrg) throws UbiveloxException
    {
        if ( empOrg.getEname()
                   .equals("")
             || empOrg.getEname() == null )
        {
            throw new UbiveloxException("데이터 null 에러");
        }

        try
        {
            Optional<Emp> optionalEmp = this.empRepository.findById(empOrg.getEname());

            if ( optionalEmp.isPresent() == true )
            {
                throw new UbiveloxException("DB에 데이터가 이미 존재함");
            }
            // 추가하고자 하는 Ename이 DB에 없을 때

            return this.empRepository.save(empOrg); // 입력된 emp가 리턴됨

        }
        catch ( DataIntegrityViolationException e )
        {
            throw new UbiveloxException("데이터 null 에러");
        }
    }





    @Override
    public Emp updateEmp(final Emp empOrg) throws UbiveloxException
    {
        if ( empOrg.getEname()
                   .equals("")
             || empOrg.getEname() == null )
        {
            throw new UbiveloxException("데이터 null 에러");
        }

        try
        {
            Optional<Emp> optionalEmp = this.empRepository.findById(empOrg.getEname());

            if ( optionalEmp.isPresent() == false )
            {
                throw new UbiveloxException("DB에 데이터가 없음");
            }
            // 추가하고자 하는 Ename이 DB에 있을 때

            return this.empRepository.save(empOrg); // 입력된 emp가 리턴됨

        }
        catch ( DataIntegrityViolationException e )
        {
            throw new UbiveloxException("데이터 null 에러", e);
        }
    }





    @Override
    public void deleteEmp(final String empEname) throws UbiveloxException
    {
        if ( empEname.equals("") || empEname == null )
        {
            throw new UbiveloxException("데이터 null 에러");
        }

        try
        {
            Optional<Emp> optionalEmp = this.empRepository.findById(empEname);

            if ( optionalEmp.isPresent() == false )
            {
                throw new UbiveloxException("DB에 데이터가 없음");
            }

            this.empRepository.deleteById(empEname);

        }
        catch ( IllegalArgumentException e )
        {
            throw new UbiveloxException("데이터 null 에러");
        }
    }
}
