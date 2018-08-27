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
public class Classificador {

    Stack<String> pilha = new Stack<>();

    public Classificador(Stack<String> pilha) {
        this.pilha = pilha;
    }

    public void classifica() {
        Stack<String> aux = new Stack<>();
        aux = pilha;
        Map<String, Integer> token = new HashMap<String, Integer>();
        Map<Integer, Map> identificador = new HashMap<Integer, Map>();
        int i = 0;
        while (!aux.isEmpty()) {
            if (aux.pop() == "Program") {
                token.put("Program", 1);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Label") {
                token.put("Label", 2);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Const") {
                token.put("Const", 3);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Var") {
                token.put("Var", 4);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Procedure") {
                token.put("Procedure", 5);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Begin") {
                token.put("Begin", 6);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "End") {
                token.put("End", 7);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Integer") {
                token.put("Integer", 8);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Array") {
                token.put("Array", 9);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Of") {
                token.put("Of", 10);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Call") {
                token.put("Call", 11);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Goto") {
                token.put("Goto", 12);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "If") {
                token.put("If", 13);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Then") {
                token.put("Then", 14);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Else") {
                token.put("Else", 15);
                identificador.put(i++, token);                            
            }
            else if (aux.pop() == "While") {
                token.put("While", 16);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Do") {
                token.put("Do", 17);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Repeat") {
                token.put("Repeat", 18);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Until") {
                token.put("Until", 19);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Readln") {
                token.put("Readln", 20);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Writeln") {
                token.put("Writeln", 21);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Or") {
                token.put("Or", 22);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "And") {
                token.put("And", 23);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Not") {
                token.put("Not", 24);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Identificador") {
                token.put("Identificador", 25);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Inteiro") {
                token.put("Inteiro", 26);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "For") {
                token.put("For", 27);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "To") {
                token.put("To", 28);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "Case") {
                token.put("Case", 29);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "+ ") {
                token.put("+ ", 30);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "-") {
                token.put("-", 31);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "*") {
                token.put("*", 32);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "/") {
                token.put("/", 33);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "[") {
                token.put("[", 34);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "]") {
                token.put("]", 35);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "(") {
                token.put("(", 36);
                identificador.put(i++, token);
            }

            else if (aux.pop() == ")") {
                token.put(")", 37);
                identificador.put(i++, token);
            }
            else if (aux.pop() == ":=") {
                token.put(":=", 38);
                identificador.put(i++, token);
            }
            else if (aux.pop() == ":") {
                token.put(":", 39);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "=") {
                token.put("=", 40);
                identificador.put(i++, token);
            }
            else if (aux.pop() == ">") {
                token.put(">", 41);
                identificador.put(i++, token);
            }
            else if (aux.pop() == ">=") {
                token.put(">=", 42);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "<") {
                token.put("<", 43);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "<=") {
                token.put("<=", 44);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "<>") {
                token.put("<>", 45);
                identificador.put(i++, token);
            }
            else if (aux.pop() == ",") {
                token.put(",", 46);
                identificador.put(i++, token);
            }
            else if (aux.pop() == ";") {
                token.put(";", 47);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "literal") {
                token.put("literal", 48);
                identificador.put(i++, token);
            }
            else if (aux.pop() == ".") {
                token.put(".", 49);
                identificador.put(i++, token);

            }
            else if (aux.pop() == "..") {
                token.put("..", 50);
                identificador.put(i++, token);
            }
            else if (aux.pop() == "$") {
                token.put("$", 51);
                identificador.put(i++, token);
            }
            

        }

    }

}
