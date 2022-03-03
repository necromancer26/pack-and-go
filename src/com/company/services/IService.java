/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.services;

import com.company.models.User;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wala
 */
public interface IService <T>{
     void ajouter(T t);
     T getById(long id) throws SQLException;
     List<T> getAll() throws SQLException;
     void modifier(long id, T t) throws SQLException;
     void supprimer(long id) throws SQLException;

}