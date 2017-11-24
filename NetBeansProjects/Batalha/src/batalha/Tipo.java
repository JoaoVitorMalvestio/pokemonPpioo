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
public enum Tipo {
    None(""),
    Bug("BUG"),
    Dragon("DRAGON"),
    Electric("ELECTRIC"),
    Fighting("FIGHTING"),
    Fire("FIRE"),
    Flying("FLYING"),
    Ice("ICE"),
    Ghost("GHOST"),
    Grass("GRASS"),
    Ground("GROUND"),
    Normal("NORMAL"),
    Poison("POISON"),
    Psychic("PSYCHIC"),
    Rock("ROCK"),    
    Water("WATER");
  
    private final String nome;
    
    private Tipo(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
}
