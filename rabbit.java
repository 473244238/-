package westtwotask2;

import westtwotask2.Animal;

public class rabbit extends Animal {
  private  String  color;
  public rabbit(String name,int age,String sex,String color){
      super(name, age, sex,300);
      this.color=color;
  }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
      String s=  "这只兔子的名字："+super.getName()+"\n年龄:"+super.getAge()+"\n性别:"+super.getSex()+"\n价格:"+super.getPrice()+"\n兔子的颜色"+color;
      return s;
    }
}
