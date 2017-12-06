/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;
/**
 *
 * @author joaov
 */
public class Ataque {
    private int id;
    private String nome;
    private double ppMax;
    private double ppAtual;
    private double power;
    private double accuracy;
    
    public Ataque(String[] parametros){
        
        
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
    private Tipo tipo;
    
    public void efeito(){
        
    }
    
    public boolean calculoCritico(){
        return false;
    }
    
    public boolean calculoAcerto(){
        return false;
    }
    
    public double calculoDano(){
        return 0;
    }
}
