/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico;

import java.util.ArrayList;
import java.util.Stack;
import pilha.Inverter;
import pilha.Token;

/**
 *
 * @author comp15
 */
public class AnalizadorSemantico {

    public void analiza(Stack<Token> vpilha) {
        Inverter inv = new Inverter();
        Stack<Token> pilha = new Stack<>();
        inv.inverte(vpilha);
        pilha = inv.pilha();
        int nivel = 1;
        String tipo;
        String categoria = "";
        int entrada;
        ArrayList<Variaveis> variaveis = new ArrayList<>();

        while (!pilha.isEmpty()) {
            nivel = 1;
            entrada = pilha.pop().getCodigo();
            switch (entrada) {
                case 2:
                    categoria = "label";
                    tipo = "label";
                    entrada = pilha.pop().getCodigo();
                    while (!isParada(entrada)) {
                        entrada = pilha.peek().getCodigo();
                        if (entrada == 25) {
                            //adicionar o verificador
                            Variaveis var = new Variaveis();
                            var.setNivel(nivel);
                            var.setCategoria(categoria);
                            var.setTipo(tipo);
                            var.setNome(pilha.peek().getNome().toLowerCase());
                            variaveis.add(var);
                            pilha.pop();
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
                            if(variaveis.contains(pilha.peek().getNome())){
                                Variaveis varn = new Variaveis();
                                varn= variaveis.iterator().next();
                                
                                        }
                            Variaveis var = new Variaveis();
                            var.setNivel(nivel);
                            var.setCategoria(categoria);
                            var.setTipo(tipo);
                            var.setNome(pilha.peek().getNome().toLowerCase());
                            variaveis.add(var);
                            pilha.pop();
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
                            //adicionar o verificador
                            Variaveis var = new Variaveis();
                            var.setNivel(nivel);
                            var.setCategoria(categoria);
                            var.setTipo(tipo);
                            var.setNome(pilha.peek().getNome().toLowerCase());
                            variaveis.add(var);
                            pilha.pop();
                        }
                        pilha.pop();
                    }
                    break;
                default:
                    break;
            }
            if (entrada == 5) {
                nivel = 2;
                categoria = "procedure";
                tipo = "verificar";
                entrada = pilha.pop().getCodigo();
                while (!isParada(entrada)) {
                    entrada = pilha.peek().getCodigo();
                    if (entrada == 25) {
                        //adicionar o verificador
                        Variaveis var = new Variaveis();
                        var.setNivel(nivel);
                        var.setCategoria(categoria);
                        var.setTipo(tipo);
                        var.setNome(pilha.peek().getNome().toLowerCase());
                        variaveis.add(var);
                        pilha.pop();
                    }
                    pilha.pop();
                }
            }

        }

    }

    public boolean isParada(int nome) {
        return nome == 2 || nome == 3 || nome == 4 || nome == 5 || nome == 6;

    }

}
