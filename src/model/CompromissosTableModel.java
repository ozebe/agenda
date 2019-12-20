package model;

import control.Compromisso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CompromissosTableModel extends AbstractTableModel {

    private List<Compromisso> compromissos;
    private String[] colunas = new String[]{"Início", "Final", "Descrição", "Criação", "Edição"};

    /**
     * Creates a new instance of DevmediaTableModel
     *
     * @param compromissos
     */
    public CompromissosTableModel(List<Compromisso> compromissos) {
        this.compromissos = compromissos;
    }

    public CompromissosTableModel() {
        this.compromissos = new ArrayList<Compromisso>();
    }

    @Override
    public int getRowCount() {
        return compromissos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    //"Início", "Final", "Descrição", "Criação", "Edição"
    public void setValueAt(Compromisso aValue, int rowIndex) {
        Compromisso compromisso = compromissos.get(rowIndex);

        compromisso.setHora_inicio(aValue.getHora_inicio());
        compromisso.setHora_final(aValue.getHora_final());
        compromisso.setDescricao(aValue.getDescricao());
        compromisso.setCriado(aValue.getCriado());
        compromisso.setEditado(aValue.getEditado());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Compromisso compromisso = compromissos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                compromisso.setHora_inicio(aValue.toString());
            case 1:
                compromisso.setHora_final(aValue.toString());
            case 2:
                compromisso.setDescricao(aValue.toString());
            case 3:
                compromisso.setCriado(aValue.toString());
            case 4:
                compromisso.setEditado(aValue.toString());
            default:
                System.err.println("Índice da coluna inválido");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Compromisso compromissoSelecionado = compromissos.get(rowIndex);
        String valueObject = null;
        switch (columnIndex) {
            case 0:
                valueObject = compromissoSelecionado.getHora_inicio();
                break;
            case 1:
                valueObject = compromissoSelecionado.getHora_final();
                break;
            case 2:
                valueObject = compromissoSelecionado.getDescricao();
                break;
            case 3:
                valueObject = compromissoSelecionado.getCriado();
                break;
            case 4:
                valueObject = compromissoSelecionado.getEditado();
                break;
            default:
                System.err.println("Índice inválido para propriedade do bean Usuario.class");
        }

        return valueObject;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Compromisso getCompromisso(int indiceLinha) {
        return compromissos.get(indiceLinha);
    }

    public void addCompromisso(Compromisso u) {
        compromissos.add(u);

        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeCompromisso(int indiceLinha) {
        compromissos.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    public void addListaDeCompromissos(List<Compromisso> novosCompromissos) {

        int tamanhoAntigo = getRowCount();
        compromissos.addAll(novosCompromissos);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    public void limpar() {
        compromissos.clear();
        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return compromissos.isEmpty();
    }

}
