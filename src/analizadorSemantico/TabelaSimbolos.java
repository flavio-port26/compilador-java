/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TabelaSimbolos {
   private final ArrayList<Variaveis> tabela = new ArrayList<>();
    
    public void adicionaTabela(int nivel,String categoria,String tipo,String nome){
           Variaveis var = new Variaveis();
           var.setNivel(nivel);
           var.setCategoria(categoria);
           var.setTipo(tipo);
           var.setNome(nome);
           tabela.add(var);
    }
    public void removeTabela(String nome){
         for(int i=0;i<tabela.size();i++){
            if(tabela.get(i).getNome().equals(nome)){
               tabela.remove(i);
                
            }
        }
    }
    public int buscaTabela(String nome){
        for(int i=0;i<tabela.size();i++){
            if(tabela.get(i).getNome().equals(nome)){
                return tabela.get(i).getNivel();
                
            }
        }
        return 99;
    }
    public ArrayList pegaTabela(){
        return tabela;
    }
}
