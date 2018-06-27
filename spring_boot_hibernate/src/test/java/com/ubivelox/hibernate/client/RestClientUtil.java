package com.ubivelox.hibernate.client;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ubivelox.hibernate.model.Emp;
import com.ubivelox.hibernate.service.EmpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientUtil
{

    @Autowired
    private EmpService empService;





    @Test
    public void test()
    {

        List<Emp> emps = this.empService.getAllEmps();
        // System.out.println("aas");
        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        // RestTemplate restTemplate = new RestTemplate();
        // String url = "http://localhost:8030/jsp/emps";
        // HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        // ResponseEntity<Emp[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Emp[].class);
        // Emp[] emps = responseEntity.getBody();

        for ( Emp emp : emps )
        {
            System.out.println("name:" + emp.getEname() + ", job:" + emp.getJob() + ", phone:" + emp.getPhone());
        }
    }
}
