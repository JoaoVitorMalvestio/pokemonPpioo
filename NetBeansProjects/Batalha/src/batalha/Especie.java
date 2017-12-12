/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import java.io.FileReader;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

/**
 *
 * @author João Vitor Malvestio
 */
public class Especie {
    private int id;
    private String nome;
    private double baseHp;
    private double baseAtk;
    private double baseDef;
    private double baseSpe;
    private double baseSpd;
    private Tipo tipo1;
    private Tipo tipo2;

    /*public Especie (int id, String nome, Tipo tipo1, Tipo tipo2, double baseHp, double baseAtk, double baseDef, double baseSpe, double baseSpd){
        this.id = id;
        this.nome = nome;
        this.baseHp = baseHp;
        this.baseAtk = baseAtk;
        this.baseDef = baseDef;
        this.baseSpe = baseSpe;
        this.baseSpd = baseSpd;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }*/
    
    public Especie (String[] parametros){
        if (parametros[3].equals("")) parametros[3] = "None";
        
        this.id      = parseInt(parametros[0]);
        this.nome    = parametros[1];
        this.tipo1   = Tipo.valueOf(parametros[2]);
        this.tipo2   = Tipo.valueOf(parametros[3]); 
        this.baseHp  = parseDouble(parametros[4]);
        this.baseAtk = parseDouble(parametros[5]);;
        this.baseDef = parseDouble(parametros[6]);
        this.baseSpe = parseDouble(parametros[7]);
        this.baseSpd = parseDouble(parametros[8]);
           
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
        
    public double getBaseHp(){
        return this.baseHp;
    }
            
    public double getBaseAtk(){
        return this.baseAtk;
    }
    
    public double getBaseDef(){
        return this.baseDef;
    }
            
    public double getBaseSpe(){
        return this.baseSpe;
    }
    
    public double getBaseSpd(){
        return this.baseSpd;
    }
            
    public Tipo getTipo1(){
        return this.tipo1;
    }
    
    public Tipo getTipo2(){
        return this.tipo2;
    }
    
    public double Calculo_Atributo_Base (double hp, int level){
        return 2 * hp * level / 100 + level + 10;
    }
    
    public double Calculo_Atributo_Hp (double base, int level){
        return 2 * base * level / 100 + 5;
    }
}
