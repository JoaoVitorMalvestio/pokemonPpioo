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
        int i = 0;
        
        //Definir tamanho do array de pokemons
        for (Pokemon pokemon : listaPokemon) if (pokemon!=getPrimeiroPokemon() && pokemon.getStatus() != Status.FAINTED) i++;

        String[] listaPkm = new String[i];
        
        i = 0;
        
        for (Pokemon pokemon : listaPokemon) {
            if (pokemon!=getPrimeiroPokemon() && pokemon.getStatus() != Status.FAINTED){
                listaPkm[i] = pokemon.getEspecie().getNome() + "  HP: " + pokemon.getHpAtual() + "  Status: " + pokemon.getStatus().getNome();
                i++;
            }
        }
        
        JOptionPane.showInputDialog(null,"Qual pokemon deseja usar?", "", JOptionPane.PLAIN_MESSAGE,null, listaPkm,"");
    }
    
    public void usarAtaque(){
        int i = 0;
        
        Pokemon pokemon = this.getPrimeiroPokemon();
        
        for (Ataque ataque : pokemon.getListaAtaque()) if (ataque.getPpAtual()!=0) i++;


        String[] listaAtaque = new String[i];
        
        i = 0;
        
        for (Ataque ataque : pokemon.getListaAtaque()){
            if (ataque.getPpAtual()!=0) listaAtaque[i++] = ataque.getNome() + "  PP: " + ataque.getPpAtual() + "  Tipo: " + ataque.getTipo().getNome();
        }
        
        JOptionPane.showInputDialog(null,"Qual ataque deseja usar?", "", JOptionPane.PLAIN_MESSAGE,null, listaAtaque,"");

    }    

    public List getListaPokemon(){
        return this.listaPokemon;
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
