package com.akit.congnitivesite.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * E-mail as login
     * Letters, numbers, hyphens, and underscores.
     */
    @Column(nullable = false, unique = true, length = 50)
    private String login;

    /**
     * Password Letters, numbers, hyphens, and underscores, from 6 to 18 characters.
     * The password must be specified
     */
    @Column(nullable = false, length = 100)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name="userroles",
            joinColumns={@JoinColumn(name="userId", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="roleId", referencedColumnName="id")}
    )
    private List<Role> roles = new ArrayList<Role>();

    @Column(nullable = false)
    private Date registrationDate;

    private String email;

    private String address;

    private String phone;

    private String sex;

    private String name;

    private String surname;


    public User(String login, String password, Date registrationDate) {
        this.login = login;
        this.password = password;
        if (registrationDate != null) {
            this.registrationDate = registrationDate;
        } else {
            this.registrationDate = new Date();
        }
    }

    public User(String login, String password, Date registrationDate, Role role) {
        this.login = login;
        this.password = password;
        if (registrationDate != null) {
            this.registrationDate = registrationDate;
        } else {
            this.registrationDate = new Date();
        }
        this.roles.add(role);
    }

    public User(String login, String password, Date registrationDate,
                String email, String address, String phone, String sex, String name, String surname) {
        this.login = login;
        this.password = password;
        this.registrationDate = registrationDate;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String ligin) {
        this.login = ligin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRole() {
        return this.roles;
    }

    public void setRole(List<Role> role) {
        this.roles = role;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (!login.equals(user.login)) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (registrationDate != null ? !registrationDate.equals(user.registrationDate) : user.registrationDate != null)
            return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + login.hashCode();
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
