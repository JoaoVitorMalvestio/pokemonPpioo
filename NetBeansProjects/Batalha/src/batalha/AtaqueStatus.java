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
public class AtaqueStatus extends Ataque{
    private String status;
    private int chance;

    public AtaqueStatus(String[] parametros){
        super(parametros);
        
        this.status = parametros[7].split(",")[0].trim().toUpperCase();
        this.chance = parseInt(parametros[7].split(",")[1].trim());
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

        double rand = Math.random()*100;
 
        if (this.chance<rand) return;
        
        if (status.equals("Confusion")) inimigo.setConfusion(true);
        else
        if (status.equals("Flinch")) inimigo.setFlinch(true);
        else inimigo.setStatus(Status.valueOf(this.status));
        
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " alterou o status do " + inimigo.getEspecie().getNome() + " para " + this.status, "", JOptionPane.PLAIN_MESSAGE);
    }
}
