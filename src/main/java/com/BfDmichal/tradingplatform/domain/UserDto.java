package com.BfDmichal.tradingplatform.domain;


public class UserDto {
    private int id;
    private String email;
    private String password;
    private int phone;

    public UserDto(int id, String email, String password, int phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }
}
