package regredx;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {


    public boolean isEmail(String email) {
        System.out.println("开始测验你的邮箱");
        if (email.isEmpty()) {
            System.out.println("你的邮箱是空的，请重新输入");
            return false;
        } else {
            String RULE_EMAIL = ("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.]+[A-Za-z0-9]+)*$");
            Pattern p = Pattern.compile(RULE_EMAIL);//不知道为什么这种“zhangxindeailian2@163.com----123aaa”邮箱错误
            Matcher m = p.matcher(email);
            boolean isvalid = m.matches();
            return isvalid;
        }
    }

    }

