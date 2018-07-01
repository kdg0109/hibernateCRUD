package com.ubivelox.hibernate.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLNonTransientException;
import java.util.List;

import org.junit.Before;
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





    @Before
    public void settingTest() throws UbiveloxException
    {

        List<Emp> emps = this.empController.getAllEmps();

        for ( Emp emp : emps )
        {
            this.empController.deleteEmp(emp.getEname());
        }

        Emp emp = new Emp("김준기", "그룹장", "01011111111");
        assertEquals(emp, this.empController.addEmp(emp));
        emp = new Emp("임운혁", "팀잠", "01022222222");
        assertEquals(emp, this.empController.addEmp(emp));
        emp = new Emp("송석일", "수석연구원", "01033333333");
        assertEquals(emp, this.empController.addEmp(emp));
        emp = new Emp("정성호", "책임연구원", "01044444444");
        assertEquals(emp, this.empController.addEmp(emp));
        emp = new Emp("제영호", "책임연구원", "01055555555");
        assertEquals(emp, this.empController.addEmp(emp));
        emp = new Emp("유영규", "선임연구원", "01066666666");
        assertEquals(emp, this.empController.addEmp(emp));
        emp = new Emp("이태규", "연구원", "01077777777");
        assertEquals(emp, this.empController.addEmp(emp));
        emp = new Emp("김동건", "연구원", "01088888888");
        assertEquals(emp, this.empController.addEmp(emp));
    }





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
        String ename = "유영규";
        this.empController.deleteEmp(ename);

        ename = "이태규";
        this.empController.deleteEmp(ename);

        ename = "김동건";
        this.empController.deleteEmp(ename);
    }





    @Test
    public void errorTest() throws UbiveloxException, SQLNonTransientException
    {

        // insertError(new Emp("이태규sssssssssssssssssssssss", "연구원", ""), "DB에 데이터가 이미 존재함");
        insertError(new Emp("이태규", "연구원", ""), "DB에 데이터가 이미 존재함");
        insertError(new Emp("이태규", "", ""), "데이터 null or Empty 에러");
        insertError(new Emp("", "대리", "01011331333"), "데이터 null or Empty 에러");
        insertError(new Emp("호랑이", "", "01011331333"), "데이터 null or Empty 에러");
        insertError(new Emp("호랑이", "", ""), "데이터 null or Empty 에러");
        insertError(new Emp("", "", "01011331333"), "데이터 null or Empty 에러");
        insertError(new Emp("", "", ""), "데이터 null or Empty 에러");
        insertError(new Emp("", "대리", ""), "데이터 null or Empty 에러");

        updateError(new Emp("", "", ""), "데이터 null or Empty 에러");
        updateError(new Emp("호홓", "연구원", ""), "DB에 데이터가 없음");
        updateError(new Emp("하하히", "연구원", ""), "DB에 데이터가 없음");
        updateError(new Emp("이태규", "", ""), "데이터 null or Empty 에러");
        updateError(new Emp("이태규", "", ""), "데이터 null or Empty 에러");

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
            this.empController.deleteEmp(emp.getEname());
            fail();
        }
        catch ( UbiveloxException e )
        {
            assertEquals(errorMessage, e.getMessage());
        }
    }
}
