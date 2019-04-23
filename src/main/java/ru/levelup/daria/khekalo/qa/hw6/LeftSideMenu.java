package ru.levelup.daria.khekalo.qa.hw6;

public enum  LeftSideMenu {
    MY_VIEW("My View"),
    VIEW_ISSUES("View Issues"),
    REPORT_ISSUE("Report Issue"),
    CHANGE_LOG("Change Log"),
    ROAD_MAP("Roadmap"),
    SUMMARY("Summary"),
    MANAGE("Manage");



    private String value;

    LeftSideMenu(String value){
        this.value = value;

    }

    public String getValue(){
        return  value;
    }

}
