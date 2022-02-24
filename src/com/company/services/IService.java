/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wala
 */
public interface IService <T>{
    public void ajouter(T t);
    public T getById(long id) throws SQLException;
    public List<T> getAll() throws SQLException;
    public void modifier(long id, T t) throws SQLException;
    public void supprimer(long id) throws SQLException;
}
