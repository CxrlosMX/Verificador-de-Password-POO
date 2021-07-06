/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorPassword;

import clases.Password;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 6/07/2021
 *
 */
public class Gestor {

    //Creamos un arrayList de tipo Password para poder almacenar las contraseñas
    private ArrayList<Password> arreglo;
    private int contador;

    public Gestor() {
        arreglo = new ArrayList<Password>();
        contador = -1;
    }

    //Metodo para rellenar los valores
    public Password rellenar(int i) {
        Password p = null;
        if (i == 1) {
            String c = JOptionPane.showInputDialog(null, "Introduce la contraseña", "Introduciendo contraseña", 1);
            p = new Password(c);
            if (p.esFuerte()) {
                JOptionPane.showMessageDialog(null, "La contraseña es Fuerte:\n " + p, "Contraseña Agregada Fuerte", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña Debil: \n" + p, "Contraseña Introducida Debil", 2);
            }
        } else {
            boolean bandera = false;
            do {
                int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la longitud de la contraseña a generar", "Introduciendo longitud", 1));
                if (n > 0 && n != 0) {
                    bandera=true;
                    p = new Password(n);
                    if (p.esFuerte()) {
                        JOptionPane.showMessageDialog(null, "La contraseña es Fuerte:\n" + p, "Contraseña Agregada Fuerte", 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña Debil:\n " + p, "Contraseña Introducida Debil", 2);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Introduce un valor valido", "Error de valor introducido", 2);
                }
            } while (!bandera);
        }
        return p;
    }

    //Metodo para agregar una Contraseña
    public void addPassword(Password p) {
        arreglo.add(p);
        JOptionPane.showMessageDialog(null, "Contraseña Agregada Correctamente", "Agregada", 1);
        contador++;
    }

    //Metodo para mostrar todas las contraseñas
    public void mostrar() {
        String cadena = "";
        for (Password a : arreglo) {
            cadena = cadena + "\n" + a + "->" + ((a.esFuerte() ? "Contraseña Fuerte" : "Contraseña Debil"));
        }
        JOptionPane.showMessageDialog(null, cadena, "Mostrando Contraseñas", 1);
    }

    //Metodo para verificar si esta vacia nuestro ArrayList
    public boolean noEstaVacia() {
        return (contador != -1);
    }
}
