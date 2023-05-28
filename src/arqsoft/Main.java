/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arqsoft;

import Controlador.ControladorEst;
import Controlador.ControladorInterfaz;
import Modelo.Conexion;
import Modelo.Consultaestudiante;
import Modelo.Estudiante;
import Vista.Interfaz;
import Vista.vConsulta;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estudiante est = new Estudiante();
        Consultaestudiante estC = new Consultaestudiante();
        vConsulta formest = new vConsulta();
        ControladorEst controlest = new ControladorEst(est, formest, estC);
        Interfaz formInt = new Interfaz();
        ControladorInterfaz controlint = new   ControladorInterfaz(formInt,formest);
        controlint.iniciar();
        formInt.setVisible(true);
    }
    
}
