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
    None("",-1),
    Normal("NORMAL",0),
    Fighting("FIGHTING",1),
    Flying("FLYING",2),
    Poison("POISON",3),
    Ground("GROUND",4),
    Rock("ROCK",5),
    Bug("BUG",6),
    Ghost("GHOST",7),
    Fire("FIRE",8),
    Water("WATER",9),
    Grass("GRASS",10),
    Electric("ELECTRIC",11),
    Psychic("PSYCHIC",12),
    Ice("ICE",13),
    Dragon("DRAGON",14);
  
    private final String nome;
    private final int idx;
    
    private Tipo(String nome, int idx){
        this.nome = nome;
        this.idx = idx;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getIdx(){
        return idx;
    }
}
