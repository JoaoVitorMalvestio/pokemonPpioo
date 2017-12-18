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
public class AtaqueModifier extends Ataque {
    private String mod;
    private int n;
    private int chance;
    
    public AtaqueModifier(String[] parametros){
        super(parametros);
        
        this.mod = parametros[7].split(",")[0].trim();
        this.n = parseInt(parametros[7].split(",")[1].trim());
        this.chance = parseInt(parametros[7].split(",")[2].trim());
    }
    
    public void efeito(Pokemon aliado,Pokemon inimigo){
        this.setPpAtual(this.getPpAtual() - 1);
        
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " usou " + this.getNome(), "", JOptionPane.PLAIN_MESSAGE);
        
        if (!this.calculoAcerto(aliado.calculoAccuracyEvasion(aliado.getModifierAccuracy()), inimigo.calculoAccuracyEvasion(inimigo.getModifierEvasion()), aliado.getStatus(), aliado.isFlinch())){
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " errou o ataque!", "", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        boolean critico = calculoCritico(aliado.getSpd());
        
        double dano = calculoDano(aliado,inimigo,critico);
        
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
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " acertou o ataque e deu " + dano + " de dano!", "", JOptionPane.PLAIN_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " acertou o ataque e deu " + dano + " de dano!" +
                                          (critico?"\nFoi um ataque critico!":""), "", JOptionPane.PLAIN_MESSAGE);
        
        double rand = Math.random()*100;
 
        if (this.chance<rand) return;
        
        if (this.mod.equals("Accuracy")) inimigo.setModifierAccuracy(inimigo.getModifierAccuracy()+this.n);
        if (this.mod.equals("Evasion")) inimigo.setModifierAccuracy(inimigo.getModifierAccuracy()+this.n);
        if (this.mod.equals("ATK")) inimigo.setModifierAtk(inimigo.getModifierAtk()+this.n);
        if (this.mod.equals("DEF")) inimigo.setModifierDef(inimigo.getModifierDef()+this.n);
        if (this.mod.equals("SPD")) inimigo.setModifierSpd(inimigo.getModifierSpd()+this.n);
        if (this.mod.equals("SPE")) inimigo.setModifierSpe(inimigo.getModifierSpe()+this.n);
        
        JOptionPane.showMessageDialog(null,inimigo.getEspecie().getNome() + " teve seu atributo " + this.mod + " modificado em " + this.n + "!", "", JOptionPane.PLAIN_MESSAGE);        
    }
    
}
