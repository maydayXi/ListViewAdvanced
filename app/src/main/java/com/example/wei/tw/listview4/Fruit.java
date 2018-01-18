package com.example.wei.tw.listview4;

// Item model
public class Fruit {

    // 宣告每個項目資料需要的欄位變數
    private long id;
    private String name;
    private String content;
    private boolean selected;

    // 建構子
    Fruit(long id, String name, String content, boolean selected) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.selected = selected;
    }

    // 讀取與設定欄位變數的方法

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    void setSelected(boolean selected) {
        this.selected = selected;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String getContent() {
        return content;
    }

    boolean isSelected() {
        return selected;
    }
}
