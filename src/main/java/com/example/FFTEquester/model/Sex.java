package com.example.FFTEquester.model;

import javax.persistence.Entity;

@Entity
public class Sex extends AbstractEntity{

     private String sex;

     public Sex(String sex) {
          this.sex = sex;
     }

     public Sex() {
     }

     public String getSex() {
          return sex;
     }

     public void setSex(String sex) {
          this.sex = sex;
     }
}
