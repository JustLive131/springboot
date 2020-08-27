package com.dyn.springbootdemo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_phone")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class PhoneDO {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String phoneId;

    @Column(length = 255)
    private String phoneName;


}
