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
public class AtaqueCharge extends Ataque{
    boolean estaCarregado;

    public AtaqueCharge(String[] parametros){
        super(parametros);  
        estaCarregado = false;
    }
    
    @Override
    public void efeito(Pokemon aliado,Pokemon inimigo){
        this.setPpAtual(this.getPpAtual() - 1);
        
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " usou " + this.getNome(), "", JOptionPane.PLAIN_MESSAGE);
        
        if (!estaCarregado){
            this.estaCarregado = !this.estaCarregado;
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " carregou o ataque " + this.getNome() + "!", "", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        boolean critico = calculoCritico(aliado.getSpd());
        
        double dano = calculoDano(aliado,inimigo,critico);
        
        double hpAtual = inimigo.getHpAtual() - dano;
        
        inimigo.setHpAtual(hpAtual);
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " acertou o ataque e deu " + dano + " de dano!", "", JOptionPane.PLAIN_MESSAGE);
    }
}
