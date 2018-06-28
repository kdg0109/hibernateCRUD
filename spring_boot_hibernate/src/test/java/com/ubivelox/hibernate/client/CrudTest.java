package com.ubivelox.hibernate.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLNonTransientException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubivelox.hibernate.controller.EmpController;
import com.ubivelox.hibernate.model.Emp;

import exception.UbiveloxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudTest
{

    static final Logger   logger = LoggerFactory.getLogger(CrudTest.class);

    @Autowired
    private EmpController empController;





    @Test
    public void selectTest() throws UbiveloxException
    {

        List<Emp> emps = this.empController.getAllEmps();

        for ( Emp emp : emps )
        {
            logger.info("name:" + emp.getEname() + ", job:" + emp.getJob() + ", phone:" + emp.getPhone());
        }
    }





    @Test
    public void insertTest() throws UbiveloxException
    {
        Emp emp = new Emp("홍길동", "대리", "01011331333");
        assertEquals(emp, this.empController.addEmp(emp));

        emp = new Emp("유비원", "수석연구원", "01011331333");
        assertEquals(emp, this.empController.addEmp(emp));

        emp = new Emp("유비투", "선임연구원", "01011331333");
        assertEquals(emp, this.empController.addEmp(emp));

        emp = new Emp("유비쓰리", "과장", "01011331333");
        assertEquals(emp, this.empController.addEmp(emp));

        emp = new Emp("유비포", "본부장", "01011331333");
        assertEquals(emp, this.empController.addEmp(emp));

    }





    @Test
    public void updateTest() throws UbiveloxException
    {
        Emp emp = new Emp("이태규", "과장", "01011331333");
        assertEquals(emp, this.empController.updateEmp(emp));

        emp = new Emp("제영호", "팀장", "01011331333");
        assertEquals(emp, this.empController.updateEmp(emp));

        emp = new Emp("유영규", "책임연구원", "01011331333");
        assertEquals(emp, this.empController.updateEmp(emp));

    }





    @Test
    public void deleteTest() throws UbiveloxException
    {
        String ename = "홍길동";
        this.empController.deleteEmp(ename);

        ename = "유비원";
        this.empController.deleteEmp(ename);

        ename = "유비투";
        this.empController.deleteEmp(ename);

        ename = "유비쓰리";
        this.empController.deleteEmp(ename);

    }





    @Test
    public void errorTest() throws UbiveloxException, SQLNonTransientException
    {
        insertError(new Emp("이태규", "연구원", ""), "DB에 데이터가 이미 존재함");
        insertError(new Emp("이태규", "", ""), "DB에 데이터가 이미 존재함");
        insertError(new Emp("", "대리", "01011331333"), "데이터 null 에러");
        insertError(new Emp("호랑이", "", "01011331333"), "데이터 null 에러");
        insertError(new Emp("호랑이", "", ""), "데이터 null 에러");
        insertError(new Emp("", "", "01011331333"), "데이터 null 에러");
        insertError(new Emp("", "", ""), "데이터 null 에러");
        insertError(new Emp("", "대리", ""), "데이터 null 에러");

        updateError(new Emp("", "", ""), "DB에 데이터가 없음");
        updateError(new Emp("호홓", "연구원", ""), "DB에 데이터가 없음");
        updateError(new Emp("하하히", "연구원", ""), "DB에 데이터가 없음");
        updateError(new Emp("이태규", "", ""), "데이터 null 에러");
        updateError(new Emp("이태규", "", ""), "데이터 null 에러");

        deleteError(new Emp("하하히", "연구원", ""), "DB에 데이터가 없음");
        deleteError(new Emp("호홓", "연구원", ""), "DB에 데이터가 없음");

    }





    private void insertError(final Emp emp, final String errorMessage)
    {
        try
        {
            this.empController.addEmp(emp);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
    }





    private void updateError(final Emp emp, final String errorMessage)
    {
        try
        {
            this.empController.updateEmp(emp);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
    }





    private void deleteError(final Emp emp, final String errorMessage)
    {
        try
        {
            this.empController.updateEmp(emp);
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
    }
}
