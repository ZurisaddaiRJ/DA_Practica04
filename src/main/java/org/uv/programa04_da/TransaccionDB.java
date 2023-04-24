/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa04_da;

import java.sql.Connection;



/**
 *
 * @author zuley
 */
//agregacion
public abstract class TransaccionDB <T> {//permitir que reciba en parametro de POJO
    protected T p;//Recibimos p como parametro
    protected TransaccionDB(T p){//Quien va a tener acceso al constructor van a ser las derivadas
        this.p=p;
    }
    public abstract boolean execute(Connection con);
    //Execute recibe un parametro connection
}
