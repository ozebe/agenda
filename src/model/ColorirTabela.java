/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import static view.AgendaView.compromissos;
import static view.AgendaView.tableCompromissos;

/**
 *
 * @author wesley.santos
 */
public class ColorirTabela extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        try {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            //203,216,227
            //Color c = new Color(203,216,227);
            int linha = tableCompromissos.getRowSorter().convertRowIndexToModel(row);
            
            //System.out.println("id -> "+compromissos.get(linha).getId() + " hora -> " + compromissos.get(linha).getHora());
            String horaBase = compromissos.get(row).getHora();
            String dataBase = compromissos.get(row).getData();
            String dataHoraBaseString = dataBase + " " + horaBase;
            
//            System.out.println("dataBase "+dataBase );
//            System.out.println("horaBase "+horaBase );

            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dataHoraBase = formato.parse(dataHoraBaseString);
            //System.out.println(""+dataHoraB);
            
            Color c = Color.WHITE;
            //Object hora = table.getValueAt(row, 0); //coluna 0 no model pega a data
             Object hora = compromissos.get(row).getHora();
                //dd/MM/yyyy HH:mm:ss
                
//            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//            Date horaNaBase = formatter.parse(hora.toString());

            String horaA = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dataHoraAtual = formatter.parse(horaA);
            
            SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");
            
            System.out.println("Data e hora atual -> " + dataHoraAtual + " - " +  "Data e hora na base -> " + dataHoraBase);
            //System.out.println("atual -> "+horaAtual);
//            long hA = horaAtual.getTime();
//            long hB = horaNaBase.getTime();
//            long diferencaHoras = hA - hB;
            
//            System.out.println(""+String.format( "%03d:%02d", diferencaHoras / 3600000, ( diferencaHoras / 60000 ) % 60 ));
//            if(){
//                System.out.println("atual -> "+( hA / 60000 ) % 60 );
//                System.out.println("base -> "+( hB / 60000 ) % 60 );
//                c = Color.RED;
//            } 
//            if (hora != null && "12:00:00".equals(hora.toString())) {
//                // RGB
//                c = Color.RED;
//                //c = new Color(126, 195, 255);
//            }
            setBackground(c);

            if (isSelected) {
                //setForeground(Color.BLUE);
                setBackground(table.getSelectionBackground());
            }

            return this;
        } catch (ParseException ex) {
            Logger.getLogger(ColorirTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

}
