/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Integer.parseInt;
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
