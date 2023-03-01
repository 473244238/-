package com.li.service;

import com.li.pojo.funding2;
import com.li.pojo.User;
import com.li.pojo.school;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Userservice {
    //注册一个用户
    int Register(User users);


    //填写校友名称
    User Test(String userCode);
    //判断登录
    User loginUser(String userCode,String Passowrd);

    //查询全部用户信息
    List<User> queryUser();

    //添加众筹平台

    int addFund(funding2 funding2);

    //查询众筹平台
    List<funding2>  queryFund();


    //查询已过申核状态的项目
    List<funding2> isState();

  //查询学校信息
    List<school> schoolquery(String schoolname);

    //根据发起人的id来查询发起人的信息
    funding2 Idquery(int fundid);

    //更新用户金额
    int UpdateUser(String userCode);

    //更新用户金额（支出）
    int UpdateUser2(User user);

    //根据用户账号来查找用户信息
    User finduser(String userCode);
}
