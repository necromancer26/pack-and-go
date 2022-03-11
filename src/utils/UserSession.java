/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import models.Roles;

/**
 *
 * @author Wala
 */
public final class UserSession {

    private static UserSession instance;

    public static void getInstace(long id_user) {
    }

    private Long userId;
    private Roles role;

    public UserSession(Long userId, Roles role) {
        this.userId = userId;
        this.role = role;
    }

    public static UserSession getInstace(Long userId, Roles role) {
        if(instance == null) {
            instance = new UserSession(userId, role);
        }
        return instance;
    }
    
    public static UserSession getInstace() {
        if(instance != null) {
            return instance;
        }
        return null;
    }

    public Long getUserId() {
        return userId;
    }

    public Roles getRole() {
        return role;
    }

    public void cleanUserSession() {
        userId = null;// or null
        role = null;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "UserId='" + userId + '\'' +
                ", Role=" + role +
                '}';
    }
}