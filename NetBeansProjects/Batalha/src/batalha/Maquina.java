/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import java.util.List;
import java.util.Random;

/**
 *
 * @author joaov
 */
public class Maquina extends Jogador{   
    public Maquina(int idJogador){
        super(idJogador);  
    }
    
    @Override
    public int escolherComando(Pokemon pkm){
        return 1;
    }
    
    @Override
    public void usarAtaque(Pokemon pkmInimigo){
        Random rand = new Random();
        List<Ataque> listaAtk = this.getPrimeiroPokemon().getListaAtaque();
        Ataque ataqueRandomico = null;
        
        while(ataqueRandomico==null){
            int i = rand.nextInt(listaAtk.size());
            ataqueRandomico = listaAtk.get(i);
            //if (ataqueRandomico.getPpAtual()==0) ataqueRandomico = null;
        }
        
        ataqueRandomico.efeito(this.getPrimeiroPokemon(), pkmInimigo);
    }
}
