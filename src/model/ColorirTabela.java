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
            //formatadores
            SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm");
            SimpleDateFormat formataData = new SimpleDateFormat("yyyy-MM-dd");

            //pega a linha correta, utilizando o rowSorter
            int linha = tableCompromissos.getRowSorter().convertRowIndexToModel(row);

            //data de inicio no banco------
            Date dateHoraInicioBancoFormatada = formataHora.parse(compromissos.get(linha).getHora_inicio());
            //String horaInicioBancoFormatada = new SimpleDateFormat("HH:mm").format(dateHoraInicioBancoFormatada);
            //-----------------------------
            
            //data final no banco----------
            Date dateHoraFinalBancoFormatada = formataHora.parse(compromissos.get(linha).getHora_final());
            //String horaFinalBancoFormatada = new SimpleDateFormat("HH:mm").format(dateHoraFinalBancoFormatada);
            //-----------------------------

            Date dateDataBancoFormatada = formataData.parse(compromissos.get(linha).getData());
            String dataBancoFormatada = new SimpleDateFormat("yyyy-MM-dd").format(dateDataBancoFormatada);

            //data e hora atual------------
            String horaAtualFormatada = new SimpleDateFormat("HH:mm").format(new Date());
            Date dateHoraAtualFormatada = formataHora.parse(horaAtualFormatada);

            String dataAtualFormatada = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            Date dateDataAtualFormatada = formataData.parse(dataAtualFormatada);
            //-----------------------------

            int d = dateDataAtualFormatada.compareTo(dateDataBancoFormatada);
            int hi = dateHoraAtualFormatada.compareTo(dateHoraInicioBancoFormatada);
            int hf = dateHoraAtualFormatada.compareTo(dateHoraFinalBancoFormatada);
            //dataAtual.comparteTo(dataBanco)
            //dataAtual igual a dataBanco = 0
            //dataAtual antes de dataBanco = <0
            //dataAtual depois de dataBanco = >0

//            Date min, max;   // assume these are set to something
//            Date d;          // the date in question
//
//            return d.after(min) && d.before(max);
            Color c = Color.WHITE;
            if (d < 0) {
                //verde
                c = new Color(121, 210, 121);
            } else if (d > 0) {
                //vermelho
                c = new Color(255, 77, 77);
            } else if (d == 0) {
                if ((hi < 0) && (hf < 0)) {
                    //verde, caso esteja antes do horario de inicio e fim
                    c = new Color(121, 210, 121);
                } else if ((hi > 0 ) && (hf > 0)) {
                    //vermelho, caso esteja depois do horario de inicio e fim
                    c = new Color(255, 77, 77);
                } else if (((hi == 0) || (hi > 0)) && ((hf == 0) || (hf < 0))) {
                    //amarelo, caso esteja entre o horario de inicio e fim
                    c = new Color(255, 210, 77);
                }
            }

            setBackground(c);

            if (isSelected) {
                setBackground(table.getSelectionBackground());
            }
            return this;
        } catch (ParseException ex) {
            Logger.getLogger(ColorirTabela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }
}
