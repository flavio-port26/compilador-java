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
import analizadorSintatico.tabelaSintatica;
import javax.swing.JTable;

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

  public String analisar(JTable tabelaSintatica, JTable tabelaLexica) {
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
              entradacod = entrada.peek().getCodigo();
              prodcod = pilhaprod.peek().getCodigo();

            if (entrada.empty()) {
                erro = "pilha de tokens esta vazia e ainda existe producoes";
                tabelaSintatica tab = new tabelaSintatica(pilhaprod);
                tabelaSintatica.setModel(tab);
                break;

            } else if (pilhaprod.peek().getCodigo() < 52) {

                if (entrada.peek().getCodigo() == pilhaprod.peek().getCodigo()) {
                    entrada.pop();
                    pilhaprod.pop();
                } else {

                    erro = ("\n erro na linha: " + entrada.peek().getLinha() + "era esperado um " + pilhaprod.peek().getNome());
                    tabelaSintatica tabela = new tabelaSintatica(pilhaprod);
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
        if(erro!="") {
           erro +=" ";
        }
        else if (!entrada.empty()) {
            tabelaLexica tab = new tabelaLexica(pilhaprod);
                tabelaLexica.setModel(tab);

        } else if (pilhaprod.empty() && !entrada.empty()) {
            erro = "A pilha de producoes esta vazia era esperado um program";

        }
        else{
            erro = "executado com sucesso";
            
        }
 
      return erro;
    }
}
