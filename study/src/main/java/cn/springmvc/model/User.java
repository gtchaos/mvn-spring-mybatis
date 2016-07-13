package cn.springmvc.model;

import java.sql.Date;

/**
 * Created by baidu on 16/7/12.
 */
public class User {

    private int id;
    private String name;
    private int age;
    private Date create_time;
    private Date update_time;
    private int state;
    private String nickname;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Date getUpdate_time() {
        return update_time;
    }
    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public void setAge(int age) {this.age = age;}
    public int getAge(){return age;}
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
