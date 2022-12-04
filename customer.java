package westtwotask2;

import java.time.LocalDate;

public class customer {
        private String name;
        private int number;
        private LocalDate localDate;
private double profits=0;//弄一个顾客买东西所花费的钱，有利于计算利润

    public double getProfits() {
        return profits;
    }

    public void setProfits(double profit) {
       profits=profits+profit;
    }//用与顾客购买东西，将花了多少钱存起来

    public customer(String name, int number, int year, int month, int day){
            this.name=name;
            this.number=number;
            localDate=LocalDate.of(year,month,day);
        }
        public customer(){

        }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(int a,int b,int c) {
        localDate=localDate.of(a,b,c);
    }

    @Override
    public String toString() {
        return
                "顾客名字：" + name  +
                "\n顾客来的次数：" + number +
                "\n顾客最新到店时间：" + localDate
                ;
    }
}
