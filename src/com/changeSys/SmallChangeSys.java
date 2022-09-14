package com.changeSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;

        double balance=0;
        Date date = null; // 获取日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以用于日期格式化的
        String details = "----------零钱通明细----------";
        double money;

        double consume;
        String note;

        char quitConfirm;
        do{
            System.out.println("----------零钱通菜单----------");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消     费");
            System.out.println("\t\t4 退     出");
            System.out.print("请输入你的选择(1-4):");
            Scanner myScanner = new Scanner(System.in);
            byte choice = myScanner.nextByte();//            if(choice == 1){
            switch(choice){
                case 1:
                    System.out.println(details);
                    break;
                case 2:
                    System.out.print("收益入账：");
                    money = myScanner.nextDouble();
                    if (money <= 0){
                        System.out.println("收益金额有误");
                        break;
                    }
                    balance+=money;
                    date = new Date();
                    details += "\n收益入账"+"\t"+money+"\t"+sdf.format(date)+"\t余额："+balance;
                    break;
                case 3:
                    System.out.print("输入消费商店：");
                    note = myScanner.next();
                    System.out.print("输入金额：");
                    consume = myScanner.nextDouble();
                    if (consume<=0 || balance<consume){
                        System.out.println("消费金额有误或余额不足");
                        break;
                    }
                    balance -= consume;
                    details +="\n"+note+"\t-"+consume+"\t"+sdf.format(new Date())+"\t余额："+balance;
                    break;
                case 4:
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
                        loop =false;
                    break;
                default:
                    System.out.println("请输入正确的选择");
            }
//
//            }else if (choice == 2){
//
//            }else if (choice == 3){
//
//            }else if (choice == 4)
//                loop = false;
//            else
//                System.out.println("请输入正确的选择");
        }while(loop);
    }
}
