package com.classparameter;

public class ChildGame {
    public static void main(String[] args) {
        Child c1 = new Child("kong");
        Child c2 = new Child("jie");
        Child c3 = new Child("lee");

        c1.play();
        Child.count++;
        c2.play();
        Child.count++;
        c3.play();
        Child.count++;
        System.out.println("共有"+Child.count+"加入游戏");
    }
}

class Child{
    private String name;
    //定义一个变量count，是一个类变量(静态变量)static
    //该变量最大特点就是会被Child类对象实例所共享
    //类变量是随着类的加载而创建的，没有对象实例也可以访问


    public static int count = 0;

    public Child() {
        this("joker");
    }

    public Child(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Child{name = " + name + "}";
    }

    public void play(){
        System.out.println("playing");
    }
}