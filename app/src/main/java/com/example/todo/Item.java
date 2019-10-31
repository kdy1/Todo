package com.example.todo;


public class Item {

    private boolean isClear;
    private String content;
    private boolean checked;

    public Item(String content) {
        this.isClear = false;
        this.content = content;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
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
