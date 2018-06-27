package com.ubivelox.hibernate.client;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubivelox.hibernate.model.Emp;
import com.ubivelox.hibernate.service.EmpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientUtil
{

    static final Logger logger = LoggerFactory.getLogger(RestClientUtil.class);

    @Autowired
    private EmpService  empService;





    @Test
    public void selectTest()
    {

        List<Emp> emps = this.empService.getAllEmps();

        for ( Emp emp : emps )
        {
            logger.info("name:" + emp.getEname() + ", job:" + emp.getJob() + ", phone:" + emp.getPhone());
        }
    }





    @Test
    public void insertTest()
    {
        Emp emp = new Emp("홍길동", "대리", "010-1133-1333");
        boolean check = this.empService.addEmp(emp);

        assertEquals(true, check);

    }





    @Test
    public void updateTest()
    {
        Emp emp = new Emp("홍길동", "대리2", "010-1133-1333");
        this.empService.updateEmp(emp);

    }





    @Test
    public void deleteTest()
    {
        String ename = "홍길동";
        this.empService.deleteEmp(ename);

    }
}
