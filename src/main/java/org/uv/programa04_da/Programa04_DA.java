/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package org.uv.programa04_da;

import java.util.logging.Logger;

/**
 *
 * @author zuley
 */
public class Programa04_DA { //DAO  PATRON DE ACCESO A DATOS

    public static void main(String[] args) {

        DAOEmpleado dAOEmpleado = new DAOEmpleado();
        Empleado emp = new Empleado();
        emp.setClave(12);
        emp.setNombre("JJ");
        emp.setDireccion("av1");
        emp.setTelefono("12345");

        dAOEmpleado.create(emp);

    }
}
