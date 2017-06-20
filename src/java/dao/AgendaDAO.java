package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import conect.Conect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Agenda;

/**
 *
 * @author oliveira
 */
public class AgendaDAO extends Conect {

    public void programarTime(Agenda estado) {
        Conect1();
        String sql
                = "insert into smarthome value(default,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            System.out.println(estado.getData_hora());
            ps = getCon().prepareStatement(sql);
            ps.setString(1, estado.getData_hora());
            ps.setString(2, estado.getEstadoLuzQuarto());
            ps.setString(3, estado.getEstadoLuzSala());
            ps.setString(4, estado.getEstadoVentilador());
            ps.setString(5, estado.getEstadoTelevisor());
            ps.setString(6, "Ativo");
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        fechar();

    }

    public Agenda getTime(String times) {
        Conect1();
        SimpleDateFormat dataHora = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        String sql
                = "select * from smarthome where dia_hora like ?";
        //= "select * from smarthome where data >= ? and hora >= ?";
        PreparedStatement ps;
        Agenda agenda = new Agenda();
        try {
            ps = getCon().prepareStatement(sql);
            ps.setString(1, times + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                agenda.setId(rs.getInt("id"));
                String valor = rs.getString("dia_hora").substring(0, rs.getString("dia_hora").length() - 2);
                String datahora = dataHora.format(new Date(valor.replace("-", "/")));
                agenda.setData_hora(datahora);
                agenda.setEstadoLuzQuarto(rs.getString("quarto"));
                agenda.setEstadoLuzSala(rs.getString("sala"));
                agenda.setEstadoTelevisor(rs.getString("tv"));
                agenda.setEstadoVentilador(rs.getString("ventilador"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        fechar();
        return agenda;
    }

    public ArrayList<Agenda> getEstados() {
        verificaEstado();
        Conect1();
        SimpleDateFormat dataHora = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String sql
                = "select * from smarthome  where estado like ? order by dia_hora asc";
        //= "select * from smarthome where data >= ? and hora >= ?";
        PreparedStatement ps;
        ArrayList<Agenda> listaTime = new ArrayList<>();
        try {
            ps = getCon().prepareStatement(sql);
            ps.setString(1, "Ativo");
            ResultSet rs = ps.executeQuery();
            Agenda estado = new Agenda();
            while (rs.next()) {
                estado = new Agenda();
                estado.setId(rs.getInt("id"));
                String valor = rs.getString("dia_hora").substring(0, rs.getString("dia_hora").length() - 2);
                String datahora = dataHora.format(new Date(valor.replace("-", "/")));
                estado.setData_hora(datahora);
                estado.setEstadoLuzQuarto(rs.getString("quarto"));
                estado.setEstadoLuzSala(rs.getString("sala"));
                estado.setEstadoTelevisor(rs.getString("tv"));
                estado.setEstadoVentilador(rs.getString("ventilador"));
                estado.setEstado(rs.getString("estado"));
                listaTime.add(estado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        fechar();
        return listaTime;
    }

    public void verificaEstado() {
        Conect1();
        SimpleDateFormat dataHora = new SimpleDateFormat("YYYY-MM-dd HH:mm");
        String datahora = dataHora.format(new Date());
        String sql
                = "update smarthome set estado=? where dia_hora<=?";
        PreparedStatement ps;
        try {
            ps = getCon().prepareStatement(sql);
            ps.setString(1, "Inativo");
            ps.setString(2, datahora);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        fechar();

    }

    public void alterarTime(Agenda estado) {
        Conect1();
        String sql
                = "update smarthome set dia_hora=?, quarto=?, sala=?, ventilador=?, tv=? where id=?";
        PreparedStatement ps;
        try {
            ps = getCon().prepareStatement(sql);
            ps.setString(1, estado.getData_hora());
            ps.setString(2, estado.getEstadoLuzQuarto());
            ps.setString(3, estado.getEstadoLuzSala());
            ps.setString(4, estado.getEstadoVentilador());
            ps.setString(5, estado.getEstadoTelevisor());
            ps.setInt(6, estado.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        fechar();

    }

    public void apagarTime(int id) {
        Conect1();
        String sql
                = "delete from smarthome where id=?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AgendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        fechar();

    }
}
