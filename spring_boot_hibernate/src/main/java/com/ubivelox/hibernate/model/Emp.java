package com.ubivelox.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emp")
public class Emp implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = -5607896222073954614L;

    @Id
    @Column(name = "ename",
            nullable = false)
    private String            ename;

    @Column(name = "job",
            nullable = false)
    private String            job;

    @Column(name = "phone")
    private String            phone;





    public Emp(final String ename, final String job, final String phone)
    {
        this.ename = ename;
        this.job = job;
        this.phone = phone;
    }

}
