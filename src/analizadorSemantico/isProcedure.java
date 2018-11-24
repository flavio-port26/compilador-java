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
public class isProcedure {

    int nivel = 2;
    String categoria;
    int tipo;

    public Stack<Token> analiza(Stack<Token> pilha, TabelaSimbolos tabela) {
        categoria = "procedure";
        String nome = pilha.peek().getNome();
        int entrada = pilha.peek().getCodigo();
        pilha.pop();
        entrada = pilha.peek().getCodigo();
        while (entrada != 47) {
            String nomeProcedure = pilha.peek().getNome();
            entrada = pilha.peek().getCodigo();
            nome = pilha.peek().getNome();
           
                if (entrada == 25) {
                    int result = tabela.buscaTabela(pilha.peek().getNome());
                    if (result == nivel) {
                        System.out.println("nome da procedure ja existe na lista");
                    } else {
                        String nomerocedure=nome;

                        String nomevariavel = "";
                        while (entrada != 37) {
                                    entrada = pilha.peek().getCodigo();
                                    nome = pilha.peek().getNome();
                                    if (entrada == 25) {
                                        result = tabela.buscaTabela(pilha.peek().getNome());
                                        if (result == nivel) {
                                            System.out.println("variavel ja existe na tabela");
                                            break;
                                        } else {
                                            nomevariavel = pilha.peek().getNome();
                                        }
                                    }
                                    if (entrada == 2 || entrada == 5 || entrada == 8) {
                                        tipo = entrada;
                                        tabela.adicionaTabela(nivel, categoria, tipo, nomerocedure);
                                        tabela.adicionaTabela(nivel, categoria, tipo, nomevariavel);
                                    }
                                 pilha.pop();
                                }
                    }
                }
                pilha.pop();
        }
        entrada= pilha.peek().getCodigo();
                nome= pilha.peek().getNome();
        while(entrada!=7){
            
            switch(entrada){
             case 2:
                    categoria = "label";
                    tipo = 2;
                    entrada = pilha.pop().getCodigo();
                    nome = pilha.peek().getNome();
                    while (!isParada(entrada)) {
                        entrada = pilha.peek().getCodigo();
                        if (entrada == 25) {
                            int result = tabela.buscaTabela(pilha.peek().getNome());
                            if (result == nivel) {
                                //erro
                            } else {
                                tabela.adicionaTabela(nivel, categoria, tipo, pilha.peek().getNome());
                                pilha.pop();
                            }
                        }
                        pilha.pop();
                    }
                    break;
                case 3:
                    categoria = "const";
                    tipo = 8;
                    entrada = pilha.pop().getCodigo();
                    nome = pilha.peek().getNome();
                    while (!isParada(entrada)) {
                        entrada = pilha.peek().getCodigo();
                        if (entrada == 25) {
                            int result = tabela.buscaTabela(pilha.peek().getNome());
                            if (result == nivel) {
                                //erro
                            } else {
                                tabela.adicionaTabela(nivel, categoria, tipo, pilha.peek().getNome());
                                pilha.pop();
                            }
                        }
                        pilha.pop();
                    }
                    break;
                case 4:
                    categoria = "var";
                    tipo = 8;
                    entrada = pilha.pop().getCodigo();
                    nome = pilha.peek().getNome();
                    while (!isParada(entrada)) {
                        entrada = pilha.peek().getCodigo();
                        if (entrada == 25) {
                            int result = tabela.buscaTabela(pilha.peek().getNome());
                            if (result == nivel) {
                                //erro
                            } else {
                                tabela.adicionaTabela(nivel, categoria, tipo, pilha.peek().getNome());
                                pilha.pop();
                            }
                        }
                        pilha.pop();
                    }
                    break;
                    default: 
                        pilha.pop();
                        break;
            }
            
            
      
        }
        return pilha;
    }
                         
    public boolean isParada(int nome) {
        return nome == 2 || nome == 3 || nome == 4 || nome == 5 || nome == 6;

    }
        }
 