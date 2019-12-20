package control;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.ini4j.Wini;

/**
 *
 * @author WesleySantos
 */
public class INI implements iniConf {

    private final String chave;
    private final String valor;
    private String dir;
    public INI(String chave, String valor) {
        this.chave = chave;
        this.valor = valor;
        carregar(this.chave, this.valor);
    }
    
    @Override
    public void carregar(String chave, String valor) {
        try {
            Wini ini = new Wini(new File("config.ini"));
            this.dir = ini.get(chave, valor);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar parâmetros de inicialização da base\n" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(INI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDir() {
        return dir;
    }
    
    
    
    

}
