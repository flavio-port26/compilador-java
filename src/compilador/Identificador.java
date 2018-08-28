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
    
   
    public int identOperadores(String token){
      Map<String,Integer> resevadas = new HashMap<>();
        return 0;
    }
    public int identRelacionais(String token){
        return 0;
    }

    public int identReservada(String token) {
        int cod = 25;
        Map<String,Integer> resevadas = new HashMap<>();
        resevadas.put( "AND",23);
        resevadas.put("ARRAY",23);
        resevadas.put("BEGIN",23);
        
        /*resevadas.put(23, "CALL");
        resevadas.put(23, "CASE");
        resevadas.put(23, "CONST");
        resevadas.put(23, "DO");
        resevadas.put(23, "ELSE");
        resevadas.put(23, "END");
        resevadas.put(23, "FOR");
        resevadas.put(23, "GOTO");
        resevadas.put(23, "IF");
        resevadas.put(23, "INTEGER");
        resevadas.put(23, "LABEL");
        resevadas.put(23, "NOT");
        resevadas.put(23, "OF");
        resevadas.put(23, "OR");
        resevadas.put(23, "PROCEDURE");
        resevadas.put(23, "PROGRAM");
        resevadas.put(23, "READLN");
        resevadas.put(23, "REPEAT");
        resevadas.put(23, "THEN");
        resevadas.put(23, "TO");
        resevadas.put(23, "UNTIL");
        resevadas.put(23, "VAR");
        resevadas.put(23, "WHILE");
        resevadas.put(23, "WRITELN");
       */
      if(resevadas.containsKey(token)){
          return cod=resevadas.get(token);
      }else
        return cod;
    }

}
