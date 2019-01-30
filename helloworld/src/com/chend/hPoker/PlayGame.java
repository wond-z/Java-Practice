package com.chend.hPoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
 * 简易poker游戏
 * 1、提示创建扑克牌---创建
 * 2、提示创建成功---展示
 * 3、提示洗牌---洗牌---提示洗牌结束
 * 4、提示创建玩家---创建玩家---输入玩家信息(判断合法)--欢迎
 * 5、提示发牌---发牌---展示--提示发牌结束
 * 6、提示开始游戏---开始---展示
 * 7、提示获胜--展示各自手牌
 */
public class PlayGame {
    private List<Poker> pokerList = new ArrayList<Poker>();//创建扑克List
    private List<People> peopleList = new ArrayList<People>();//创建玩家List

    /*
     * 1、提示创建扑克牌---创建
     */
    private void createPoker() {
        System.out.println("------创建扑克牌------");
        String[] shapeColorList = new String[] {"黑桃","红桃","梅花","方块"}; //权重由小到大
        String[] valList = new String[] {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};//权重由小到大
        for (int i = 0; i < shapeColorList.length; i++) {
            for (int j = 0; j < valList.length; j++) {
                pokerList.add(new Poker(shapeColorList[i],i,valList[j],j));
            }
        }
    }

    /*
     * 2、提示创建成功---展示
     */
    private void showPoker() {
        System.out.println("------扑克牌创建成功！------");
        System.out.println("为："+pokerList.toString());
    }

    /*
     * 3、提示洗牌---洗牌---提示洗牌结束
     */
    private void upsetPoker() {
        System.out.println("------开始洗牌...-------");
        Collections.shuffle(pokerList);
        System.out.println("------洗牌结束！------");
//      //验证
//      System.out.println("为："+pokerList.toString());
    }

    /*
     * 4、提示创建玩家---创建玩家---输入玩家信息(判断合法)--欢迎
     */
    private void createPeople() {
        System.out.println("------创建玩家...------");
        int peopleNum = 2; //玩家数
        Integer id;
        String name;
        Scanner console = null;
        for (int j = 1; j <= peopleNum; j++) {
            System.out.println("请输入第"+j+"位玩家的ID和姓名：");
            while(true){
                try {
                    System.out.println("输入ID：");
                    console = new Scanner(System.in);
                    id = console.nextInt();
                    if(peopleList.contains(new People(id,null))) {
                        System.out.println("此Id已存在！");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("请输入整数类型ID！");
                    continue;
                }
            }
            while(true){
                System.out.println("输入姓名：");
                console = new Scanner(System.in);
                name = console.nextLine();
                if(peopleList.contains(new People(null,name))) {
                    System.out.println("此name已存在！");
                    continue;
                }
                break;
            }
            peopleList.add(new People(id,name));
        }
        console.close();//关闭输入
        //欢迎
        for (People people : peopleList) {
            System.out.println("----欢迎玩家："+people.getName());
        }
    }

    /*
     * 5、提示发牌---发牌---展示--提示发牌结束
     */
    private void issuePoker() {
        System.out.println("------开始发牌...-------");
        int i = 2;//发牌次数
        int j = 0;//初始牌下标
        while(i>0) {
            for (People people : peopleList) {
                System.out.println("---玩家"+people.getName()+"-拿牌");
                people.pokers.add(pokerList.get(j));
                j++;
            }
            i--;
        }
        System.out.println("------发牌结束！-------");

//      //验证
//      for (People people : peopleList) {
//          System.out.println(people.getName()+people.pokers.toString());
//      }

    }

    /*
     * 6、提示开始游戏---开始---展示
     */
    public void play() {
        System.out.println("------开始游戏...-------");
        for (People people : peopleList) {
            Collections.sort(people.pokers);//排序
            System.out.println("玩家："+people.getName()+"最大的手牌为："+people.pokers.get(0));
        }
    }

    /*
     * 7、提示获胜--展示各自手牌
     */
    private void gameOver() {
        List<Poker> peopleBigPokerList = new ArrayList<Poker>();//所有玩家最大牌List
        for (People people : peopleList) {
            peopleBigPokerList.add(people.pokers.get(0));
        }
        Collections.sort(peopleBigPokerList);
        Poker bigPoker = peopleBigPokerList.get(0);//所有玩家最大牌
        for (People people : peopleList) {
            if(people.pokers.contains(bigPoker)) {
                System.out.println("------玩家："+people.getName()+"获胜！------");
            }
        }
        System.out.println("玩家各自的手牌为：");
        for (People people : peopleList) {
            System.out.println(people.getName()+"："+people.pokers.toString());
        }
    }

    public static void main(String[] args) {
        PlayGame go = new PlayGame(); 
        go.createPoker();
        go.showPoker();
        go.upsetPoker();
        go.createPeople();
        go.issuePoker();
        go.play();
        go.gameOver();
    }
}
