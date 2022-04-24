/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author lenovo
 */
public interface DemandeService <T>{
     void ajouter(T t);
    void modifier(T t);
    void supprimer(int id);
    public List GetAll();
    public T GetById(int id);
    
    
}
