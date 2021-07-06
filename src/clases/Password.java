/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 5/07/2021
 *
 */
public class Password {

   
    private int longitud;
    private String contrasegna;

    //Creamos un constructor por defecto
    public Password(String contrasegna) {
        this.longitud = contrasegna.length();
        this.contrasegna = contrasegna;
    }

    //Un constructor con la longitud que nosotros le pasemos. Generara una contraseña aleatoria con esa longitud.
    public Password(int longitud) {
        this.longitud = longitud;

        //Aqui ira el metodo que generara la contraseña
        this.contrasegna = this.generarPassword();
    }
    /*
     Los métodos que implementa serán:

     esFuerte(): devuelve un booleano si es fuerte o no, para que sea fuerte debe tener mas de 2 mayúsculas, mas de 1 minúscula y mas de 5 números.

     generarPassword():  genera la contraseña del objeto con la longitud que tenga.
     Método get para contraseña y longitud.
     Método set para longitud.

     */

    //Metodo para verificar si la contraseña es Fuerte
    public boolean esFuerte() {
        int numeros = 0;
        int mayusculas = 0;
        int minusculas = 0;
        for (int i = 0; i < this.contrasegna.length(); i++) {
            if (contrasegna.charAt(i) >= 97 && this.contrasegna.charAt(i) <= 122) { //Metodo para las minusculas
                minusculas++;
            } else if (contrasegna.charAt(i) >= 48 && this.contrasegna.charAt(i) <= 57) { //Condicion para verificar si existe dentro de la cadena Numeros
                numeros++;
            } else if (contrasegna.charAt(i) >= 65 && this.contrasegna.charAt(i) <= 90) { //Condicion para verificar si existen Letras mayuculas
                mayusculas++;
            }
        }
        return (mayusculas >= 2 && minusculas >= 1 && numeros >= 5);
    }

    //Metodo para generar una Contraseña Aleatoria
    private String generarPassword() {
        int valor = 0;
        String cadena = "";
        for (int i = 0; i < this.longitud; i++) {
            valor = ((int) Math.floor(Math.random() * 3 + 1));
            if (valor == 1) { //Mayusculas
                char may = (char) ((int) Math.floor(Math.random() * (91 - 65) + 65));
                cadena += may;
            } else if (valor == 2) { //Minusculas

                char minusculas = (char) ((int) Math.floor(Math.random() * (123 - 97) + 97));
                cadena += minusculas;
            } else { //Numeros
                char numeros = (char) ((int) Math.floor(Math.random() * (58 - 48) + 48));
                cadena += numeros;
            }
        }
        return cadena;
    }

    //Metodos Get y Set
    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContrasegna() {
        return contrasegna;
    }

    public void setContrasegna(String contrasegna) {
        this.contrasegna = contrasegna;
    }

    @Override
    public String toString() {
        return "Longitud: " + longitud + "\nContraseña: " + contrasegna;
    }

}
