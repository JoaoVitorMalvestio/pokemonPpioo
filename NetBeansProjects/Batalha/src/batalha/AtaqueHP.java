/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Double.parseDouble;
import javax.swing.JOptionPane;

/**
 *
 * @author joaov
 */
public class AtaqueHP extends Ataque{
    private String parametro;
    private double porcentagem;

    public AtaqueHP(String[] parametros){
        super(parametros);
        
        this.parametro = parametros[7].split(",")[0].trim();
        this.porcentagem = parseDouble(parametros[7].split(",")[1].trim());
    }
    
    @Override
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
        
        double valor = 0;
        
        if (this.parametro.equals("dano")){
            valor = dano * this.porcentagem;
        }
        else {
            valor = aliado.getHpMax() * this.porcentagem;
        }

        hpAtual = aliado.getHpAtual() + valor;
        
        aliado.setHpAtual(hpAtual);
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " recebeu " + valor + " de HP, totalizando " + aliado.getHpAtual() + "!", "", JOptionPane.PLAIN_MESSAGE);        
    }
}
