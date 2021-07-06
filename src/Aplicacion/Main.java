/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import GestorPassword.Gestor;
import clases.Password;
import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 5/07/2021
 *
 */
public class Main {

    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Password p;
        int op = 0, op2 = 0;

        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU"
                        + "\n1.-Registrar Contraseña"
                        + "\n2.-Generar Contraseña"
                        + "\n3.-Mostrar Contraseñas"
                        + "\n4.-Salir"
                        + "\n¿Que desea realizar?", "MENU", 3));
                switch (op) {
                    case 1: {
                        p = gestor.rellenar(1);
                        gestor.addPassword(p);
                        break;
                    }
                    case 2: {
                        boolean bandera = false;
                        p = gestor.rellenar(2);
                        do {
                            op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Contraseña Generada:\n" + p.getContrasegna()
                                    + "\n¿Desea Agregarla?\n"
                                    + "1.-SI "
                                    + "2.-NO", "Verificando", 3));
                            switch (op2) {
                                case 1: {
                                    gestor.addPassword(p);
                                    bandera = true;
                                    break;
                                }
                                case 2: {
                                    JOptionPane.showMessageDialog(null, "Contraseña NO guardada", "No guardada", 0);
                                    bandera = true;
                                    break;
                                }
                                default: {
                                    JOptionPane.showMessageDialog(null, "Introduce valores correctos", "Error de Opcion", 0);
                                    break;
                                }
                            }
                        } while (!bandera);
                        break;
                    }
                    case 3: {
                        if (gestor.noEstaVacia()) {
                            gestor.mostrar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Lista Vacia", "Error Lista Vacia", 0);
                        }
                        break;
                    }
                    case 4: {
                        JOptionPane.showMessageDialog(null, "Saliendo ", "Cerrando Programa", 2);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introduce valores correctos", "Error de Opcion", 0);
                        break;
                    }

                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", 0);
            }

        } while (op != 4);

        /*  Password c=new Password("12345ABa");
        
        
         System.out.println(c);
         System.out.println("");
         if(c.esFuerte()){
         System.out.println("Contraseña Fuerte");
         }
         else {
         System.out.println("No es fuerte");
         }
         */
    }
}
