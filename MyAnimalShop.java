package westtwotask2;

import com.sun.istack.internal.FinalArrayList;
import westtwotask2.AnimalNotFoundException;
import westtwotask2.AnimalShop;
import westtwotask2.customer;
import westtwotask2.insufficientbanlanceexception;

import java.time.LocalDate;
import  java.util.ArrayList;
import java.util.Scanner;
public class MyAnimalShop extends newanimal implements AnimalShop  {
private double earn;

 public double getEarn() {
  return earn;
 }

 public void setEarn(double earn) {
  this.earn = earn;
 }

 private double balance;
 public ArrayList<newanimal> animals=new ArrayList<newanimal>();
public ArrayList<customer> customers=new FinalArrayList<customer>();
 boolean buisness;
 private double income;//用来买动物的钱

 public void setIncome(double income) {
  this.income = income;

 }

 public double getBalance() {
  return balance;
 }

 public void setBalance(double balance) {
  this.balance = balance;
 }

 public boolean isBuisness() {
  return buisness;
 }

 public void setBuisness(boolean buisness) {
  this.buisness = buisness;
 }



 public double getIncome() {
  return income;
 }



 @Override
 public void addanimal(String name, int age, String sex, double price,String color) {
  boolean result=false;//判断动物是否有买进来

  try {//判断是否有余额来买动物的异常
    result = comparsion(price, income);
  } catch (insufficientbanlanceexception ex) {
   System.out.println("出现了insufficientbanlanceexception错误"+ex.getMessage());
  }
  if(result==true){//如果余额足够，则将动物添加表中
newanimal a=new newanimal();
a.setName(name);
a.setAge(age);
a.setSex(sex);
a.setPrice(price);
a.setColor(color);
animals.add(a);
System.out.println("购买成功");
income=income-price;
balance=balance+price;

  }

 }
 @Override
 public void entertain(customer client) {
  Scanner s=new Scanner(System.in);
  boolean issold=false;//判断动物是否卖出去
System.out.println(client.toString());
customers.add(client);
System.out.println("你要买的动物的名字是什么");
String soldname=s.nextLine();
int a4=-1;
for(int i=0;i< animals.size();i++){//从列表中寻找顾客满意的动物
 newanimal a2=animals.get(i);
 if(a2.getName().equals(soldname)){
  a4=i;
  issold=true;
  break;
 }
}
try{//判断动物是否存在的异常
 isexist(issold);
}catch(AnimalNotFoundException e2){
 System.out.println("出现了AnimalNotFoundException错误"+e2.getMessage());
}
if(issold==true){
 newanimal Buyanimal=animals.get(a4);
 System.out.println(Buyanimal.toString());
 animals.remove(a4);//如果交易成功，则将动物移除
 client.setProfits(Buyanimal.getPrice());//存属这位顾客这一天在我们动物店所消费的金额

 System.out.println("交易成功，谢谢下次光临");
}


 }

 @Override
 public void goout() {
 Scanner s2=new Scanner(System.in);
 System.out.println("请输出你要查那一年利润的年份");
 int year=s2.nextInt();
  System.out.println("请输出你要查那一天利润的月份");
 int month=s2.nextInt();
  System.out.println("请输出你要查那一天利润的天");
 int date=s2.nextInt();
  earn=0;
 LocalDate localDate=LocalDate.of(year,month,date);
for(int i2=0;i2<customers.size();i2++){
      customer c2=customers.get(i2);
      if(c2.getLocalDate().equals(localDate)){
       System.out.println(c2.toString());
       earn=earn+c2.getProfits();
      }
     }
double money=earn-balance;
     System.out.println("所得到的利润"+money);


 }
 public static boolean comparsion(double a,double b )throws insufficientbanlanceexception{
  if(a>b){
   throw new insufficientbanlanceexception("你已经没有多余的余额去购买动物");

  }
  else{
   return true;
  }
 }
 public static void isexist(boolean e)throws AnimalNotFoundException{
  if(e==false){
   throw new AnimalNotFoundException("抱歉，店内没有你想要的动物");
  }
 }

}
