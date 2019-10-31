package com.example.todo;

import android.widget.CheckBox;

public class Item {

    private boolean isClear;
    private String content;
    private CheckBox checkBox;

    public Item(String content) {
        this.isClear = false;
        this.content = content;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public boolean isClear() {
        return isClear;
    }

    public void setClear(boolean clear) {
        isClear = clear;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
