/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import javax.swing.JOptionPane;

/**
 *
 * @author joaov
 */
public class Humano extends Jogador{
    
    public Humano(int idJogador){
        super(idJogador);
    }
    
    @Override    
    public int escolherComando(Pokemon pkmInimigo){
        Object[] opcoes = {"Trocar Pokemon","Realizar Ataque"};
        int retorno;        
        String mensagem;
        Pokemon pkmAtual = this.getPrimeiroPokemon();
        
        mensagem = "O que o jogador " + this.idJogador + " ira fazer?\n" +
                   "Pokemon Atual: " + pkmAtual.toString() + "\n" +
                   "Pokemon Inimigo: " + pkmInimigo.toString();
               
        
        while(true){
            retorno = (JOptionPane.showOptionDialog(null, mensagem, "",
                       JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                      null, opcoes, opcoes[0]));        
        
            if (retorno!=0&&retorno!=1) Batalha.fechaJogo();
            
            if (retorno==0 && !this.podeTrocarPokemon()){
                JOptionPane.showMessageDialog(null, "Você nao está apto a trocar de pokemon.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }           
            break;
        }
        return retorno;
    }
}
