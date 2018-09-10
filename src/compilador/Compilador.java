package compilador;

import java.util.Locale;
import java.util.Stack;

public class Compilador {

    public static void main(String args[]) {

        String texto
                = "Procedure P;\n"
                + "Var\n"
                + " A :integer;\n"
                + "Begin\n"
                + " Readln(a);\n"
                + " If a=x then\n"
                + " z:=z+x\n"
                + " Else begin\n"
                + " Z:=z-x;\n"
                + " Call p;\n"
                + " End;\n"
                + "End;\n"
                + "Begin\n"
                + " Z:=0;\n"
                + " Readln(x,y);\n"
                + " If x>y then\n"
                + " Call p\n"
                + " Else\n"
                + " Z:=z+x+y;\n"
                + " Writeln(z); ";
        String pronta = "";
        Character prox = null;
        Character atual = null;
        Token token = null;
        Stack<Token> pilha = new Stack();
        Identificador id = new Identificador(texto);

        int cont = 0;
        Reservadas reservada = new Reservadas();

        for (int i = 0; i < texto.length(); i++) {

            atual = texto.charAt(i);
            cont++;
            if (!Character.isSpaceChar(atual)) {
                pronta += atual.toString();

                if (cont < texto.length()) {

                    prox = texto.charAt(cont);

                    if (cont == texto.length() - 1) {
                        if (Character.isSpaceChar(prox)) {
                            token = Token.novoToken();  //Manda para o identificador o que esta no pronta quando nao tem mais texto

                            token.setCodigo(id.identReservada(pronta));
                            token.setNome(pronta);
                            System.out.println(token);
                            pilha.push(token);
                            pronta = "";
                            i = i + 1;
                            cont = cont + 1;
                        }
                    } else if (pronta.equals("'")) {
                        int aux = i + 1;
                        atual = texto.charAt(aux);
                        pronta = atual.toString();

                        while (!atual.toString().equals("'")) {
                            aux++;
                            atual = texto.charAt(aux);
                            pronta += atual.toString();
                        }
                        token = Token.novoToken();
                        token.setCodigo(id.identReservada("literal"));
                        token.setNome(pronta);
                        System.out.println(token);
                        pilha.push(token);
                        pronta = "";
                        i = aux + 1;
                        cont = aux + 2;
                    } else if (Character.isSpaceChar(prox) || reservada.especiais(prox.toString())) {// |Manda para o  indentificador quando acha o prox for um espaço
                        if (reservada.passaInteiro(pronta)) {
                            token = Token.novoToken();  //Manda para o identificador o que esta no pronta quando nao tem mais texto
                            token.setNome(pronta);

                            pronta = "inteiro";
                            token.setCodigo(id.identReservada(pronta));
                            System.out.println(token);
                            pilha.push(token);
                            pronta = "";
                        } else {
                            token = Token.novoToken();
                            token.setCodigo(id.identReservada(pronta));
                            token.setNome(pronta);
                            pilha.push(token);
                            pronta = "";
                        }

                    } else if (reservada.relacionais(atual.toString())) {
                        if (reservada.relacionais(prox.toString())) {
                            pronta = prox.toString() + atual.toString();
                            token = Token.novoToken();
                            token.setCodigo(id.identReservada(pronta));
                            token.setNome(pronta);
                            System.out.println(token);
                            pilha.push(token);
                            pronta = "";
                        } else {
                            token = Token.novoToken();
                            token.setCodigo(id.identReservada(pronta));
                            token.setNome(pronta);
                            System.out.println(token);
                            pilha.push(token);
                            pronta = "";
                        }
                    } else if (reservada.especiais(pronta)) {
                        if (reservada.especiais(prox.toString())) {
                            pronta = prox.toString() + atual.toString();
                            token = Token.novoToken();
                            token.setCodigo(id.identReservada(pronta));
                            token.setNome(pronta);
                            System.out.println(token);
                            pilha.push(token);
                            pronta = "";
                        } else {
                            token = Token.novoToken();
                            token.setCodigo(id.identReservada(pronta));
                            token.setNome(pronta);

                            pilha.push(token);
                            pronta = "";
                        }
                    } else if (reservada.operadores(atual.toString())) {
                        token = Token.novoToken();
                        token.setCodigo(id.identReservada(pronta));
                        token.setNome(pronta);
                        System.out.println(token);
                        pilha.push(token);
                    } else if (reservada.operadores(prox.toString())) {
                        token = Token.novoToken();
                        token.setCodigo(id.identReservada(pronta));
                        token.setNome(pronta);
                        System.out.println(token);
                        pilha.push(token);
                    }

                }
            }
        }

    }
}
