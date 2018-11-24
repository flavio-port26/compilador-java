/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico;

import java.util.Stack;
import pilha.Inverter;
import pilha.Token;

/**
 *
 * @author comp15
 */
public class AnalizadorSemantico {

    private int nivel;
    private String tipo;
    private String categoria;
    private int entrada;
    private String nome;

    public void analiza(Stack<Token> vpilha) {
        Inverter inv = new Inverter();
        Stack<Token> pilha;
        inv.inverte(vpilha);
        pilha = inv.pilha();
        TabelaSimbolos tabela = new TabelaSimbolos();
        nivel = 1;
        while (!pilha.isEmpty()) {

            entrada = pilha.peek().getCodigo();
            nome = pilha.pop().getNome();
            switch (entrada) {
                case 2:
                    categoria = "label";
                    tipo = "label";
                    entrada = pilha.pop().getCodigo();
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
                    tipo = "inteiro";
                    entrada = pilha.pop().getCodigo();
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
                    tipo = "inteiro";
                    entrada = pilha.pop().getCodigo();
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
                case 5:
                    categoria = "procedure";
                    tipo = "verificar";
                    nivel = 2;
                    entrada = pilha.pop().getCodigo();

                    while (!isParada(entrada)) {
                        entrada = pilha.peek().getCodigo();
                        if (entrada == 7) {
                            tabela.removeTabela();
                            nivel = 1;
                        }
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
                case 25:
                    int result = tabela.buscaTabela(nome);
                    if (result != 99) {
                        if (pilha.peek().getCodigo() == 36 || pilha.peek().getCodigo() == 38) {
                            Variaveis var = new Variaveis();
                            var = tabela.buscaCategoria(nome);
                            while(pilha.peek().getCodigo()!=47){
                            
                                pilha.pop();
                            }
                        }
                    }
                    break;
                default:
                    break;
            }

        }

    }

    public boolean isParada(int nome) {
        return nome == 2 || nome == 3 || nome == 4 || nome == 5 || nome == 6;

    }

}
