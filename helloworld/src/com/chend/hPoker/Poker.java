package com.chend.hPoker;

public class Poker implements Comparable<Poker>{
    private String shapeColor;//花色
    private Integer colorNum;//花色权重
    private String val;//牌值
    private Integer valNum;//牌值权重

    public Poker(String shapeColor, Integer colorNum, String val, Integer valNum) {
        this.shapeColor = shapeColor;
        this.val = val;
        this.colorNum = colorNum;
        this.valNum = valNum;
    }

    public Integer getValNum() {
        return valNum;
    }
    public void setValNum(Integer valNum) {
        this.valNum = valNum;
    }
    public Integer getColorNum() {
        return colorNum;
    }
    public void setColorNum(Integer colorNum) {
        this.colorNum = colorNum;
    }
    public String getShapeColor() {
        return shapeColor;
    }
    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }
    public String getVal() {
        return val;
    }
    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return shapeColor + val;
    }
    //覆写，权重大的靠前
    @Override
    public int compareTo(Poker o) {
        if(valNum!=o.valNum)
            return o.valNum.compareTo(valNum);
        else
            return o.colorNum.compareTo(colorNum);
    }

}
