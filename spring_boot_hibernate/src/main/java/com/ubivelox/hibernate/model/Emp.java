package com.ubivelox.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Emp implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -5607896222073954614L;

    @Id
    @Column(name = "ename")
    private String            ename;

    @Column(name = "job")
    private String            job;

    @Column(name = "phone")
    private String            phone;





    public Emp()
    {
    }





    public Emp(final String ename, final String job, final String phone)
    {
        this.ename = ename;
        this.job = job;
        this.phone = phone;
    }





    @Column(name = "ename")
    public String getEname()
    {
        return this.ename;
    }





    @Column(name = "job")
    public String getJob()
    {
        return this.job;
    }





    @Column(name = "phone")
    public String getPhone()
    {
        return this.phone;
    }





    public void setEname(final String ename)
    {
        this.ename = ename;
    }





    public void setJob(final String job)
    {
        this.job = job;
    }





    public void setPhone(final String phone)
    {
        this.phone = phone;
    }
}
