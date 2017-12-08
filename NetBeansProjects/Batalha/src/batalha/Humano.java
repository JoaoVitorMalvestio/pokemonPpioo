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
    
    @Override    
    public int escolherComando(int numJogador){
        Object[] opcoes = {"Trocar Pokemon","Realizar Ataque"};
        int retorno;                
        
        retorno = (JOptionPane.showOptionDialog(null, "O que o jogador " + numJogador + " ira fazer?", "",
               JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, opcoes, opcoes[0]));        
        
        if (retorno!=0&&retorno!=1) Batalha.fechaJogo();
        
        return retorno;
    }
}
