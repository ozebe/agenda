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
            
            Date dateHoraBancoFormatada = formataHora.parse(compromissos.get(linha).getHora());
            String horaBancoFormatada = new SimpleDateFormat("HH:mm").format(dateHoraBancoFormatada);

            Date dateDataBancoFormatada = formataData.parse(compromissos.get(linha).getData());
            String dataBancoFormatada = new SimpleDateFormat("yyyy-MM-dd").format(dateDataBancoFormatada);

            String horaAtualFormatada = new SimpleDateFormat("HH:mm").format(new Date());
            Date dateHoraAtualFormatada = formataHora.parse(horaAtualFormatada);

            String dataAtualFormatada = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            Date dateDataAtualFormatada = formataData.parse(dataAtualFormatada);

            int d = dateDataAtualFormatada.compareTo(dateDataBancoFormatada);
            int h = dateHoraAtualFormatada.compareTo(dateHoraBancoFormatada);
            //dataAtual.comparteTo(dataBanco)
            //dataAtual igual a dataBanco = 0
            //dataAtual antes de dataBanco = <0
            //dataAtual depois de dataBanco = >0
            Color c = Color.WHITE;
            if (d < 0) {
                //verde
                c = new Color(121, 210, 121);
            } else if (d > 0) {
                //vermelho
                c = new Color(255, 77, 77);
            } else if (d == 0) {
                if (h < 0) {
                    //verde
                    c = new Color(121, 210, 121);
                } else if (h > 0) {
                    //vermelho
                    c = new Color(255, 77, 77);
                } else if (h == 0) {
                    //amarelo
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
