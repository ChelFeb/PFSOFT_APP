package com.akit.congnitivesite.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class UserInfo {

    public UserInfo() {
    }

    public UserInfo(String login,
                    String email,
                    String address,
                    String phone,
                    String sex,
                    String name,
                    String surname) {
        this.login = login;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.name = name;
        this.surname = surname;
    }

    @NotEmpty (message = "You have to specify login")
    private String login;

    private String email;

    private String address;

    private String phone;

    private String sex;

    private String name;

    private String surname;

    private String roles;

    @Size(min=6, max=18, message = "Пароль должен быть от 6 до 18 символов")
    private String password;

    @Size(min=6, max=18, message = "Пароль должен быть от 6 до 18 символов")
    private String confirmPassword;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "roles='" + roles + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
