package site.wattsnwc.entity;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String username;
    private Integer age;

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }



}