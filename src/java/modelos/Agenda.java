/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oliveira
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Agenda {

    private int id;
    private String data_hora;
    private String estadoLuzSala;
    private String estadoLuzQuarto;
    private String estadoVentilador;
    private String estadoTelevisor;
    private String estado;

    public Agenda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public String getEstadoLuzSala() {
        return estadoLuzSala;
    }

    public void setEstadoLuzSala(String estadoLuzSala) {
        this.estadoLuzSala = estadoLuzSala;
    }

    public String getEstadoLuzQuarto() {
        return estadoLuzQuarto;
    }

    public void setEstadoLuzQuarto(String estadoLuzQuarto) {
        this.estadoLuzQuarto = estadoLuzQuarto;
    }

    public String getEstadoVentilador() {
        return estadoVentilador;
    }

    public void setEstadoVentilador(String estadoVentilador) {
        this.estadoVentilador = estadoVentilador;
    }

    public String getEstadoTelevisor() {
        return estadoTelevisor;
    }

    public void setEstadoTelevisor(String estadoTelevisor) {
        this.estadoTelevisor = estadoTelevisor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
