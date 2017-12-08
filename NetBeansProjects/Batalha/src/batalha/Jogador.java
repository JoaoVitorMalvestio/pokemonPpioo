/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author joaov
 */
public class Jogador {
    private List<Pokemon> listaPokemon = new ArrayList();
    
    public int escolherComando(int numJogador){
        //Função não usada
        return 0;
    }
    
    public void trocarPokemon(){
        
    }
    
    public void usarAtaque(){
        
    }        
    
    public void addPkmLista(Pokemon pokemon){
        listaPokemon.add(pokemon);
    }
    
    public boolean temPokemonVivo(){
        for (Pokemon pokemon : listaPokemon) {
            if (pokemon.getStatus()!=Status.FAINTED) return true;
        }
        
        return false;
    }
    
    public Pokemon getPrimeiroPokemon(){
        return listaPokemon.get(0);        
    }
}
