package com.company.services;

import java.util.List;
public interface IService <T>{
    public void ajouter(T t);
    public T getById(int id);
    public List<T> getAll();
    public boolean modifier(T t);
    public boolean supprimer(T t);
}