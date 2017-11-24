/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlejogo;

/**
 *
 * @author joaov
 */
public enum Celula {
    VAZIA("-",0),
    JOGADOR_1("X",1),
    JOGADOR_2("O",-1);
    
    private final String marca;
    private final int valor;
    
    Celula(String marca, int valor){
        this.marca = marca;
        this.valor = valor;
    }
    
    String getMarca(){
        return marca;
    }
    
    int getValor(){
        return valor;
    }
}
