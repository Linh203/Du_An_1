package com.example.du_an_1.Model;

public class Category {
    private String name_Menu,img_Menu;

    public Category() {
    }

    public Category(String name_Menu, String img_Menu) {
        this.name_Menu = name_Menu;
        this.img_Menu = img_Menu;
    }

    public String getName_Menu() {
        return name_Menu;
    }

    public void setName_Menu(String name_Menu) {
        this.name_Menu = name_Menu;
    }

    public String getImg_Menu() {
        return img_Menu;
    }

    public void setImg_Menu(String img_Menu) {
        this.img_Menu = img_Menu;
    }
}
