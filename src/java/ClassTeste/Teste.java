/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassTeste;

import dao.AgendaDAO;
import java.util.ArrayList;
import modelos.Agenda;

/**
 *
 * @author oliveira
 */
public class Teste {
        public static void main(String[] args) {
        Agenda eo = new Agenda();
        AgendaDAO ed = new AgendaDAO();
        
        eo.setData_hora("2000-12-01 23:22:00");
        eo.setEstadoLuzQuarto("Azul");
        eo.setEstadoLuzSala("Green");
        eo.setEstadoTelevisor("Violeta");
        eo.setEstadoVentilador("Branco");
       ArrayList<Agenda> lista =  ed.getEstados();
            for (int i = 0; i < lista.size(); i++) {
               
               System.out.println(lista.get(i).getData_hora());
            }
    }
    
        
        
}
