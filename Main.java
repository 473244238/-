package westtwotask2;

import westtwotask2.customer;

public class Main extends customer {
    public static void main(String[] args) {
MyAnimalShop l=new MyAnimalShop();
l.setBalance(0);
fielddog dog1=new fielddog("dog1",6,"男",true);
dog1.setPrice(0);
cat c1=new cat("cat1",1,"男");
c1.setPrice(0);
rabbit r1=new rabbit("cc",18,"女","blue");
r1.setPrice(0);
l.setIncome(3000);
l.setBuisness(true);
l.addanimal(dog1.getName(), dog1.getAge(), dog1.getSex(), dog1.getPrice(),"black");
l.addanimal(c1.getName(), c1.age, c1.getSex(), c1.getPrice(), "red");
l.addanimal("老虎",19,"男",1000,"white");
System.out.println(l.getIncome());
customer cc1=new customer();
cc1.setName("李宇杰");
cc1.setNumber(1);
cc1.setLocalDate(2022,9,8);
customer cc2=new customer();
cc2.setName("李雪茹");
cc2.setNumber(1);
cc2.setLocalDate(2022,9,8);
l.entertain(cc1);
l.entertain(cc2);
System.out.println(l.getIncome());
        System.out.println(l.getBalance());
l.goout();




    }
}