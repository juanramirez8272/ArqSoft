/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Consultaestudiante extends Conexion {

    //REGISTRAR
    public boolean registrar(Estudiante est) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT into estudiante (id, nombre, apellido, telefono, genero, ciudad) values (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, est.getId());
            ps.setString(2, est.getNombre());
            ps.setString(3, est.getApellido());
            ps.setInt(4, est.getTelefono());
            ps.setString(5, est.getGenero());
            ps.setString(6, est.getCiudad());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    //MODIFICAR
    public boolean modificar(Estudiante est) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "update estudiante set id=?, nombre=?, apellido=?, telefono=?, genero=?, ciudad=? where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, est.getId());
            ps.setString(2, est.getNombre());
            ps.setString(3, est.getApellido());
            ps.setInt(4, est.getTelefono());
            ps.setString(5, est.getGenero());
            ps.setString(6, est.getCiudad());
            ps.setInt(7, est.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    //ELIMINAR
    public boolean eliminar(Estudiante est) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "delete from estudiante where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, est.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    //BUSCAR
    public boolean buscar(Estudiante est) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "select * from estudiante where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, est.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                est.setId(Integer.parseInt(rs.getString("id")));
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setTelefono(Integer.parseInt(rs.getString("telefono")));
                est.setGenero(rs.getString("genero"));
                est.setCiudad(rs.getString("ciudad"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
}
