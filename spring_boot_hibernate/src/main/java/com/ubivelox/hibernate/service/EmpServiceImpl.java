package com.ubivelox.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubivelox.gaia.GaiaException;
import com.ubivelox.gaia.util.GaiaUtils;
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
            // Emp emp = new Emp(null, "그룹장", null);
            // Example<Emp> example = Example.of(emp);
            // return this.empRepository.findAll(example);
            return this.empRepository.findAllByOrderByJobAsc();

            // return (List<Emp>) this.empRepository.findAll();
        }
        catch ( Exception e )
        {
            throw new UbiveloxException("DB 에러", e);
        }
    }





    @Override
    public Emp addEmp(final Emp empOrg) throws UbiveloxException
    {

        try
        {
            GaiaUtils.checkNullOrEmpty(empOrg.getEname(), empOrg.getJob());
        }
        catch ( GaiaException e )
        {
            throw new UbiveloxException("데이터 null or Empty 에러", e);
        }

        if ( this.empRepository.existsById(empOrg.getEname()) )
        {
            throw new UbiveloxException("DB에 데이터가 이미 존재함");
        }

        try
        {
            // 추가하고자 하는 Ename이 DB에 없을 때

            return this.empRepository.save(empOrg); // 입력된 emp가 리턴됨

        }
        catch ( Exception e )
        {
            throw new UbiveloxException("DB 에러", e);
        }
    }





    @Override
    public Emp updateEmp(final Emp empOrg) throws UbiveloxException
    {
        try
        {
            GaiaUtils.checkNullOrEmpty(empOrg.getEname(), empOrg.getJob());
        }
        catch ( GaiaException e )
        {
            throw new UbiveloxException("데이터 null or Empty 에러", e);
        }

        if ( this.empRepository.existsById(empOrg.getEname()) == false )
        {
            throw new UbiveloxException("DB에 데이터가 없음");
        }

        try
        {

            // 추가하고자 하는 Ename이 DB에 있을 때

            return this.empRepository.save(empOrg); // 입력된 emp가 리턴됨

        }
        catch ( Exception e )
        {
            throw new UbiveloxException("DB 에러", e);
        }
    }





    @Override
    public void deleteEmp(final String empEname) throws UbiveloxException
    {
        try
        {
            GaiaUtils.checkNullOrEmpty(empEname);
        }
        catch ( GaiaException e )
        {
            throw new UbiveloxException("데이터 null or Empty 에러", e);
        }

        if ( this.empRepository.existsById(empEname) == false )
        {
            throw new UbiveloxException("DB에 데이터가 없음");
        }

        try
        {

            this.empRepository.deleteById(empEname);

        }
        catch ( Exception e )
        {
            throw new UbiveloxException("DB 에러", e);
        }
    }
}
