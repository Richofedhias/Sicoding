package org.d3ifcool.sicoding;

public class ScreenItem {
    String title, desc;
    int ScreenImg;

    public ScreenItem(String title, String desc, int screenImg) {
        this.title = title;
        this.desc = desc;
        ScreenImg = screenImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }
}
