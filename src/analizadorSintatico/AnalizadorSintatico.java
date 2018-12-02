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

    Stack<Token> entrada;
    Stack<Token> pilhaprod = new Stack();
    Token producao = new Token();
    Verificador id = new Verificador();

    public AnalizadorSintatico(Stack<Token> entrada) {
        this.entrada = entrada;

    }

  public String analisar(JTable tabelaSintatica, JTable tabelaLexica) throws Exception {
        producao.setNome("programa");
        producao.setCodigo(id.identReservada("programa"));
        pilhaprod.push(producao);
        Inverter inv = new Inverter();
        inv.inverte(entrada);
        entrada = inv.pilha();
        
        if(entrada.peek().getCodigo() != 1) throw new Exception("Esperado 'Program'");
        
        int entradacod;
        int prodcod;
        while (!pilhaprod.empty()) {
              entradacod = entrada.peek().getCodigo();
              prodcod = pilhaprod.peek().getCodigo();

            if (entrada.empty()) {
                tabelaSintatica tab = new tabelaSintatica(pilhaprod);
                tabelaSintatica.setModel(tab);
                throw new Exception("pilha de tokens esta vazia e ainda existe producoes");
            } else if (pilhaprod.peek().getCodigo() < 52) {
                if (entrada.peek().getCodigo() == pilhaprod.peek().getCodigo()) {
                    entrada.pop();
                    pilhaprod.pop();
                } else {
                    tabelaSintatica tabela = new tabelaSintatica(pilhaprod);
                    tabelaSintatica.setModel(tabela);
                    tabelaLexica tab = new tabelaLexica(entrada);
                    tabelaLexica.setModel(tab); 
                    throw new Exception("Erro na linha: " + entrada.peek().getLinha() + "\nEra esperado um '" + pilhaprod.peek().getNome() + "'");
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
        if (pilhaprod.empty() && !entrada.empty()) {
            tabelaLexica tab = new tabelaLexica(entrada);
            tabelaLexica.setModel(tab);
            throw new Exception("A pilha de producoes esta vazia era esperado um program");
        }
        return "ANALIZADOR SINTATICO Executado com sucesso";
    }
}
