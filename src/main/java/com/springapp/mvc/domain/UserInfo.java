package com.springapp.mvc.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.sql.Date;

/**
* Created by Айрат on 02.04.2015.
*/
@Entity
@Table(name = "Users")
@Proxy(lazy=false)
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column
    private String patronymic;

    @Column(length = 1024)
    private String info;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 128)
    private String password;

    @Column
    private String gender;

    @Column
    private Date birthday;

    @Column
    private String city;


    public UserInfo() {
    }

    public UserInfo(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserInfo(String name, String surname, String patronymic, String info
            , String email, String password, String gender, Date birthday
            , String city
    ) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.info = info;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", info='" + info + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
//                ", posts=" + posts +
                '}';
    }
}
