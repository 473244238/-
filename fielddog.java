package westtwotask2;

import westtwotask2.Animal;

public class fielddog extends Animal {
private boolean isvaccine;
public fielddog(String name,int age,String sex,boolean isvaccine){
    super( name, age, sex,100);
    this.isvaccine=isvaccine;//狗狗是否被注射疫苗
}

    public boolean isIsvaccine() {
        return isvaccine;
    }

    public void setIsvaccine(boolean isvaccine) {
        this.isvaccine = isvaccine;
    }


    @Override
    public String toString() {
        String s="这只田园犬的名字："+super.getName()+"\n年龄:"+super.getAge()+"\n性别:"+super.getSex()+"\n价格:"+super.getPrice()+"\n被打疫苗的情况:"+isvaccine;
    return s;
}
}
