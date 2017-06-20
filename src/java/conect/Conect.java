package conect;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ThIaGo
 */
public class Conect {

    String user;
    String senha;
    String bd;
    String tabela;
    private java.sql.Connection con;

    public Connection getCon() {
        return con;
    }

    public Conect(String user, String senha, String bd) {
        this.user = user;
        this.senha = senha;
        this.bd = bd;
    }

    public Conect() {
        this.user = "root";
        this.senha = "MohStyle_iz4";
        this.bd = "SmartHome";
    }

    public boolean Conect1() {

        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (InstantiationException | ClassNotFoundException ex) {
            return false;
        }
        try {
            con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/" + bd, user, senha);
            return true;
        } catch (SQLException e) {
            return false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "''ERRO NA CONEXÃO COM BANCO DE DADOS''");

            throw new java.lang.RuntimeException("Erro ao Conectar");

        }
    }

    public void fechar() {
        try {
            con.close();
        } catch (SQLException e) {
            throw new java.lang.RuntimeException("erro fechar");
        }

    }

}
