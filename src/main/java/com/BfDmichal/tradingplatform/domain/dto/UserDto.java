package com.BfDmichal.tradingplatform.domain.dto;


public class UserDto {
    private int id;
    private String email;
    private String password;
    private int phone;
    private String role;

    public UserDto(int id, String email, String password, int phone, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
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

    public String getRole() {
        return role;
    }
}
