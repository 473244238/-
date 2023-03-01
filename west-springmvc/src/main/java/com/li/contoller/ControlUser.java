package com.li.contoller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.li.pojo.funding2;
import com.li.pojo.User;
import com.li.pojo.school;
import com.li.service.Userservice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.jws.soap.SOAPBinding;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/student")
public class ControlUser {
String usercode;

    @Autowired
    @Qualifier("userserviceimp")
private Userservice userservice;
    //注册一个用户
    @RequestMapping("/register")
    @ResponseBody
    public  String registe(@RequestBody User user){

        System.out.println("addUser-->"+ user);
        userservice.Register((com.li.pojo.User) user);
        return "1";
    }
    //添加众筹平台

    @RequestMapping("/addfund")
    @ResponseBody()
    public String addfund(@RequestBody funding2 funding2){
        System.out.println("addfund-->"+funding2);
        userservice.addFund(funding2);

            return "1";
    }
    //判断用户的账号和密码
    @RequestMapping(value = "/login", method=RequestMethod.GET)
    @ResponseBody
    public String login(String userCode, String userPassword){
     User user=userservice.loginUser(userCode, userPassword);
    if(user!=null){
       return "1";
   }
   return "0";
    }


    //填写校友信息
    @RequestMapping(value = "/Test", method=RequestMethod.GET)
    @ResponseBody
    public String Test(String useCode) throws JsonProcessingException {

        User user=userservice.Test(useCode);
        ObjectMapper mapper=new ObjectMapper();
        String str=mapper.writeValueAsString(user);
        return str;
    }
    //更新用户金额
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    @ResponseBody
    public int update(String usercode){
        int Is=userservice.UpdateUser(usercode);
        User user=userservice.Test(usercode);
        return user.getBanlance();

    }

    //更新用户金额2（已支付给众筹）
    @RequestMapping(value = "/update22",method = RequestMethod.GET)
    @ResponseBody
    public String update2(int banlance,String usercode){
        User user=userservice.finduser(usercode);
        user.setbanlance2(banlance);
        userservice.UpdateUser2(user);
        if(user.getBanlance()>0){
            return "1";
        }
        else{
            return "0";
        }

    }


    //查询平台信息

    @RequestMapping("/queryfund")
    @ResponseBody
    public String queryfund() throws JsonProcessingException {
        List<funding2> funding2List=userservice.queryFund();
        ObjectMapper mapper=new ObjectMapper();
        String str=mapper.writeValueAsString(funding2List);
        return str;
    }

    //查询用户的学校信息
    @RequestMapping("/querySchool")
    @ResponseBody
    public String queryschool(String schoolname) throws JsonProcessingException {
        List<school> schoolList=userservice.schoolquery(schoolname);
        ObjectMapper mapper=new ObjectMapper();
        String str=mapper.writeValueAsString(schoolList);
        return str;
    }


    //根据发起人id查找发起人信息
    @RequestMapping("/queryid")
    @ResponseBody
    public String queryid(int fundid) throws JsonProcessingException {
        funding2 funding2=userservice.Idquery(fundid);
        ObjectMapper mapper=new ObjectMapper();
        String str=mapper.writeValueAsString(funding2);
        return str;

    }
    //查询已过审核的平台信息
    @RequestMapping("/isstate")
    @ResponseBody
    public  String Isstate() throws JsonProcessingException {
        List<funding2> funding2List=userservice.isState();
        ObjectMapper mapper=new ObjectMapper();
        String str=mapper.writeValueAsString(funding2List);
        return str;

    }





}
