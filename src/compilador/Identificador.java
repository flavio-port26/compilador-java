/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author User
 */
public class Identificador {

    public Identificador(String token) {

    }

    public int identOperadores(String token) {
        Map<String, Integer> resevadas = new HashMap<>();
        return 0;
    }

    public int identRelacionais(String token) {
        return 0;
    }

    public int identReservada(String token) {
        int cod = 25;
        Map<String, Integer> resevadas = new HashMap<>();
        resevadas.put("program", 1);
        /*resevadas.put(2, "Label");
        resevadas.put(3, "Const");
        resevadas.put(4, "Var");
        resevadas.put(5, "Procedure");
        resevadas.put(6, "Begin");
        resevadas.put(7, "End");
        resevadas.put(8, "Integer");
        resevadas.put(9, "Array");
        resevadas.put(10, "Of");
        resevadas.put(11, "Call");
        resevadas.put(12, "Goto");
        resevadas.put(13, "If");
        resevadas.put(14, "Then");
        resevadas.put(15, "Else");
        resevadas.put(16, "While");
        resevadas.put(17, "Do");
        resevadas.put(18, "Repeat");
        resevadas.put(19, "Until");
        resevadas.put(20, "Readln");
        resevadas.put(21, "Writeln");
        resevadas.put(22, "Or");
        resevadas.put(23, "And");
        resevadas.put(24, "Not");
        resevadas.put(25, "Identificador");
        resevadas.put(26, "Inteiro");
        resevadas.put(27, "For");
        resevadas.put(28, "To");
        resevadas.put(29, "Case");
        resevadas.put(30, "+");
        resevadas.put(31, "-");
        resevadas.put(32, "*");
        resevadas.put(33, "/");
        resevadas.put(34, "[");
        resevadas.put(35, "]");
        resevadas.put(36, "(");
        resevadas.put(37, ")");
        resevadas.put(38, ":=");
        resevadas.put(39, ":");
        resevadas.put(40, "=");
        resevadas.put(41, ">");*/
        
        if (resevadas.containsKey(token.toLowerCase())) {
            return resevadas.get(token.toLowerCase());
        } else if (Integer) {
            return 26;
        } else {
            return 25;
        }
    }

}
