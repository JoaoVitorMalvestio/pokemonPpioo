/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Integer.parseInt;
import java.util.List;

/**
 *
 * @author joaov
 */
public class Pokemon {
    private int level;
    private double hpAtual;
    private double hpMax;
    private double atk;
    private double def;
    private double spe;
    private double spd;
    private int modifierAccuracy;
    private int modifierEvasion;
    private int modifierAtk;
    private int modifierDef;
    private int modifierSpe;
    private int modifierSpd;
    private boolean confusion;
    private boolean flinch;
    private Especie especie;
    private Status status = Status.OK;
    private List<Ataque> listaAtaque; 
    
    public Pokemon(Especie especie, String level, List<Ataque> listaAtaque){
        this.level = parseInt(level);
        this.especie = especie;
        this.hpMax = especie.Calculo_Atributo_Hp(especie.getBaseHp(), this.level);
        this.hpAtual = this.hpMax;      
        this.atk = especie.Calculo_Atributo_Base(especie.getBaseAtk(), this.level);
        this.def = especie.Calculo_Atributo_Base(especie.getBaseDef(), this.level);
        this.spe = especie.Calculo_Atributo_Base(especie.getBaseSpe(), this.level);
        this.spd = especie.Calculo_Atributo_Base(especie.getBaseSpd(), this.level);
        this.modifierAccuracy = 0;
        this.modifierEvasion = 0;
        this.modifierAtk = 0;
        this.modifierDef = 0;
        this.modifierSpe = 0;
        this.modifierSpd = 0;
        this.confusion = false;
        this.flinch = false;
        this.listaAtaque = listaAtaque;
    }

    public int getLevel() {
        return level;
    }

    public double getHpAtual() {
        return hpAtual;
    }

    public double getHpMax() {
        return hpMax;
    }

    public double getAtk() {
        return atk;
    }

    public double getDef() {
        return def;
    }

    public double getSpe() {
        return spe;
    }
    
    public double getSpd() {
        return spd;
    }

    public int getModifierAccuracy() {
        return modifierAccuracy;
    }

    public int getModifierEvasion() {
        return modifierEvasion;
    }

    public int getModifierAtk() {
        return modifierAtk;
    }

    public int getModifierDef() {
        return modifierDef;
    }

    public int getModifierSpe() {
        return modifierSpe;
    }

    public int getModifierSpd() {
        return modifierSpd;
    }

    public boolean isConfusion() {
        return confusion;
    }
    
    public void setConfusion(boolean flag) {
        this.confusion = flag;
    }

    public boolean isFlinch() {
        return flinch;
    }
    
    public void setFlinch(boolean flag) {
        this.flinch = flag;
    }

    public Especie getEspecie() {
        return especie;
    }

    public Status getStatus() {
        return status;
    }
    
    public void addAtaqueLista(Ataque ataque){
        
        
    }
  
    public double calculoAccuracyEvasion(int modificador){       
        switch ((modificador)){
            case -6: return 33;
            case -5: return 37;
            case -4: return 43;
            case -3: return 50;
            case -2: return 60;
            case -1: return 75;
            case 0: return 100;
            case 1: return 133;
            case 2: return 166;
            case 3: return 200;
            case 4: return 233;
            case 5: return 266;
            case 6: return 300;     
        }  
        return 0;
    }
    
    public void setHpAtual(double hpAtual) {
        if(hpAtual <= this.hpMax){
            this.hpAtual = hpAtual;
        }else{
            System.out.println("Vida do pokemon está completa!");
        }
        if(this.hpAtual <= 0){
            this.hpAtual = 0;
            this.status = Status.FAINTED;
        }
    }

    public List<Ataque> getListaAtaque() {
        return listaAtaque;
    }
      
    

    
}