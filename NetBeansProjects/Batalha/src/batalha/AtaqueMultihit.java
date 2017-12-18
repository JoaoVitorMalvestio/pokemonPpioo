/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Integer.parseInt;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author joaov
 */
public class AtaqueMultihit extends Ataque{
    private int min;
    private int max;

    public AtaqueMultihit(String[] parametros){
        super(parametros);
        
        this.min = parseInt(parametros[7].split(",")[0].trim());
        this.max = parseInt(parametros[7].split(",")[1].trim());
    }
    
    public void efeito(Pokemon aliado,Pokemon inimigo){
        this.setPpAtual(this.getPpAtual() - 1);
        
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " usou " + this.getNome(), "", JOptionPane.PLAIN_MESSAGE);
        
        if (!this.calculoAcerto(aliado.calculoAccuracyEvasion(aliado.getModifierAccuracy()), inimigo.calculoAccuracyEvasion(inimigo.getModifierEvasion()), aliado.getStatus(), aliado.isFlinch())){
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " errou o ataque!", "", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        boolean critico = calculoCritico(aliado.getSpd());
        
        Random rand = new Random();
        int numAtaque = rand.nextInt((this.max - this.min) + 1) + this.min;
        
        double dano = 0;
        int i;
        
        for(i=1;i<numAtaque;i++) dano += calculoDano(aliado,inimigo,critico);                
        
        double randConfuso = Math.random()*100; 
        
        double hpAtual = 0;
        
        if (aliado.isConfusion() && randConfuso>50){
            hpAtual = aliado.getHpAtual() - dano;
            aliado.setHpAtual(hpAtual);
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " está confuso e se acertou, causando " + dano + " de dano em si mesmo!", "", JOptionPane.PLAIN_MESSAGE);
        }
        else {
            hpAtual = inimigo.getHpAtual() - dano;
        
            inimigo.setHpAtual(hpAtual);
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " acertou o ataque " + numAtaque + " vezes e deu " + dano + " de dano!", "", JOptionPane.PLAIN_MESSAGE);
        }   
    }
}
