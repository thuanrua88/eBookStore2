package com.company.BookManager;

public class Customers {
    private  int id, level;
    private String name, phone, add;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public Customers(int id, int level, String name, String phone, String add) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.phone = phone;
        this.add = add;
    }
}
