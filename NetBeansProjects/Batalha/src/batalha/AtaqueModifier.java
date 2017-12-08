/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Integer.parseInt;

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
    
    @Override
    public void efeito(){
        
    }
    
}
