package models;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDate;
import java.time.LocalDateTime;


public class User {
 
    private int id_user ;
    
    private String first_name;
    
    private String last_name;
    
    private String email;
    
    private String username;
    
    private String password;
    
    private int number;
        
    private Roles role;
    
    private LocalDateTime birthday;
    
    private LocalDateTime date_created_user;
    
    private LocalDateTime last_updated_user;

    public User() {
    }

    public User(int id_user, String first_name, String last_name, String email, String username, String password, int number, Roles role, LocalDateTime birthday, LocalDateTime date_created_user, LocalDateTime last_updated_user) {
        this.id_user = id_user;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.number = number;
        this.role = role;
        this.birthday = birthday;
        this.date_created_user = date_created_user;
        this.last_updated_user = last_updated_user;
    }

    public User(String first_name, String last_name, String email, String username, String password, int number, Roles role, LocalDateTime birthday, LocalDateTime date_created_user, LocalDateTime last_updated_user) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.number = number;
        this.role = role;
        this.birthday = birthday;
        this.date_created_user = date_created_user;
        this.last_updated_user = last_updated_user;
    }

    public long getId_user() {
        return id_user;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getNumber() {
        return number;
    }

    public Roles getRole() {
        return role;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public LocalDateTime getDate_created_user() {
        return date_created_user;
    }

    public LocalDateTime getLast_updated_user() {
        return last_updated_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public void setDate_created_user(LocalDateTime date_created_user) {
        this.date_created_user = date_created_user;
    }

    public void setLast_updated_user(LocalDateTime last_updated_user) {
        this.last_updated_user = last_updated_user;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", username=" + username + ", password=" + password + ", number=" + number + ", role=" + role + ", birthday=" + birthday + ", date_created_user=" + date_created_user + ", last_updated_user=" + last_updated_user + '}';
    }
    
}

