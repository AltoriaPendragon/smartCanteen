package com.firstproject.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String sex;
    private Integer age;
    private String nickname;
    private String password;
    private Integer balance;

    private Integer money; //充值金额
}
