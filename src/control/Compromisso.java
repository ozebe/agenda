package control;

public class Compromisso {

    private int id;
    private int idUsuario;
    private String data;
    private String hora;
    private String descricao;
    private String criado;
    private String editado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCriado() {
        return criado;
    }

    public void setCriado(String criado) {
        this.criado = criado;
    }

    public String getEditado() {
        return editado;
    }

    public void setEditado(String editado) {
        this.editado = editado;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    
}
