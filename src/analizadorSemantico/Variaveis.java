/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSemantico;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author comp15
 */
public class Variaveis {

    String tipo;
    String categoria;
    String nome;
    int nivel;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String cod) {
        this.tipo = cod;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int categoria(String nome) {
        Map<String, Integer> categorias = new HashMap<>();
        categorias.put("program", 1);
        categorias.put("var", 2);
        categorias.put("const", 3);
        categorias.put("label", 4);
        categorias.put("procedure", 5);
           if (categorias.containsKey(nome.toLowerCase())) {
            return categorias.get(nome.toLowerCase());
        } 
         else {
            return 6;
        }
    }

}
