/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa04_da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zuley
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long> {

    @Override
    public Empleado create(Empleado p) {
        ConexionDB cx = ConexionDB.getInstance();
        TransaccionDB tdb = new TransaccionDB<Empleado>(p) { //Instancia anonima
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "insert into empleados (clave, nombre, direccion, "
                            + "telefono) values (?,?,?,?);";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setLong(1, p.getClave());
                    pst.setString(2, p.getNombre());
                    pst.setString(3, p.getDireccion());
                    pst.setString(4, p.getTelefono());
                    pst.execute();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }

            }

        };
        boolean res = cx.execute(tdb);
        if (res) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se guardo");
        } else {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "Error");
        }
        return p;
    }

    @Override
    public boolean delete(Empleado p) {
        ConexionDB cx = ConexionDB.getInstance();
        TransaccionDB tdb = new TransaccionDB<Empleado>(p) { //Instancia anonima
            @Override
            public boolean execute(Connection con) {
                String sql = "delete from  empleados where  id= '" + p.getClave() + "'";
                PreparedStatement pst;
                try {
                    pst = con.prepareStatement(sql);
                    pst.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
        };
        boolean res = cx.execute(tdb);
        if (res) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se guardo");
            return true;
        } else {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "Error...");
            return false;
        }

    }

    @Override
    public Empleado update(Empleado p, Long id) {
        ConexionDB cx = ConexionDB.getInstance();
        TransaccionDB tdb = new TransaccionDB<Empleado>(p) { //Instancia anonima
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "update empleados set nombre=?, direccion=?, telefono=? where=?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, p.getNombre());
                    pst.setString(2, p.getDireccion());
                    pst.setString(3, p.getTelefono());
                    pst.setInt(4, id);
                    pst.execute();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }

            }

        };
        boolean res = cx.execute(tdb);
        if (res) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "Se actualizo el empleado");
        } else {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "Error...");
        }

        return p;
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> empleados = new ArrayList<>();
        ConexionDB cx = ConexionDB.getInstance();
        TransaccionDB tdb = new TransaccionDB<List<Empleado>>(empleados) { //Instancia anonima
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "select * from empleados";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.execute();
                    if (empleados != null) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }

            }

        };
        boolean res = cx.execute(tdb);
        if (res) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.INFO, "lista de  empleado");
        } else {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "Error...");
        }
        return empleados;
    }

    @Override
    public Empleado findById(Long id) {
        ConexionDB cx = ConexionDB.getInstance();
        Empleado p = new Empleado();
        TransaccionDB tdb = new TransaccionDB<Empleado>(p) { //Instancia anonima
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "select * from empleados where clave=?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, id);
                    pst.execute();
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }

            }

        };
        boolean res = cx.execute(tdb);
        if (res) {
            return p;
        } else {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, "empleado no encontrado");
            return null;
        }
    }

//    @Override
//    public Empleado update(Empleado p, Long id) {
//        return null;
//    }
//    @Override
//    public List<Empleado> findAll() {
//        return null;
//    }
//    @Override
//    public Empleado findById(Long id) {
//        return null;
//    }
}
