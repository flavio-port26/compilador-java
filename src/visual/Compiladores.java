
package visual;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Compiladores {

    public static void main(String[] args) {
        JFramePrincipal frameP = new JFramePrincipal();
        
        frameP.setLocationRelativeTo(null);
        frameP.setVisible(true);
    }
    
    public String Salvar(File selFile, String text) {
        String salvo = "0";
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(selFile+".txt", false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.flush();
            //JOptionPane.showMessageDialog(this, "Salvo com sucesso");
            salvo = "1";
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException ex) {
                    //JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: "
                    //+ ex.getMessage());
                    ex.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    //JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo: "
                    //+ ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
        return salvo;
    }

    public String lerArquivo(File selFile) {
        FileInputStream fis = null;
        String texto = "";

        try {
            fis = new FileInputStream(selFile);
            int content;
            while ((content = fis.read()) != -1) {
                texto += (char) content;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return texto;
    }
    
}
