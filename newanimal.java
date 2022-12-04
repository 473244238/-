package westtwotask2;

class  newanimal{
    private  String name;
    private int age;
    private String sex;
    private double price;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public newanimal(String name, int age, String sex, double price, String color){
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.price=price;
        this.color=color;

    }
    public newanimal(){

    }

    @Override
    public String toString() {
        return
                "name='" + name +
                        " \nage=" + age +
                        " \nsex='" + sex  +
                        "\nprice=" + price +
                        " \ncolor='" + color
                ;
    }
}
