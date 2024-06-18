package com.autobots.sistema.models;

public class StringNullVerificador {
    
    public boolean verificar(String dado){
        
        boolean ehNulo = true;
        
        if(!(dado == null)){
            
            if (!dado.isBlank()) {
                ehNulo = false;
            }
        }

        return ehNulo;
    }
}
