package com.li.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String userCode;
    private String userPassword;
    private String userSchool;
    private String userName;
    private String gender;
    private int administrator;
    private int banlance;


    public void setbanlance2(int banlance2){
        banlance=banlance-banlance2;
    }
}
