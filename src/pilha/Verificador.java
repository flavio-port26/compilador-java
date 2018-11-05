/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilha;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author User
 */
public class Verificador {
    public int identReservada(String token) {
        
        Map<String, Integer> resevadas = new HashMap<>();
        resevadas.put("program",1);
        resevadas.put("label",2);
        resevadas.put("const",3);
        resevadas.put("var",4);
        resevadas.put("procedure",5);
        resevadas.put("begin",6);
        resevadas.put("end",7);
        resevadas.put("integer",8);
        resevadas.put("array",9);
        resevadas.put("of",10);
        resevadas.put("call", 11);
        resevadas.put("goto", 12);
        resevadas.put("if", 13);
        resevadas.put("then", 14);
        resevadas.put("else", 15);
        resevadas.put("while", 16);
        resevadas.put("do", 17);
        resevadas.put("repeat", 18);
        resevadas.put("until", 19);
        resevadas.put("readln", 20);
        resevadas.put("writeln", 21);
        resevadas.put("or", 22);
        resevadas.put("and", 23);
        resevadas.put("not", 24);
        resevadas.put("inteiro", 26);
        resevadas.put("for", 27);
        resevadas.put("to", 28);
        resevadas.put("case", 29);
        resevadas.put("+", 30);
        resevadas.put("-", 31);
        resevadas.put("*", 32);
        resevadas.put("/", 33);
        resevadas.put("[", 34);
        resevadas.put("]", 35);
        resevadas.put("(", 36);
        resevadas.put(")", 37);
        resevadas.put(":=", 38);
        resevadas.put(":", 39);
        resevadas.put("=", 40);
        resevadas.put(">", 41);
        resevadas.put(">=", 42);
        resevadas.put("<", 43);
        resevadas.put("<=", 44);
        resevadas.put("<>", 45);
        resevadas.put(",", 46);
        resevadas.put(";", 47);
        resevadas.put("literal", 48);
        resevadas.put(".", 49);
        resevadas.put("..", 50);
        resevadas.put("$", 51);
        resevadas.put("programa", 52);
        resevadas.put("bloco", 53);
        resevadas.put("dclrot", 54);
        resevadas.put("lid", 55);
        resevadas.put("repident", 56);
        resevadas.put("dclconst", 57);
        resevadas.put("ldconst", 58);
        resevadas.put("dclvar", 59);
        resevadas.put("ldvar", 60);
        resevadas.put("tipo", 61);
        resevadas.put("dclproc", 62);
        resevadas.put("defpar", 63);
        resevadas.put("corpo", 64);
        resevadas.put("repcomando", 65);
        resevadas.put("comando", 66);
        resevadas.put("rcomid", 67);
        resevadas.put("rvar", 68);
        resevadas.put("parametros", 69);
        resevadas.put("reppar", 70);
        resevadas.put("elseparte", 71);
        resevadas.put("variavel", 72);
        resevadas.put("variavel1", 73);
        resevadas.put("repvariavel", 74);
        resevadas.put("itemsaida", 75);
        resevadas.put("repitem", 76);
        resevadas.put("expressao", 77);
        resevadas.put("repexpsimp", 78);
        resevadas.put("expsimp", 79);
        resevadas.put("repexp", 80);
        resevadas.put("termo", 81);
        resevadas.put("reptermo", 82);
        resevadas.put("fator", 83);
        resevadas.put("condcase", 84);
        resevadas.put("contcase", 85);
        resevadas.put("rpinteiro", 86);
        

        if (resevadas.containsKey(token.toLowerCase())) {
            return resevadas.get(token.toLowerCase());
        } 
         else {
            return 25;
        }
    }

}
