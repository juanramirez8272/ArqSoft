package Controlador;

import Vista.Interfaz;
import Vista.vConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInterfaz implements ActionListener{
    private Interfaz formInt;
    private vConsulta formest;

    public ControladorInterfaz(Interfaz formInt, vConsulta formest) {
        this.formInt = formInt;
        this.formest = formest;
        this.formInt.menConsulta.addActionListener(this);
        this.formInt.menSalir.addActionListener(this);
        
    }
public void iniciar(){
    formest.setTitle("Base estudiantes");
    formInt.setTitle("Inicio");
    formInt.setLocationRelativeTo(null);
    formest.setLocationRelativeTo(null);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==formInt.menConsulta){
        formest.setVisible(true);
        formInt.dispose();
        }
        
           if(e.getSource()==formInt.menSalir){
        System.exit(0);
        }
    }
    
}
