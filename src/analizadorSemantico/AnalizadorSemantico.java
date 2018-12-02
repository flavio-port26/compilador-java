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

    public boolean getIsProcedure() {
        return isProcedure;
    }

    public void setIsProcedure(boolean isProcedure) {
        this.isProcedure = isProcedure;
    }
    private boolean isProcedure;

    public String analiza(Stack<Token> vpilha) throws Exception {
        String nomeTeste = "";
        Inverter inv = new Inverter();
        Stack<Token> pilha;
        inv.inverte(vpilha);
        pilha = inv.pilha();
        TabelaSimbolos tabela = new TabelaSimbolos();
        setNivel(1);
        Deriva derivaPilha = new Deriva();

        while (!pilha.isEmpty()) { // enquanto pilha nao for vazia

            int entrada = pilha.peek().getCodigo(); // codigo do token

            switch (entrada) {
                case 1:  // se for program ele roda ate o ; para excluir a variavel do nome do programa              
                    entrada = pilha.pop().getCodigo(); // proximo token
                    while (entrada != 47) {
                        entrada = pilha.peek().getCodigo();
                        pilha.pop();
                    }
                    break;

                case 2:// ele add categoria como rotulo 
                    categoria = "rotulo";
                    tipo = 2; //tipo 2 = Label
                    pilha.pop();
                    nomeTeste = pilha.peek().getNome();
                    entrada = pilha.peek().getCodigo();
                    while (!isParada(entrada)) {
                        if (entrada == 25) {
                            pilha = derivaPilha.analiza(pilha, categoria, tipo, tabela, nivel);
                        }
                        pilha.pop();
                        entrada = pilha.peek().getCodigo();
                        nomeTeste = pilha.peek().getNome();
                    }

                    break;
                case 3:
                    categoria = "const";
                    tipo = 8;// Tipo = Integer
                    pilha.pop();
                    nomeTeste = pilha.peek().getNome();
                    entrada = pilha.peek().getCodigo();
                    while (!isParada(entrada)) {
                        if (entrada == 25) {
                            pilha = derivaPilha.analiza(pilha, categoria, tipo, tabela, nivel);
                        }
                        pilha.pop();
                        entrada = pilha.peek().getCodigo();
                        nomeTeste = pilha.peek().getNome();
                    }

                    break;
                case 4:
                    categoria = "var";
                    tipo = 8;
                    pilha.pop();
                    nomeTeste = pilha.peek().getNome();
                    entrada = pilha.peek().getCodigo();
                    while (!isParada(entrada)) {
                        if (entrada == 25) {
                            pilha = derivaPilha.analiza(pilha, categoria, tipo, tabela, nivel);
                        }
                        pilha.pop();
                        entrada = pilha.peek().getCodigo();
                        nomeTeste = pilha.peek().getNome();
                    }

                    break;
                case 5: // é procedure
                    setIsProcedure(true);
                    categoria = "procedure";  //procedure
                    tipo = 8;
                    entrada = pilha.pop().getCodigo();
                    nomeTeste = pilha.peek().getNome();
                    while (entrada != 47) {
                        entrada = pilha.peek().getCodigo();
                        nomeTeste = pilha.peek().getNome();
                        if (entrada == 25) {
                            int result = tabela.buscaTabela(pilha.peek().getNome().toLowerCase().trim());
                            if (result == getNivel()) {
                                throw new Exception("Erro na Linha " + pilha.peek().getLinha()
                                        + "\n a Variavel: "
                                        + pilha.peek().getNome() + " \nja existe na Tabela");

                            } else {
                                tabela.adicionaTabela(getNivel(), categoria, tipo, pilha.peek().getNome().toLowerCase().trim());
                                break;
                            }

                        }
                        pilha.pop();

                    }
                    while (entrada != 47) {
                        nomeTeste = pilha.peek().getNome();
                        entrada = pilha.peek().getCodigo();
                        pilha.pop();
                        nomeTeste = pilha.peek().getNome();
                    }
                    setNivel(2);// seta o nivel
                    break;
                case 7:
                    if (getIsProcedure()) {
                        setNivel(1);
                        tabela.removeNivel2();
                        setIsProcedure(false);

                    }
                    pilha.pop();

                    break;

                case 25:
                    String nomeVar = pilha.peek().getNome();
                    nomeTeste = pilha.peek().getNome();
                    Variaveis var = tabela.buscaCategoria(pilha.pop().getNome().toLowerCase().trim(), getNivel());
                    if (var.getNome() == null) {
                        throw new Exception("Erro na Linha " + pilha.peek().getLinha()
                                + " \n a Variavel: "
                                + nomeVar + "\n nao Foi declarada");

                    } else {
                        if (pilha.peek().getCodigo() == 38 || pilha.peek().getCodigo() == 36) {
                            int tipoaux = 0;
                            pilha.pop();
                            entrada = pilha.peek().getCodigo();
                            nomeTeste = pilha.peek().getNome();
                            while (entrada != 47) {
                                nomeTeste = pilha.peek().getNome();
                                entrada = pilha.peek().getCodigo();
                                nomeTeste = pilha.peek().getNome();
                                if (entrada == 26) {
                                    entrada = 8;
                                }
                                if (entrada == 25) {
                                    String teste = pilha.peek().getNome();
                                    nomeTeste = pilha.peek().getNome();
                                    tipoaux = tabela.buscaTipo(pilha.peek().getNome().toLowerCase().trim());

                                }
                                
                                
                                if (!isOperacao(entrada)) {
                                    if (entrada == var.getTipo()) {
                                        nomeTeste = pilha.peek().getNome();
                                        pilha.pop();
                                        nomeTeste = pilha.peek().getNome();
                                    } else if (var.getTipo() == tipoaux) {
                                        nomeTeste = pilha.peek().getNome();
                                        pilha.pop();
                                        nomeTeste = pilha.peek().getNome();
                                    } else {
                                        throw new Exception("Erro na Linha " + pilha.peek().getLinha()
                                                + " \n a Variavel: "
                                                + pilha.peek().getNome() + "\n não é valida");

                                    }
                                } else {
                                    nomeTeste = pilha.peek().getNome();
                                    pilha.pop();
                                    nomeTeste = pilha.peek().getNome();
                                }
                            }
                            entrada=pilha.peek().getCodigo();
                            if(entrada ==7){
                                if (getIsProcedure()) {
                                    setNivel(1);
                                    tabela.removeNivel2();
                                    setIsProcedure(false);

                                }
                                }
                            pilha.pop();
                        }
                    }

                    break;

                default:
                    pilha.pop();
                    break;
            }

        }
        return "ANALIZADOR SEMANTICO executado com sucesso";
    }

    public boolean isOperacao(int nome) {
        return nome >= 30 && nome <= 44 || nome == 47;
    }

    public boolean isParada(int nome) {
        return nome >= 1 && nome <= 7;
    }
}
