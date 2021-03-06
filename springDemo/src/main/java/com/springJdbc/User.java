package com.springJdbc;

public class User {
    private int id;
    private String username;
    private int age;
    private String sex;
    private String password;

    public User(int id, String username, int age, String sex, String password) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.sex = sex;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
