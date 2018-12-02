/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico;



import java.util.Stack;
import pilha.Token;

/**
 *
 * @author User
 */
public class Deriva {

    public Stack<Token> analiza(Stack<Token> pilha,String categoria,int tipo,TabelaSimbolos tabela, int nivel)throws Exception{
        
        int entrada= pilha.peek().getCodigo();
         while (entrada != 47) {
                        entrada = pilha.peek().getCodigo();

                        if (entrada == 25) {
                            int result = tabela.buscaTabela(pilha.peek().getNome());
                            if (result == nivel) {
                                throw new Exception("Erro na Linha " + pilha.peek().getLinha()
                                        + "\n a Variavel: "
                                        + pilha.peek().getNome() + " \nja existe na Tabela");
                            } else {
                                tabela.adicionaTabela(nivel, categoria, tipo, pilha.peek().getNome().toLowerCase().trim());
                                break;
                            }
    }
                        pilha.pop();
}
         return pilha;
    }
  
}