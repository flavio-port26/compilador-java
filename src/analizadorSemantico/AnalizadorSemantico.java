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
    private int tipo;
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

            int entrada = pilha.peek().getCodigo();
            String nome = pilha.peek().getNome();
            switch (entrada) {
                case 1:
                    categoria = "program";
                    tipo = 1;
                    entrada = pilha.pop().getCodigo();
                    while (entrada != 47) {
                        entrada = pilha.peek().getCodigo();
                        nome = pilha.peek().getNome();
                        if (entrada == 25) {
                            int result = tabela.buscaTabela(pilha.peek().getNome());
                            if (result == nivel) {
                                System.out.println("variavel ja existe na tabela");

                                //erro
                            } else {
                                tabela.adicionaTabela(nivel, categoria, tipo, pilha.peek().getNome());

                            }

                        }
                        pilha.pop();
                    }
                    break;

                case 2:
                    categoria = "rotulo";
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
                case 5:
                    isProcedure procedure = new isProcedure();
                      pilha=procedure.analiza(pilha,tabela);
                    break;

                case 25:
                    int result = tabela.buscaTabela(nome);
                    if (result != 99) {
                        if (pilha.peek().getCodigo() == 36 || pilha.peek().getCodigo() == 38) {
                            Variaveis var = new Variaveis();
                            var = tabela.buscaCategoria(nome);
                            while (pilha.peek().getCodigo() != 47) {

                                pilha.pop();
                            }
                        }
                    }
                    break;
                default:
                    pilha.pop();
                    break;
            }

        }

    }

    public boolean isParada(int nome) {
        return nome == 2 || nome == 3 || nome == 4 || nome == 5 || nome == 6;

    }

}
