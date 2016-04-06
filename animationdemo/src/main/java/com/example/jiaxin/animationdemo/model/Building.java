package com.example.jiaxin.animationdemo.model;

/**
 * Created by xin.jia
 * since 2016/1/13
 */
public class Building {

    private int buildingId;
    private String buildingName;
    private String buildingDesc;
    private int buildingType;
    private int buildingHeight;
    private int buildingWidth;
    private int buildingColor;

    public Building() {
    }

    public Building(int buildingId, String buildingName, String buildingDesc, int buildingType, int buildingHeight, int buildingWidth) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.buildingDesc = buildingDesc;
        this.buildingType = buildingType;
        this.buildingHeight = buildingHeight;
        this.buildingWidth = buildingWidth;
    }

    public int getBuildingHeight() {
        return buildingHeight;
    }

    public void setBuildingHeight(int buildingHeight) {
        this.buildingHeight = buildingHeight;
    }

    public int getBuildingWidth() {
        return buildingWidth;
    }

    public void setBuildingWidth(int buildingWidth) {
        this.buildingWidth = buildingWidth;
    }

    public int getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(int buildingType) {
        this.buildingType = buildingType;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingDesc() {
        return buildingDesc;
    }

    public void setBuildingDesc(String buildingDesc) {
        this.buildingDesc = buildingDesc;
    }

    public int getBuildingColor() {
        return buildingColor;
    }

    public void setBuildingColor(int buildingColor) {
        this.buildingColor = buildingColor;
    }
}
