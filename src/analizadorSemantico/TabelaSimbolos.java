/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class TabelaSimbolos {

    private final ArrayList<Variaveis> tabela = new ArrayList<>();

    public void adicionaTabela(int nivel, String categoria, int tipo, String nome) {
        Variaveis var = new Variaveis();
        var.setNivel(nivel);
        var.setCategoria(categoria);
        var.setTipo(tipo);
        var.setNome(nome);
        tabela.add(var);
    }

    public void removeNivel2() {
        for (int i = 0; i < tabela.size(); i++) {
            if (tabela.get(i).getNivel() == 2) {
                tabela.remove(i);

            }
        }
    }

    public Variaveis buscaCategoria(String nome, int nivel) {
        Variaveis var = new Variaveis();
        for (int i = 0; i < tabela.size(); i++) {

            if (tabela.get(i).getNome().equals(nome)&& tabela.get(i).getNivel()== nivel) {
                var = tabela.get(i);
            }

        }
        return var;
    }

    public int buscaTabela(String nome) {
        for (int i = 0; i < tabela.size(); i++) {
            if (tabela.get(i).getNome().equals(nome)) {
                return tabela.get(i).getNivel();

            }
        }
        return 99;
    }
    public int buscaTipo(String nome) {
        for (int i = 0; i < tabela.size(); i++) {
            if (tabela.get(i).getNome().equals(nome)) {
                return tabela.get(i).getTipo();

            }
        }
        return 99;
    }

    public ArrayList pegaTabela() {
        return tabela;
    }
}
