package westtwotask2;

import westtwotask2.Animal;

public class cat extends Animal {
    public cat(String name,int age,String sex){
        super(name,age,sex,200);
    }

    @Override
    public String toString() {
       String s="猫的名字:"+super.getName()+"\n猫的年龄:"+super.getAge()+"\n猫的性别："+super.getSex()+"\n猫的价格:"+super.getPrice();
       return s;
    }
}
