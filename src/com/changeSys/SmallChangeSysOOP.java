package com.changeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP{
    private double balance;
    private String details = "----------零钱通明细----------";
    private boolean loop = true;
    byte choice;

    Date date = null;
    Scanner myScanner = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public SmallChangeSysOOP(){
        this(2000);
    }

    public SmallChangeSysOOP(double balance){
        this.balance = balance;
        setDetails("收益入账",2000,'+');
    }

    public void inCome(){
        System.out.print("收益入账：");
        double income = myScanner.nextDouble();
        if (income <= 0){
            System.out.println("收益金额有误");
        }
        balance+= income;
        setDetails("收益入账",income,'+');
    }

    public void Consume(){
        System.out.print("输入消费商店：");
        String note = myScanner.next();
        System.out.print("输入金额：");
        double consume = myScanner.nextDouble();
        if (consume <=0 || balance< consume){
            System.out.println("消费金额有误或余额不足");
        }
        balance -= consume;
        setDetails(note,consume,'-');
    }

    public void Quit(){
        char quitConfirm;
        do{
            System.out.print("你确定要退出吗？y/n:");
            quitConfirm = myScanner.next().charAt(0);
            if (quitConfirm == 'y' || quitConfirm=='n') {
                break;
            }
            else
                System.out.println("必须输入正确的y/n");
        }while(true);
        if(quitConfirm == 'y')
            loop = false;
    }

    public String getDetails(){
        return this.details;
    }

    public void setDetails(String details,double money,char flag) {
        this.details += "\n"+details+"\t"+flag+ money +"\t"+sdf.format(new Date())+"\t余额："+this.balance;;
    }

    public void mainMenu() {
        do {
            System.out.println("----------零钱通菜单----------");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消     费");
            System.out.println("\t\t4 退     出");
            System.out.print("请输入你的选择(1-4):");
            choice = myScanner.nextByte();
            switch (choice) {
                case 1 -> System.out.println(getDetails());
                case 2 -> inCome();
                case 3 -> Consume();
                case 4 -> Quit();
                default -> System.out.println("请输入正确的选择");
            }
        }while(loop);
    }


}
