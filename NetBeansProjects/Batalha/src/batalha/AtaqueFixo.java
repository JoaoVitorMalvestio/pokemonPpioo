/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

/**
 *
 * @author joaov
 */
public class AtaqueFixo extends Ataque{
    private String val;

    public AtaqueFixo(String[] parametros){
        super(parametros);
        
        this.val = parametros[7].split(",")[0].trim();       
    }
    
    @Override
    public void efeito(Pokemon aliado,Pokemon inimigo){
        this.setPpAtual(this.getPpAtual() - 1);
        
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " usou " + this.getNome(), "", JOptionPane.PLAIN_MESSAGE);
        
        if (!this.calculoAcerto(aliado.calculoAccuracyEvasion(aliado.getModifierAccuracy()), inimigo.calculoAccuracyEvasion(inimigo.getModifierEvasion()), aliado.getStatus(), aliado.isFlinch())){
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " errou o ataque!", "", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        double dano;
        
        if ("lvl".equals(this.val)){
            dano = aliado.getLevel();
        }
        else {
            dano = parseInt(this.val);
        }

        double randConfuso = Math.random()*100; 
        
        if (aliado.isConfusion() && randConfuso>50){
            double hpAtual = aliado.getHpAtual() - dano;
            aliado.setHpAtual(hpAtual);
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " está confuso e se acertou, causando " + dano + " de dano em si mesmo!", "", JOptionPane.PLAIN_MESSAGE);
        }
        else {
            double hpAtual = inimigo.getHpAtual() - dano;
        
            inimigo.setHpAtual(hpAtual);
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " acertou o ataque e deu " + dano + " de dano!", "", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
