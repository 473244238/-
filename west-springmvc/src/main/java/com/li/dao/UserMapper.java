package com.li.dao;

import com.li.pojo.funding2;
import com.li.pojo.User;
import com.li.pojo.school;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
//注册一个用户
    int Register( User users);

    //找到填写
        User Test(@Param("userCode") String userCode);

    //查询全部用户
    List<User> queryUser();

    //用于注册和登录
    User Userlogin(@Param("userCode")String userCode,@Param("Password")String Password);
    //添加一个统筹平台
    int addFund(funding2 funding2);

    //查询所有的众筹平台
    List<funding2> queryfund();

    //查询已经过审核状态的项目
    List<funding2> isState();

    //查询未过审核状态的项目
    List<funding2> noState();

    //更新用户的账户余额(有固定值）
    int UpdateBalance(@Param("userCode") String userCode);
   //更新用户花钱之后的账户金额
    int UpdateBalance2(User user);

    //关于用户的学校信息
    List<school> queryschool(@Param("schoolname") String schoolname);

    //根据id查询发起人的信息
    funding2 FundMess(@Param("fundid")int fundid);

   //根据用户的账号来查询用户
    User findUser(@Param("userCode")String userCode);

}
