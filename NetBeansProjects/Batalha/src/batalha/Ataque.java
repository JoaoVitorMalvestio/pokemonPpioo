/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import static javax.xml.bind.DatatypeConverter.parseDouble;

/**
 *
 * @author joaov
 */
public class Ataque {
    private int id;
    private String nome;
    private Tipo tipo;
    private double ppMax;
    private double ppAtual;
    private double power;
    private double accuracy;
    
    public Ataque(String[] parametros){
        this.id   = parseInt(parametros[0]);
        this.nome = parametros[1];
        this.tipo = Tipo.valueOf(parametros[2]);
        this.ppMax = parseDouble(parametros[3]);
        this.ppAtual = this.ppMax;
        this.power = parseDouble(parametros[4]);
        this.accuracy = parseDouble(parametros[5]);      
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPpMax() {
        return ppMax;
    }

    public double getPpAtual() {
        return ppAtual;
    }

    public double getPower() {
        return power;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
    public void efeito(Pokemon aliado,Pokemon inimigo){
        this.ppAtual--;
        
        if (!this.calculoAcerto(aliado.calculoAccuracyEvasion(aliado.getModifierAccuracy()), inimigo.calculoAccuracyEvasion(inimigo.getModifierEvasion()), aliado.getStatus(), aliado.isFlinch())){
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " errou o ataque!", "", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        double dano = calculoDano(aliado,inimigo);
        double hpAtual = Math.abs(inimigo.getHpAtual() - dano);
        
        inimigo.setHpAtual(hpAtual);
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " acertou o ataque e deu " + dano + " de dano!", "", JOptionPane.PLAIN_MESSAGE);
    }
    
    public boolean calculoCritico(double spdAliado){
        double isCritico = spdAliado/512;
        if(isCritico > Math.random()){
            return true;
        }else{
          return false;  
        }
    }
    
    public boolean calculoAcerto(double modifierAccuracy, double modifierEvasion, Status status, boolean flinch){
        System.out.println(modifierAccuracy + " - " +  modifierEvasion + " - " + status.getNome() + " - " + flinch);
        
        double isHit = this.accuracy * (modifierAccuracy/modifierEvasion);        
        double rand = Math.random()*100;
        
        if(status == Status.FROZEN || status == Status.SLEEP || flinch == true){
            rand = 100;
        }
        if(status == Status.PARALYSIS){
            rand += 25;
        }
        if(isHit > rand){
            return true;
        }else{
          return false;
        }
    }
    
    public double calculoDano(Pokemon aliado,Pokemon inimigo){
        boolean ehCritico = calculoCritico(aliado.getSpd());
        
        
        
        return 5;
    }
}
