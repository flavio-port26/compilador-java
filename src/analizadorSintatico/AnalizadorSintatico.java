/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintatico;

import java.util.Stack;

import pilha.Token;
import pilha.Verificador;

import pilha.Inverter;
import analizadorSintatico.tabelaSintatica;

/**
 *
 * @author comp15
 */
public class AnalizadorSintatico {

    Stack<Token> entrada;
    Stack<Token> pilhaprod = new Stack();
    Token producao = new Token();
    Verificador id = new Verificador();

    public AnalizadorSintatico(Stack<Token> entrada) {
        this.entrada = entrada;

    }

    public String analisar() {
        producao.setNome("programa");
        producao.setCodigo(id.identReservada("programa"));
        pilhaprod.push(producao);
        Inverter inv = new Inverter();
        inv.inverte(entrada);
        entrada = inv.pilha();
        String erro = "";
        int entradacod;
        int prodcod;

        while (!pilhaprod.empty()) {

            if (entrada.empty()) {
                erro = "pilha de tokens esta vazia e ainda existe producoes";
                tabelaSintatica tab = new tabelaSintatica(pilhaprod);
                break;

            } else if (pilhaprod.peek().getCodigo() < 52) {

                if (entrada.peek().getCodigo() == pilhaprod.peek().getCodigo()) {
                    entrada.pop();
                    pilhaprod.pop();
                } else {

                    erro = ("\n erro na linha: " + entrada.pop().getLinha() + "era esperado um " + pilhaprod.pop().getNome());
                    tabelaSintatica tabela = new tabelaSintatica(pilhaprod);
                    break;

                }
            } else {

                entradacod = entrada.peek().getCodigo();
                prodcod = pilhaprod.peek().getCodigo();
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
        } if (!entrada.empty()) {
                erro = "ainda tem tokens e nao ha mais producoes";
                tabelaSintatica tab = new tabelaSintatica(pilhaprod);
                
              

            }

        else if (pilhaprod.empty() && !entrada.empty()) {
            erro = "A pilha de producoes esta vazia era esperado um program";

        } else {
            erro = "executado com sucesso";
        }
        return erro;

    }
}
