/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

/**
 *
 * @author João Vitor Malvestio
 */
public enum Status {
    OK("OK"),
    FAINTED("FAINTED"),    
    BURN("BURN"),
    FROZEN("FROZEN"),
    PARALYSIS("PARALYSIS"),
    POISON("POISON"),
    SLEEP("SLEEP");       
  
    private final String nome;
    
    private Status(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
}
