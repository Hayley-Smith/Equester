package com.example.FFTEquester.model;

import javax.persistence.Entity;

@Entity
public class Sex extends AbstractEntity{
     private String sex;

     public String getSex() {
          return sex;
     }

     public void setSex(String sex) {
          this.sex = sex;
     }
}
