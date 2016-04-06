package com.example.jiaxin.animationdemo.model;

/**
 * Created by xin.jia
 * since 2016/1/12
 */
public class ButtonParam {

    private int leftPos;
    private int rightPos;

    public ButtonParam() {
    }

    public ButtonParam(int leftPos, int rightPos) {
        this.leftPos = leftPos;
        this.rightPos = rightPos;
    }

    public int getLeftPos() {
        return leftPos;
    }

    public void setLeftPos(int leftPos) {
        this.leftPos = leftPos;
    }

    public int getRightPos() {
        return rightPos;
    }

    public void setRightPos(int rightPos) {
        this.rightPos = rightPos;
    }
}
