/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintatico;


import pilha.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.table.AbstractTableModel;

public class tabelaSintatica {


public class tabelaLexica extends AbstractTableModel {
    private final Stack<Token> bufferTokens;
    private final List<String> titulo;
    
    public tabelaLexica(Stack<Token> bufferTokens) {
        this.bufferTokens = bufferTokens;
        titulo = new ArrayList<>();
        titulo.add("id");
        titulo.add("palavra");
        titulo.add("linha");
    }

    @Override
    public int getRowCount() {
        return bufferTokens.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int num) {
        return this.titulo.get(num);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        if(coluna == 0){
            return bufferTokens.get(linha).getCodigo();
        } else if(coluna == 1) {
            return bufferTokens.get(linha).getNome();
        }
        else {
            return  bufferTokens.get(linha).getLinha();
        }
    }
}
}
