/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import java.util.List;

/**
 *
 * @author joaov
 */
public class Pokemon {
    private int level;
    private double hpAtual;
    private double hdMax;
    private double atk;
    private double def;
    private double spe;
    private int modifierAccuuracy;
    private int modifierEvasion;
    private int modifierAtk;
    private int modifierDef;
    private int modifierSpe;
    private int modifierSpd;
    private boolean confusion;
    private boolean flinch;
    private Especie especie;
    private Status status = Status.OK;
    
    

    public int getLevel() {
        return level;
    }

    public double getHpAtual() {
        return hpAtual;
    }

    public double getHdMax() {
        return hdMax;
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

    public int getModifierAccuuracy() {
        return modifierAccuuracy;
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

    public boolean isFlinch() {
        return flinch;
    }

    public Especie getEspecie() {
        return especie;
    }

    public Status getStatus() {
        return status;
    }
    
    public addAtaqueLista(Ataque ataque){
        
    }

    public List<Ataque> getListaAtaque() {
        return listaAtaque;
    }
    private List<Ataque> listaAtaque;    
    

    
}
