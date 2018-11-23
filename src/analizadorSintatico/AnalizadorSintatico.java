/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintatico;

import analizadorLexico.tabelaLexica;
import java.util.Stack;

import pilha.Token;
import pilha.Verificador;

import pilha.Inverter;

import javax.swing.JTable;

/**
 *
 * @author comp15
 */
public class AnalizadorSintatico {

    private Stack<Token> entrada;
    private final Stack<Token> pilhaprod = new Stack();
    private Token producao = new Token();
    private final Verificador id = new Verificador();
    private String erro = "";
    private int entradacod;
    private int prodcod;

    public AnalizadorSintatico(Stack<Token> entrada) {
        this.entrada = entrada;

    }

    public String analisar(JTable tabelaSintatica, JTable tabelaLexica) {
        producao.setNome("programa");
        producao.setCodigo(id.identReservada("programa"));
        pilhaprod.push(producao);
        Inverter inv = new Inverter();
        inv.inverte(entrada);
        entrada = inv.pilha();
        erro= "sucesso";

        while (!pilhaprod.empty()) {
            entradacod = entrada.peek().getCodigo();
            prodcod = pilhaprod.peek().getCodigo();

            if (entrada.empty()) {
                erro = "pilha de tokens esta vazia e ainda existe producoes";
                inv.inverte(pilhaprod);
                tabelaSintatica tab = new tabelaSintatica(inv.pilha());
                tabelaSintatica.setModel(tab);
                break;

            } else if (pilhaprod.peek().getCodigo() < 52) {

                if (entrada.peek().getCodigo() == pilhaprod.peek().getCodigo()) {
                    entrada.pop();
                    pilhaprod.pop();
                } else {

                    erro = ("\n erro na linha: " + entrada.peek().getLinha() + " era esperado um:  " + pilhaprod.peek().getNome());
                    inv.inverte(pilhaprod);
                    tabelaSintatica tabela = new tabelaSintatica(inv.pilha());
                    tabelaSintatica.setModel(tabela);
                    tabelaLexica tab = new tabelaLexica(entrada);
                    tabelaLexica.setModel(tab);
                    break;

                }
            } else {

                TabelaProducao tabela = new TabelaProducao();
                String derivaçao = tabela.getDerivacao(prodcod, entradacod);
                pilhaprod.pop();

                if (derivaçao == null) {
                    continue;

                }
                String[] prodsepar = derivaçao.split("\\|");
                if (prodsepar[0].equals("NULL")) {
                    continue;
                }
                for (int i = prodsepar.length - 1; i >= 0; i--) {
                    producao = new Token();
                    producao.setCodigo(id.identReservada(prodsepar[i]));
                    producao.setNome(prodsepar[i]);
                    pilhaprod.push(producao);
                }

            }
        }
         
        return erro;
    }
}
