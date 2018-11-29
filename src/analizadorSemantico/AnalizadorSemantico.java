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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    private int nivel;
    private int tipo;
    private String categoria;
    private int entrada;
    private String nome;

    public boolean getIsProcedure() {
        return isProcedure;
    }

    public void setIsProcedure(boolean isProcedure) {
        this.isProcedure = isProcedure;
    }
    private boolean isProcedure;

    public void analiza(Stack<Token> vpilha) {
        Inverter inv = new Inverter();
        Stack<Token> pilha;
        inv.inverte(vpilha);
        pilha = inv.pilha();
        TabelaSimbolos tabela = new TabelaSimbolos();
        setNivel(1);

        while (!pilha.isEmpty()) { // enquanto pilha nao for vazia

            int entrada = pilha.peek().getCodigo(); // codigo do token
            String nome = pilha.peek().getNome(); // nome do token
            switch (entrada) {
                case 1:  // se for program ele roda ate o ; para excluir a variavel do nome do programa              
                    entrada = pilha.pop().getCodigo(); // proximo token
                    while (entrada != 47) {
                        entrada= pilha.peek().getCodigo();
                        pilha.pop();
                    }
                    break;

                case 2:// ele add categoria como rotulo 
                    categoria = "rotulo";
                    tipo = 2; //tipo 2 = Label
                    entrada = pilha.pop().getCodigo(); // codigo do token
                    nome = pilha.peek().getNome();  // nome do token
                    String dentroDoWhile;
                    while (!isParada(entrada)) { //ponto de parada
                        entrada = pilha.peek().getCodigo();
                        dentroDoWhile = pilha.peek().getNome();
                        if (entrada == 25) {
                            int result = tabela.buscaTabela(pilha.peek().getNome());
                            if (result == getNivel()) {// starta erro
                                System.out.println("Erro no label variavel ja existe na Tabela");
                            } else { //  adiciona na tabela
                                tabela.adicionaTabela(getNivel(), categoria, tipo, pilha.peek().getNome());
                                pilha.pop();
                            }
                        }
                        pilha.pop();
                    }
                    break;
                case 3:
                    categoria = "const";
                    tipo = 8;// Tipo = Integer
                    entrada = pilha.pop().getCodigo();//codigo do token
                    nome = pilha.peek().getNome();// nome do token

                    while (!isParada(entrada)) { // ponto de parada
                        entrada = pilha.peek().getCodigo(); // codigo token
                        dentroDoWhile = pilha.peek().getNome();
                        if (entrada == 25) {
                            int result = tabela.buscaTabela(pilha.peek().getNome());
                            if (result == getNivel()) {
                                System.out.println("Erro no Const variavel ja existe");
                            } else {
                                tabela.adicionaTabela(getNivel(), categoria, tipo, pilha.peek().getNome());
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
                        dentroDoWhile = pilha.peek().getNome();
                        if (entrada == 25) {
                            int result = tabela.buscaTabela(pilha.peek().getNome());
                            if (result == getNivel()) {
                                System.out.println("Erro no Var variavel ja existe");
                            } else {
                                tabela.adicionaTabela(getNivel(), categoria, tipo, pilha.peek().getNome());
                                pilha.pop();
                            }
                        }
                        pilha.pop();
                    }
                    break;
                case 5: // é procedure
                    setIsProcedure(true);
                    setNivel(2);// seta o nivel
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
                case 7:
                    if (getIsProcedure()) {
                        setNivel(1);
                        tabela.removeNivel2();
                        setIsProcedure(false);
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
        /*              Label       Const          Var        Procedure      Begin
        
        
         */
    }

}
