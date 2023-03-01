package com.li.service;

import com.li.dao.UserMapper;
import com.li.pojo.funding2;
import com.li.pojo.User;
import com.li.pojo.school;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserserviceIMP implements Userservice {

    //调用dao层的操作，设置一个set接口，方便Spring管理
    private UserMapper usermapper;

    public void setUsermapper(UserMapper usermapper) {
        this.usermapper = usermapper;
    }
//注册一个用户
 @Override
    public int Register(User users) {
        return usermapper.Register(users);
    }

    @Override
    public User Test(String userCode) {
        return usermapper.Test(userCode);
    }

    @Override
    public User loginUser(String userCode, String Passowrd) {
        return usermapper.Userlogin(userCode,Passowrd);
    }

    //查询全部用户的作用
    @Override
    public List<User> queryUser() {
        return usermapper.queryUser();
    }
//添加一个众筹平台

    @Override
    public int addFund(funding2 funding2) {
        return usermapper.addFund(funding2);
    }
//查询所有的众筹平台
    @Override
    public List<funding2> queryFund() {
        return usermapper.queryfund();
    }
    //查询已审核的项目
    @Override
    public List<funding2> isState() {
        return usermapper.isState();
    }

    @Override
    public List<school> schoolquery(String schoolname) {
        return usermapper.queryschool(schoolname);
    }

    @Override
    public funding2 Idquery(int fundid) {
        return usermapper.FundMess(fundid);
    }

    //更新用户金额
    @Override
    public int UpdateUser(String userCode) {
        return usermapper.UpdateBalance(userCode);
    }

    @Override
    public int UpdateUser2(User user) {
        return usermapper.UpdateBalance2(user);
    }

    @Override
    public User finduser(String userCode) {
        return usermapper.findUser(userCode);
    }


}
