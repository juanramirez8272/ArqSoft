/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Consultaestudiante;
import Modelo.Estudiante;
import Vista.vConsulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorEst implements ActionListener {

    private Estudiante estu;
    private vConsulta formestu;
    private Consultaestudiante estC;

    public ControladorEst(Estudiante estu, vConsulta formestu, Consultaestudiante estC) {
        this.estu = estu;
        this.formestu = formestu;
        this.estC = estC;
        this.formestu.btn_agregar.addActionListener(this);
        this.formestu.btn_buscar.addActionListener(this);
        this.formestu.btn_eliminar.addActionListener(this);
        this.formestu.btn_limpiar.addActionListener(this);
        this.formestu.btn_actualizar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //agregar
      if(e.getSource()==formestu.btn_agregar){
          estu.setId(Integer.parseInt(formestu.txt_id.getText()));
          estu.setTelefono(Integer.parseInt(formestu.txt_telefono.getText()));
          estu.setNombre(formestu.txt_nombre.getText());
          estu.setApellido(formestu.txt_apellido.getText());
          estu.setGenero(formestu.txt_genero.getText());
          estu.setCiudad(formestu.txt_ciudad.getText());
          if (estC.registrar(estu)){
              JOptionPane.showMessageDialog(null, "Estudiante agregado");
              limpiar();
          }else{
              JOptionPane.showMessageDialog(null, "Error al agregar");
              limpiar();
          }
      }
          //actualizar
      if(e.getSource()==formestu.btn_actualizar){
          estu.setId(Integer.parseInt(formestu.txt_id.getText()));
          estu.setTelefono(Integer.parseInt(formestu.txt_telefono.getText()));
          estu.setNombre(formestu.txt_nombre.getText());
          estu.setApellido(formestu.txt_apellido.getText());
          estu.setGenero(formestu.txt_genero.getText());
          estu.setCiudad(formestu.txt_ciudad.getText());
          if (estC.modificar(estu)){
              JOptionPane.showMessageDialog(null, "Estudiante actualizado");
              limpiar();
          }else{
              JOptionPane.showMessageDialog(null, "Error al actualizar");
              limpiar();
          }
      }
                //eliminar
      if(e.getSource()==formestu.btn_eliminar){
          estu.setId(Integer.parseInt(formestu.txt_id.getText()));
          if (estC.eliminar(estu)){
              JOptionPane.showMessageDialog(null, "Estudiante eliminado");
              limpiar();
          }else{
              JOptionPane.showMessageDialog(null, "Error al eliminar");
              limpiar();
          }
      }
                      //buscar
      if(e.getSource()==formestu.btn_buscar){
          estu.setId(Integer.parseInt(formestu.txt_id.getText()));
          if (estC.buscar(estu)){
        formestu.txt_id.setText(String.valueOf(estu.getId()));
        formestu.txt_nombre.setText(estu.getNombre());
        formestu.txt_apellido.setText(estu.getApellido());
        formestu.txt_telefono.setText(String.valueOf(estu.getTelefono()));
        formestu.txt_genero.setText(estu.getGenero());
        formestu.txt_ciudad.setText(estu.getCiudad());
          }else{
              JOptionPane.showMessageDialog(null, "No se encontraron registros");
              limpiar();
          }
      }
      //limpiar
       if(e.getSource()==formestu.btn_limpiar){
         limpiar();
    }
    }

    
    public void limpiar(){
        formestu.txt_id.setText(null);
        formestu.txt_nombre.setText(null);
        formestu.txt_apellido.setText(null);
        formestu.txt_telefono.setText(null);
        formestu.txt_genero.setText(null);
        formestu.txt_ciudad.setText(null);
    }
    
}
