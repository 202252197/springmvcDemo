package com.lvshihao.entity;

/**
 * 功能描述
 *
 * @author 吕世昊
 * @date 2019-4-7$
 * @describe 想成为世界最厉害的程序员
 * @email 202252197@qq.com
 * @signature 我的梦想---兰博基尼{奋斗}
 */
public class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    private String age;

    public User(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
