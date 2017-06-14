package com.example.user.interviewsample.data;

/**
 * 文件描述 : RecyclerView 所用
 * Created by User
 * 2017/6/13
 * 版本 : 0.0.0.1
 */

public class ItemEvent {

    public static final int MAIN_TYPE = 0;
    public static final int EVENT_TYPE = 1;

    private String mName;
    private String mDescription;
    private int mType;

    public ItemEvent(String name, String description, int type) {
        this.mName = name;
        this.mDescription = description;
        this.mType = type;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setmDescription(String description) {
        this.mDescription = description;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

}
